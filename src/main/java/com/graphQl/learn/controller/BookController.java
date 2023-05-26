package com.graphQl.learn.controller;

import com.graphQl.learn.service.BookService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



}
