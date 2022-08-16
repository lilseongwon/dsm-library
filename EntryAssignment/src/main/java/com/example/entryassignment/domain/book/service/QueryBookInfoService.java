package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryBookInfoListResponse;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryBookInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryBookInfoService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public QueryBookInfoListResponse execute(String keyword) {
        List<QueryBookInfoResponse> bookList = bookRepository.findAllByTitleContains(keyword)
                .stream()
                .map(this::bookBuilder)
                .collect(Collectors.toList());

        return new QueryBookInfoListResponse(bookList);
    }

    private QueryBookInfoResponse bookBuilder(Book book) {
        return QueryBookInfoResponse.builder()
                .title(book.getTitle())
                .picture(book.getPicture())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publisher(book.getPublisher())
                .genre(book.getGenre())
                .build();
    }
}
