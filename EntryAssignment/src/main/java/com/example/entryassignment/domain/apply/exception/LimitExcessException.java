package com.example.entryassignment.domain.apply.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class LimitExcessException extends CustomException {
    public static final CustomException EXCEPTION =
            new LimitExcessException();

    private LimitExcessException() {
        super(ErrorCode.LIMIT_EXCESS);
    }
}
