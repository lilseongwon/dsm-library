package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class AlreadyBookExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new AlreadyBookExistException();

    private AlreadyBookExistException() {
        super(ErrorCode.ALREADY_BOOK_EXIST);
    }
}
