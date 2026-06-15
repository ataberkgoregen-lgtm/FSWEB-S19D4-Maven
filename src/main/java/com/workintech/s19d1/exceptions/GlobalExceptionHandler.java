package com.workintech.s19d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(ApiException apiExceptions){
        log.error("api exception occured: " + apiExceptions);
        return new ResponseEntity<>(new ExceptionResponse(apiExceptions.getMessage(), apiExceptions.getHttpStatus().value(), LocalDateTime.now()), apiExceptions.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception exception){
        log.error("api exception occured: " + exception);
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
