package com.example.entryassignment.domain.book.facade;

import com.example.entryassignment.domain.book.exception.NoPermissionException;
import com.example.entryassignment.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AdminFacade {

    private final UserFacade userFacade;

    public void checkPermission() {
        if (!(Objects.equals(userFacade.getCurrentUser().getAccountId(), System.getenv("ADMIN"))))
            throw NoPermissionException.EXCEPTION;
    }
}
