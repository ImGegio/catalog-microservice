package com.catalog.catalogmicroservice.client;

import com.catalog.catalogmicroservice.model.BookDto;
import com.catalog.catalogmicroservice.model.LoginRequest;
import com.catalog.catalogmicroservice.model.LoginResponse;
import com.catalog.catalogmicroservice.utils.BookApiMethodConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@ConfigurationProperties(value = "authapi", ignoreUnknownFields = false)
public class AuthClient {
    private final RestTemplate restTemplate;
    private String host;
    private String login;

    @Autowired
    public AuthClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setHost(String host) {
        this.host = host;
    }
    public void setLogin(String login) {
        this.login = login;
    }


    public ResponseEntity<LoginResponse> login(LoginRequest request){
        String url = String.valueOf(host + login);

        return restTemplate.postForEntity(url, request, LoginResponse.class);
    }
}
