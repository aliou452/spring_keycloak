package com.example.demo.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testResource {


    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Hello");
    }
}
