package com.northfaceclone.productservice.handler;


import com.northfaceclone.productservice.dto.common.BusinessErrorCodes;
import com.northfaceclone.productservice.dto.response.ErrorResponse;
import com.northfaceclone.productservice.exception.ProductPurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

import static com.northfaceclone.productservice.dto.common.BusinessErrorCodes.PRODUCT_NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // Product Purchase Exception
    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductPurchaseException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .businessErrorCode(PRODUCT_NOT_FOUND.getCode())
                                .businessErrorDescription(PRODUCT_NOT_FOUND.getDescription())
                                .error(exp.getMessage())
                                .build()
                );
    }


    // Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exp) {
        Set<String> errors = new HashSet<>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var errorMessage = error.getDefaultMessage();
                    errors.add(errorMessage);
                });
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .validationErrors(errors)
                                .build()
                );
    }

}