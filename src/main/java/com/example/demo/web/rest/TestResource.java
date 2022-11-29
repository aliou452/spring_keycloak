package com.example.demo.web.rest;

import com.example.demo.client.keycloak.KeycloakService;
import com.example.demo.client.keycloak.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {


    private final KeycloakService keycloakService;

    public TestResource(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }


    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/user/keycloak")
    public ResponseEntity<Object> createKeycloakUser(@RequestBody UserDto user) {
        return keycloakService.createKeycloakUser(user);

    }
}
