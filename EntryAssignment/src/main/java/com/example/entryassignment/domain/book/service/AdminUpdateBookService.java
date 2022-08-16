package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.facade.AdminFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminUpdateBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminUpdateBookService {

    private final AdminFacade adminFacade;
    private final BookFacade bookFacade;

    @Transactional
    public void execute(AdminUpdateBookRequest request) {
        adminFacade.checkPermission();

        bookFacade.getBookByIsbn(request.getIsbn())
                .update(request.getPicture(), request.getAuthor(),
                        request.getPublisher(), request.getGenre());
    }
}
