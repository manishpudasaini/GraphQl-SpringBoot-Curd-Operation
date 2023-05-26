package com.graphQl.learn.service;

import com.graphQl.learn.dto.BookDtoRequest;
import com.graphQl.learn.dto.BookDtoResponse;

import java.util.List;

public interface BookService {
    BookDtoResponse addBook(BookDtoRequest bookDtoRequest);
    BookDtoResponse getBook(Long id);
    List<BookDtoResponse> getAllBook();
    BookDtoResponse updateBook(BookDtoRequest bookDtoRequest, Long id);
}
