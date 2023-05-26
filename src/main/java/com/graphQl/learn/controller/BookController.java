package com.graphQl.learn.controller;

import com.graphQl.learn.dto.BookDtoRequest;
import com.graphQl.learn.dto.BookDtoResponse;
import com.graphQl.learn.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public BookDtoResponse addBook(@RequestBody BookDtoRequest bookDtoRequest){
        return bookService.addBook(bookDtoRequest);
    }
    @GetMapping
    public List<BookDtoResponse> getAllBooks(){
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public BookDtoResponse getBookById(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PutMapping("/{id}")
    public BookDtoResponse updateBook(@RequestBody BookDtoRequest bookDtoRequest, @PathVariable Long id){
        return bookService.updateBook(bookDtoRequest,id);
    }

}
