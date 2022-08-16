package com.example.entryassignment.domain.book.presentation.dto.response;

import com.example.entryassignment.domain.book.domain.Genre;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryBookInfoResponse {

    private final String title;

    private final String picture;

    private final String author;

    private final String isbn;

    private final String publisher;

    private final Genre genre;
}