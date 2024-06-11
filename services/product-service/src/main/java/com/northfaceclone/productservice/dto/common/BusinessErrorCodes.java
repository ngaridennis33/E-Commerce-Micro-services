package com.northfaceclone.productservice.dto.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum BusinessErrorCodes {

    NO_CODE(0, NOT_IMPLEMENTED, "No Code"),
    PRODUCT_NOT_FOUND(404, NOT_FOUND, "Product Not Found" ),
    PRODUCT_ALREADY_EXISTS(409, CONFLICT, "Product Already Exists"),
    INSUFFICIENT_STOCK(400, BAD_REQUEST, "Insufficient Stock" ),
    INVALID_PRODUCT_DETAILS(400, BAD_REQUEST,"Invalid Product Details"),
    PRODUCT_UPDATE_FAILED(500, INTERNAL_SERVER_ERROR,"Product Update Failed" ),
    PRODUCT_DELETE_FAILED(500, INTERNAL_SERVER_ERROR,"Product Delete Failed");

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
