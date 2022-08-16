package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class AlreadyBookExistExcpetion extends CustomException {

    public static final AlreadyBookExistExcpetion EXCPETION =
            new AlreadyBookExistExcpetion();

    private AlreadyBookExistExcpetion() {
        super(ErrorCode.ALREADY_BOOK_EXIST);
    }
}
