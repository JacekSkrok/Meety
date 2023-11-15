package com.jacek.meety.controllers;

import com.jacek.meety.models.Host;
import com.jacek.meety.repositories.HostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hosts")
public class HostsController {

    @Autowired
    private HostRepository hostRepository;

    @GetMapping
    public List<Host> list() {
        return hostRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Host get(@PathVariable Long id) {
        return hostRepository.getReferenceById(id);
    }

    @PostMapping
    public Host create(@RequestBody final Host host) {
        return hostRepository.saveAndFlush(host);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        hostRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Host update(@PathVariable Long id, @RequestBody Host host) {
        //TODO: check if all data for Host were provided
        Host existingHost = hostRepository.getReferenceById(id);
        BeanUtils.copyProperties(host, existingHost, "hostId");
        return hostRepository.saveAndFlush(existingHost);
    }


}
