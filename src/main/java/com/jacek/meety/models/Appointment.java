package com.jacek.meety.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "appointments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long appointmentId;
    private String appointmentName;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;
    private String appointmentDescription;
    private Integer appointmentLength;

    @ManyToMany
    @JoinTable(
            name = "appointment_hosts",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id"))
    private List<Host> hosts;
    public Appointment() {}

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }
    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public Integer getAppointmentLength() {
        return appointmentLength;
    }

    public void setAppointmentLength(Integer appointmentLength) {
        this.appointmentLength = appointmentLength;
    }

    public List<Host> getSpeakers() {
        return hosts;
    }

    public void setSpeakers(List<Host> hosts) {
        this.hosts = hosts;
    }
}
