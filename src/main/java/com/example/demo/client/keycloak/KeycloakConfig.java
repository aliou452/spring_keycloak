package com.example.demo.client.keycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Value("${keycloak.serverUrl}")
    private String serverUrl;

    @Value("${keycloak.realm}")
    private String realmName;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Bean
    public KeycloakBuilder keycloakBuilder() {
        return KeycloakBuilder
                .builder()
                .serverUrl(serverUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .realm(realmName)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS);
    }
}
