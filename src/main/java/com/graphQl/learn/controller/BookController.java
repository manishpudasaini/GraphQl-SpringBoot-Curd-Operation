package com.graphQl.learn.controller;

import com.graphQl.learn.dto.BookDtoRequest;
import com.graphQl.learn.dto.BookDtoResponse;
import com.graphQl.learn.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping("createBook")
    public BookDtoResponse createBook(@Argument BookDtoRequest book){
        return bookService.addBook(book);
    }
    @QueryMapping("getAllBook")
    public List<BookDtoResponse> getAllBook(){
        return bookService.getAllBook();
    }

    @QueryMapping("getBookId")
    public BookDtoResponse getBookId(@Argument int bookId){
        return bookService.getBook(bookId);
    }

    @MutationMapping("updateBook")
    public BookDtoResponse updateBook(@Argument BookDtoRequest book, @Argument Integer bookId){
        return bookService.updateBook(book,bookId);
    }

}
