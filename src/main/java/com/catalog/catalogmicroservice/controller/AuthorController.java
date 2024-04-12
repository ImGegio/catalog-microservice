package com.catalog.catalogmicroservice.controller;

import com.catalog.catalogmicroservice.client.AuthorClient;
import com.catalog.catalogmicroservice.model.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorClient authorClient;


    @GetMapping(value = "/get-all-authors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        return authorClient.getAllAuthors();
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> getAuthorByName(@PathVariable("name") String name){
        return authorClient.getAuthorByName(name);
    }

    @PostMapping(value = "/insert-author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> insertAuthor(@RequestBody AuthorDto authorDto){
        return authorClient.insertAuthor(authorDto);
    }

    @PutMapping(value = "/update-author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto){
        return authorClient.updateAuthor(authorDto);
    }

    @DeleteMapping(value = "/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAuthor (@PathVariable("authorId") Long authorId){
        authorClient.deleteAuthor(authorId);
    }

}
