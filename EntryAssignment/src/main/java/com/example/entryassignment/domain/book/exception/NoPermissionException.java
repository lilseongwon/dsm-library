package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class NoPermissionException extends CustomException {

    public static final NoPermissionException EXCEPTION =
            new NoPermissionException();

    private NoPermissionException() {
        super(ErrorCode.NO_PERMISSION);
    }
}
