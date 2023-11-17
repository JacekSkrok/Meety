package com.jacek.meety.controllers;

import com.jacek.meety.exception.ResourceNotFoundException;
import com.jacek.meety.models.Appointment;
import com.jacek.meety.repositories.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {
    Logger logger = Logger.getLogger(AppointmentsController.class.getName());
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> list() {
        return appointmentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Appointment> get(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID" + id +" not found"));
                logger.log(Level.WARNING, "User with ID" + id +" not found");
        return ResponseEntity.ok().body(appointment);
    }


    @PostMapping
    public Appointment create(@RequestBody final Appointment appointment) {
        return appointmentRepository.saveAndFlush(appointment);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Appointment update(@PathVariable Long id, @RequestBody Appointment appointment) {
        //TODO: check if all data for Appointment were provided
        Appointment existingAppointment = appointmentRepository.getReferenceById(id);
        BeanUtils.copyProperties(appointment, existingAppointment, "appointmentI0d");
        return appointmentRepository.saveAndFlush(existingAppointment);
    }



}
