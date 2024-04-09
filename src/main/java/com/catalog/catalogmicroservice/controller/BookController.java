package com.catalog.catalogmicroservice.controller;

import com.catalog.catalogmicroservice.client.BookClient;
import com.catalog.catalogmicroservice.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookClient bookClient;


    //Pagina iniziale di esempio per le CRUD
    @GetMapping()
    public String example(Model model) {
        return "book";
    }


    @GetMapping(value = "/get-all-books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return bookClient.getAllBooks();
    }

    @GetMapping(value = "/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> getBookByTitle(@PathVariable("title") String title){
        return bookClient.getBookByTitle(title);
    }

    @PostMapping(value = "/insert-book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> insertBook(@RequestBody BookDto bookDto){
        return bookClient.insertBook(bookDto);
    }

    @PutMapping(value = "/update-book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        return bookClient.updateBook(bookDto);
    }

    @DeleteMapping(value = "/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBook (@PathVariable("bookId") Long bookId){
        bookClient.deleteBook(bookId);
    }

}
