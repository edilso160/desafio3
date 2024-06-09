package com.challengersalura.service;


import com.example.gutendexapiconsumer.entity.Book;
import com.example.gutendexapiconsumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void fetchAndSaveBooks(String author, String language) {
        String apiUrl = "https://gutendex.com/books?author=" + author + "&languages=" + language;
        BookResponse response = restTemplate.getForObject(apiUrl, BookResponse.class);

        if (response != null && response.getResults() != null) {
            List<Book> books = response.getResults();
            bookRepository.saveAll(books);
        }
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}

