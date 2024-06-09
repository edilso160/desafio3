package com.challengersalura.service;

import com.example.gutendexapiconsumer.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookResponse {
    @JsonProperty("results")
    private List<Book> results;
}

