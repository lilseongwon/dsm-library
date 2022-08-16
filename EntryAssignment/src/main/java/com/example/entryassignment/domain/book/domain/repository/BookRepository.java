package com.example.entryassignment.domain.book.domain.repository;

import com.example.entryassignment.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findAllByTitleContains(String keyword);
}