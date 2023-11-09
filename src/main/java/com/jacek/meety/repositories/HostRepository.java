package com.jacek.meety.repositories;

import com.jacek.meety.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
