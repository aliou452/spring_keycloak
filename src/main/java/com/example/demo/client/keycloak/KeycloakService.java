package com.example.demo.client.keycloak;

import com.example.demo.client.keycloak.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface KeycloakService {

    ResponseEntity<Object> createKeycloakUser(UserDto userDto);
}
