package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class BookIsNotExistException extends CustomException {

    public static final BookIsNotExistException EXCEPTION =
            new BookIsNotExistException();

    private BookIsNotExistException() {
        super(ErrorCode.BOOK_IS_NOT_EXIST);
    }
}
