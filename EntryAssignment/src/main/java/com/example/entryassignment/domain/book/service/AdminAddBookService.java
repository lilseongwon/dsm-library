package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.apply.domain.repository.ApplyRepository;
import com.example.entryassignment.domain.apply.facade.ApplyFacade;
import com.example.entryassignment.domain.apply.service.CheckBookExistInNaverService;
import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.facade.AdminFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminAddBookService {
    private final AdminFacade adminFacade;
    private final BookFacade bookFacade;
    private final BookRepository bookRepository;
    private final ApplyRepository applyRepository;
    private final ApplyFacade applyFacade;
    private final CheckBookExistInNaverService checkBookExistInNaverService;

    public void execute(AdminAddBookRequest request) {

        adminFacade.checkPermission();

        checkBookExistInNaverService.execute(request.getTitle(), request.getIsbn());

        bookFacade.checkBookExist(request.getIsbn());

        bookRepository.save(
                Book.builder()
                        .title(request.getTitle())
                        .picture(request.getPicture())
                        .author(request.getAuthor())
                        .isbn(request.getIsbn())
                        .publisher(request.getPublisher())
                        .genre(request.getGenre())
                        .build());

        if (applyRepository.findByIsbn(request.getIsbn()).isPresent()) {
            applyRepository.delete(applyFacade.getApplyBy(request.getIsbn()));
        }

    }
}
