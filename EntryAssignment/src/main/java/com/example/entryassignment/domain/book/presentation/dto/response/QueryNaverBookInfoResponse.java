package com.example.entryassignment.domain.book.presentation.dto.response;

import lombok.Data;

@Data
public class QueryNaverBookInfoResponse {


    private Integer display;
    private Item[] items;

    @Data
    static class Item {
        private String title;
        private String image;
        private String author;
        private String isbn;
        private String publisher;
    }
}
