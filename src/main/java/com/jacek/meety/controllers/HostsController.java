package com.jacek.meety.controllers;

import com.jacek.meety.models.Host;
import com.jacek.meety.repositories.HostRepository;
import com.jacek.meety.utils.ImageDecoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/hosts")
public class HostsController {

    @Autowired
    private HostRepository hostRepository;

    @GetMapping
    public List<Host> list() {
        List<Host> hosts = hostRepository.findAll();
        hosts.forEach(ImageDecoder::decodeImage);

        return hosts;
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Host> get(@PathVariable Long id) {
        Optional<Host> hostOptional = hostRepository.findById(id);

        if (hostOptional.isPresent()) {
            Host host = hostOptional.get();
            ImageDecoder.decodeImage(host);
            return ResponseEntity.ok().body(host);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @RequestMapping("/{id}/photo")
    public ResponseEntity<byte[]> getHostPhoto(@PathVariable Long id) {
        Optional<Host> hostOptional = hostRepository.findById(id);

        if (hostOptional.isPresent()) {
            Host host = hostOptional.get();
            if (host.getHostPhoto() != null) {
                byte[] photoData = host.getHostPhoto();
                byte[] decodedPhoto = Base64.getDecoder().decode(photoData);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG);

                return new ResponseEntity<>(decodedPhoto, headers, HttpStatus.OK);
            }
        }

        return ResponseEntity.notFound().build();
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
