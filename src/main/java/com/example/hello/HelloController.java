package com.example.hello;

import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // Confirms which Java and Spring Boot versions are actually running
    @GetMapping("/version")
    public Map<String, String> version() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("javaVersion", System.getProperty("java.version"));
        info.put("springBootVersion", SpringBootVersion.getVersion());
        return info;
    }
}