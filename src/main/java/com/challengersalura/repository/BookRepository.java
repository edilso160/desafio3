package com.challengersalura.repository;


import com.example.gutendexapiconsumer.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByLanguage(String language);
}
