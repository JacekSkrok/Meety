package com.jacek.meety.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {
    @Value("${app.version}")
    private String app_version;

    @GetMapping
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", app_version);
        return map;
    }
}
