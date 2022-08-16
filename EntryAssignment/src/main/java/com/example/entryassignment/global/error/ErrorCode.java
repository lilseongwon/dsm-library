package com.example.entryassignment.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    NO_PERMISSION(401, "No Permission"),

    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    BOOK_IS_NOT_EXIST(404, "Book is Not Exist"),

    BOOK_IS_NOT_EXIST_IN_NAVER(404, "Book is Not Exist In Naver"),

    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    USER_EXIST(409, "User Exist"),

    ALREADY_BOOK_EXIST(409, "Already Book Exist"),
    ALREADY_APPLIED(409, "Already Applied"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
