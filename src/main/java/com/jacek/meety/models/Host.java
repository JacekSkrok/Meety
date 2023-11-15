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
    private Long hostId;
    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String hostBio;

    @Lob
    @JdbcTypeCode(Types.BINARY)
    private byte[] hostPhoto;

    @ManyToMany(mappedBy = "hosts")
    @JsonIgnore
    private List<Appointment> appointments;

    public Host() {}

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getHostBio() {
        return hostBio;
    }

    public void setHostBio(String hostBio) {
        this.hostBio = hostBio;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public byte[] getHostPhoto() {
        return hostPhoto;
    }

    public void setHostPhoto(byte[] hostPhoto) {
        this.hostPhoto = hostPhoto;
    }
}
