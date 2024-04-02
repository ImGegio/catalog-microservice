package com.catalog.catalogmicroservice.controller;

import com.catalog.catalogmicroservice.client.BookClient;
import com.catalog.catalogmicroservice.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    private BookClient bookClient;

    @GetMapping(value = "/get-all-books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return bookClient.getAllBooks();
    }
}
