package com.jacek.meety.repositories;

import com.jacek.meety.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM appointments a JOIN a.hosts h WHERE h.id = :hostId")
    List<Appointment> findByHostId(@Param("hostId") Long hostId);
}
