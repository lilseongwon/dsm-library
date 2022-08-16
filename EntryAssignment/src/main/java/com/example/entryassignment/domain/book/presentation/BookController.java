package com.example.entryassignment.domain.book.presentation;

import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminUpdateBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryBookInfoListResponse;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryNaverBookInfoResponse;
import com.example.entryassignment.domain.book.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final AdminAddBookService adminAddBookService;
    private final AdminUpdateBookService adminUpdateBookService;
    private final AdminDeleteBookService adminDeleteBookService;
    private final QueryNaverBookInfoService queryNaverBookInfoService;
    private final QueryBookInfoService queryBookInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addBook(@RequestBody @Valid AdminAddBookRequest request) {
        adminAddBookService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/update")
    public void updateBook(@RequestBody @Valid AdminUpdateBookRequest request) {
        adminUpdateBookService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{book-id}")
    public void deleteBook(@PathVariable(name = "book-id") Long id) {
        adminDeleteBookService.execute(id);
    }

    @GetMapping("/naverbook/{keyword}")
    public QueryNaverBookInfoResponse queryNaverBookInfo(@PathVariable String keyword) {
        return queryNaverBookInfoService.execute(keyword);
    }

    @GetMapping("/info/{keyword}")
    public QueryBookInfoListResponse queryBookInfo(@PathVariable String keyword) {
        return queryBookInfoService.execute(keyword);
    }
}
