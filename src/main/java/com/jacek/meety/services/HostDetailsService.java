package com.jacek.meety.services;

import com.jacek.meety.models.Host;
import com.jacek.meety.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HostDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(HostDetailsService.class);

    @Autowired
    private HostRepository hostRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to load user by username: {}", username);
        Host host = hostRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.warn("User not found with username: {}", username);
                    return new UsernameNotFoundException("User not found");
                });
        logger.info("User found: {}", username);
        return host;
    }
}
