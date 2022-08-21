package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyRepository;
import com.example.entryassignment.domain.apply.facade.ApplyFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.apply.presentation.dto.request.ApplyBookRequest;
import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyBookService {

    private final UserFacade userFacade;
    private final BookFacade bookFacade;
    private final ApplyFacade applyFacade;
    private final CheckBookExistInNaverService checkBookExistInNaverService;
    private final ApplyRepository applyRepository;

    public void execute(ApplyBookRequest request) {

        checkBookExistInNaverService.execute(request.getTitle(), request.getIsbn());

        bookFacade.checkBookExist(request.getIsbn());

        applyFacade.checkApplyExist(request.getIsbn());

        applyFacade.checkApplyCount();

        User user = userFacade.getCurrentUser();

        applyRepository.save(
                Apply.builder()
                        .title(request.getTitle())
                        .isbn(request.getIsbn())
                        .user(user)
                        .build());
        user.addCount();
    }
}
