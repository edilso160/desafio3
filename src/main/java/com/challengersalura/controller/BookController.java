package com.challengersalura.controller;


import com.example.gutendexapiconsumer.entity.Book;
import com.example.gutendexapiconsumer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/fetch-books")
    public String fetchBooks(@RequestParam String author, @RequestParam String language) {
        bookService.fetchAndSaveBooks(author, language);
        return "Books fetched and saved!";
    }

    @GetMapping("/books/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/books/language")
    public List<Book> getBooksByLanguage(@RequestParam String language) {
        return bookService.findByLanguage(language);
    }
}
