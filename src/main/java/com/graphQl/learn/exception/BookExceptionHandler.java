package com.graphQl.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> bookExceptionHandler(BookNotFoundException bookNotFoundException){
        BookException bookException = new BookException(
                            bookNotFoundException.getMessage(),
                            HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(bookException,HttpStatus.BAD_REQUEST);
    }

}
