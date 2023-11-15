package com.jacek.meety.controllers;

import com.jacek.meety.models.Appointment;
import com.jacek.meety.repositories.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> list() {
        return appointmentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Appointment get(@PathVariable Long id) {
        return appointmentRepository.getReferenceById(id);
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
        BeanUtils.copyProperties(appointment, existingAppointment, "appointmentId");
        return appointmentRepository.saveAndFlush(existingAppointment);
    }



}
