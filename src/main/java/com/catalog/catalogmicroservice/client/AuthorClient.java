package com.catalog.catalogmicroservice.client;

import com.catalog.catalogmicroservice.model.AuthorDto;
import com.catalog.catalogmicroservice.utils.AuthorApiMethodConstants;
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
@ConfigurationProperties(value = "authorapi", ignoreUnknownFields = false)
public class AuthorClient {
    private final RestTemplate restTemplate;
    private String host;
    private String controller;

    @Autowired
    public AuthorClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setHost(String host) {
        this.host = host;
    }
    public void setController(String controller) {
        this.controller = controller;
    }


    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        ParameterizedTypeReference<List<AuthorDto>> responseType = new ParameterizedTypeReference<List<AuthorDto>>() {};

        return restTemplate.exchange(host + controller + AuthorApiMethodConstants.GET_ALL, HttpMethod.GET, null, responseType);
    }
    public ResponseEntity<AuthorDto> getAuthorByName(String title){
        String url = String.valueOf(host + controller + "/" + title);
        AuthorDto response = restTemplate.getForObject(url, AuthorDto.class);

        return ResponseEntity.ok(response);
    }
    public ResponseEntity<AuthorDto> insertAuthor(AuthorDto authorDto){
        String url = String.valueOf(host + controller + AuthorApiMethodConstants.INSERT);
        ResponseEntity<AuthorDto> responseEntity = restTemplate.postForEntity(url, authorDto, AuthorDto.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }
    public ResponseEntity<AuthorDto> updateAuthor(AuthorDto authorDto){
        String url = String.valueOf(host + controller + AuthorApiMethodConstants.UPDATE);
        ResponseEntity<AuthorDto> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(authorDto), AuthorDto.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }
    public void deleteAuthor(Long authorId){
        String url = String.valueOf(host + controller + "/" + authorId);

        restTemplate.delete(url);
    }
}
