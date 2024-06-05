package com.jacek.meety.controllers;

import com.jacek.meety.exception.ResourceNotFoundException;
import com.jacek.meety.models.Appointment;
import com.jacek.meety.models.Host;
import com.jacek.meety.repositories.AppointmentRepository;
import com.jacek.meety.repositories.HostRepository;
import com.jacek.meety.utils.ImageDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private HostRepository hostRepository;

    @GetMapping
    public List<Appointment> list() {
        List<Host> hosts = hostRepository.findAll();
        hosts.forEach(ImageDecoder::decodeImage);
        return appointmentRepository.findAll();
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> getAppointmentsByHostId(@PathVariable Long hostId) {
        return appointmentRepository.findByHostId(hostId);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Appointment> get(@PathVariable Long id) throws ResourceNotFoundException {
        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id +" not found"));
        List<Host> hosts = hostRepository.findAll();
        hosts.forEach(ImageDecoder::decodeImage);
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
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) throws ResourceNotFoundException {
        if(appointment.getAppointmentLength() != null && appointment.getAppointmentName() != null) {
            appointmentRepository.findById(id).map(existingAppointment -> {
                        existingAppointment.setAppointmentName(appointment.getAppointmentName());
                        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
                        existingAppointment.setAppointmentStartTime(appointment.getAppointmentStartTime());
                        existingAppointment.setAppointmentDescription(appointment.getAppointmentDescription());
                        existingAppointment.setAppointmentLength(appointment.getAppointmentLength());

                        return appointmentRepository.save(existingAppointment);
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id +" not found"));
        }
        else {
            throw new ResourceNotFoundException("No sufficent data provided");
        }
        return ResponseEntity.ok().body(appointment);
    }



}
