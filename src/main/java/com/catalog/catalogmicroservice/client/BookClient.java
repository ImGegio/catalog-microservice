package com.catalog.catalogmicroservice.client;

import com.catalog.catalogmicroservice.model.BookDto;
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
@ConfigurationProperties(value = "bookapi", ignoreUnknownFields = false)
public class BookClient {
    private final RestTemplate restTemplate;
    private String host;
    private String controller;

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


    public ResponseEntity<List<BookDto>> getAllBooks(){
        ParameterizedTypeReference<List<BookDto>> responseType = new ParameterizedTypeReference<List<BookDto>>() {};

        return restTemplate.exchange(host + controller + BookApiMethodConstants.GET_ALL, HttpMethod.GET, null, responseType);
    }
    public ResponseEntity<BookDto> getBookByTitle(String title){
        String url = String.valueOf(host + controller + "/" + title);
        BookDto response = restTemplate.getForObject(url, BookDto.class);

        return ResponseEntity.ok(response);
    }
    public ResponseEntity<BookDto> insertBook(BookDto bookDto){
        String url = String.valueOf(host + controller + BookApiMethodConstants.INSERT);
        ResponseEntity<BookDto> responseEntity = restTemplate.postForEntity(url, bookDto, BookDto.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }
    public ResponseEntity<BookDto> updateBook(BookDto bookDto){
        String url = String.valueOf(host + controller + BookApiMethodConstants.UPDATE);
        ResponseEntity<BookDto> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(bookDto), BookDto.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }
    public void deleteBook(Long bookId){
        String url = String.valueOf(host + controller + "/" + bookId);

        restTemplate.delete(url);
    }
}
