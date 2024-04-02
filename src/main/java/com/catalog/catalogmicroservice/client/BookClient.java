package com.catalog.catalogmicroservice.client;

import com.catalog.catalogmicroservice.model.BookDto;
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
@ConfigurationProperties(value = "bookapi", ignoreUnknownFields = false)
public class BookClient {
    private final RestTemplate restTemplate;
    private String host;
    private String controller;
    private String getAll;

    @Autowired
    public BookClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setController(String controller) {
        this.controller = controller;
    }
    public void setGetAll(String getAll) {
        this.getAll = getAll;
    }


    public ResponseEntity<List<BookDto>> getAllBooks(){
        ParameterizedTypeReference<List<BookDto>> responseType = new ParameterizedTypeReference<List<BookDto>>() {};

        return restTemplate.exchange(host + controller + getAll, HttpMethod.GET, null, responseType);
    }
}
