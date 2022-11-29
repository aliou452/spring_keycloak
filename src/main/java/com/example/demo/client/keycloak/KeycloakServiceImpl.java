package com.example.demo.client.keycloak;

import com.example.demo.client.keycloak.dto.UserDto;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;


@Service
public class KeycloakServiceImpl implements KeycloakService {

    private final Logger log = LoggerFactory.getLogger(KeycloakServiceImpl.class);

    @Value("${keycloak.realm}")
    private String realmName;

    private final KeycloakBuilder keycloakBuilder;

    public KeycloakServiceImpl(KeycloakBuilder keycloakBuilder) {
        this.keycloakBuilder = keycloakBuilder;
    }

    @Override
    public ResponseEntity<Object> createKeycloakUser(UserDto userDto) {
        log.debug("Service to create user {} in keycloak", userDto);

        Keycloak keycloak = keycloakBuilder.build();
        UsersResource usersResource = keycloak.realm(realmName).users();
        UserRepresentation user = new UserRepresentation();

        user.setUsername(userDto.getUsername());
        Response response = usersResource.create(user);

        if (response.getStatus() == 201) {
            return ResponseEntity.created(response.getLocation()).build();
        }

        return ResponseEntity.badRequest().build();
    }
}
