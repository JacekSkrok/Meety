package com.jacek.meety.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "appointments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long appointment_id;
    private String appointment_name;
    private String appointment_description;
    private Integer appointment_length;

    @ManyToMany
    @JoinTable(
            name = "appointment_hosts",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id"))
    private List<Host> hosts;
    public Appointment() {}

    public Long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Long session_id) {
        this.appointment_id = appointment_id;
    }

    public String getAppointment_name() {
        return appointment_name;
    }

    public void setAppointment_name(String session_name) {
        this.appointment_name = appointment_name;
    }

    public String getAppointment_description() {
        return appointment_description;
    }

    public void setAppointment_description(String session_description) {
        this.appointment_description = appointment_description;
    }

    public Integer getAppointment_length() {
        return appointment_length;
    }

    public void setAppointment_length(Integer session_length) {
        this.appointment_length = appointment_length;
    }

    public List<Host> getSpeakers() {
        return hosts;
    }

    public void setSpeakers(List<Host> hosts) {
        this.hosts = hosts;
    }
}
