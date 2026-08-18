package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Resolves to ENV variable if present, defaulting to 'world'
    @Value("${ENV:world}")
    private String environment;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + environment;
    }
}
