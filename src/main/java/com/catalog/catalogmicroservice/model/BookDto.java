package com.catalog.catalogmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    private Long bookId;
    private String title;
    private String type;
    private LocalDate yearOfPublication;
    private Integer stock;
    private AuthorDto author;


}
