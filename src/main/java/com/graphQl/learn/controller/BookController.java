package com.graphQl.learn.controller;

import com.graphQl.learn.dto.BookDtoRequest;
import com.graphQl.learn.dto.BookDtoResponse;
import com.graphQl.learn.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public BookDtoResponse addBook(@RequestBody BookDtoRequest bookDtoRequest){
        return bookService.addBook(bookDtoRequest);
    }
    @QueryMapping
    public List<BookDtoResponse> getAllBook(){
        return bookService.getAllBook();
    }

    @QueryMapping
    public BookDtoResponse getBookId(@Argument int bookId){
        return bookService.getBook(bookId);
    }

    @PutMapping("/{id}")
    public BookDtoResponse updateBook(@RequestBody BookDtoRequest bookDtoRequest, @PathVariable Integer id){
        return bookService.updateBook(bookDtoRequest,id);
    }

}
