package com.example.entryassignment.domain.apply.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class ApplyIsNotExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new ApplyIsNotExistException();

    private ApplyIsNotExistException() {
        super(ErrorCode.APPLY_IS_NOT_EXIST);
    }
}
