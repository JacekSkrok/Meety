package com.jacek.meety.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.List;

@Entity(name = "hosts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long host_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String host_bio;

    @Lob
    @JdbcTypeCode(Types.BINARY)
    private byte[] host_photo;

    @ManyToMany(mappedBy = "hosts")
    @JsonIgnore
    private List<Appointment> appointments;

    public Host() {}

    public Long getHost_id() {
        return host_id;
    }

    public void setHost_id(Long host_id) {
        this.host_id = host_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHost_bio() {
        return host_bio;
    }

    public void setHost_bio(String host_bio) {
        this.host_bio = host_bio;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public byte[] getHost_photo() {
        return host_photo;
    }

    public void setHost_photo(byte[] host_photo) {
        this.host_photo = host_photo;
    }
}
