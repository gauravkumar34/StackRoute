package com.notebook.userlogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentials(InvalidCredentials invalidCredentials) {
        System.out.println("invalid");
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.CONFLICT);
    }
}
