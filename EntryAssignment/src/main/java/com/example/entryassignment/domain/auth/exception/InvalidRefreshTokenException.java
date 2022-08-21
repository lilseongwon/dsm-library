package com.example.entryassignment.domain.auth.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}