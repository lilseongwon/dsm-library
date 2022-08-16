package com.example.entryassignment.domain.apply.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class BookIsNotExistInNaverException extends CustomException {
    public static final BookIsNotExistInNaverException EXCEPTION =
            new BookIsNotExistInNaverException();

    private BookIsNotExistInNaverException() {
        super(ErrorCode.BOOK_IS_NOT_EXIST_IN_NAVER);
    }
}
