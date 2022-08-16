package com.example.entryassignment.domain.book.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(length = 300, nullable = false)
    private String picture;

    @Column(length = 20, nullable = false)
    private String author;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(length = 20, nullable = false)
    private String publisher;

    @Column(length = 10, nullable = false)
    private Genre genre;

    @Builder
    public Book(String title, String picture, String author, String isbn, String publisher, Genre genre) {
        this.title = title;
        this.picture = picture;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.genre = genre;
    }

    public void update(String picture, String author, String publisher, Genre genre) {
        this.picture = picture;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
    }
}
