package com.northfaceclone.userservice.dto.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {

    NO_CODE(0, NOT_IMPLEMENTED, "No Code"),

    ACCOUNT_LOCKED(302, FORBIDDEN, "User Account is Locked"),

    NEW_PASSWORD_DOES_NOT_MATCH(400, BAD_REQUEST, "New password does not match"),

    INCORRECT_CURRENT_PASSWORD(400, BAD_REQUEST, "Current password is incorrect"),

    ACCOUNT_DISABLED(403, FORBIDDEN, "User Account is Disabled"),

    BAD_CREDENTIALS(401, UNAUTHORIZED, "Email and/or password is incorrect");

    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;

   }

}


