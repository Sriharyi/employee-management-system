package com.sriharyi.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // This annotation is used to handle exceptions globally
public class RestExceptionHandler {
    @ExceptionHandler(value = EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailAlreadyExistsException(){
        return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);

    }
}
