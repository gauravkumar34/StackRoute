package com.notesbook.userservice.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value = "UserAlreadyExist")
    private String message1;

    @Value(value = "UserNotFound")
    private String message2;

    @ExceptionHandler(value = UserAlreadyExist.class)
    public ResponseEntity<String> UserAlreadyExistsException(UserAlreadyExist userAlreadyExists) {
        return new ResponseEntity<String>(message1, HttpStatus.CONFLICT);
    }
}
