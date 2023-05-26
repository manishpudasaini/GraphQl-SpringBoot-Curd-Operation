package com.graphQl.learn.service.impl;

import com.graphQl.learn.dto.BookDtoRequest;
import com.graphQl.learn.dto.BookDtoResponse;
import com.graphQl.learn.model.Book;
import com.graphQl.learn.repository.BookRepo;
import com.graphQl.learn.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public BookDtoResponse addBook(BookDtoRequest bookDtoRequest) {
        Book savedBook= bookRepo.save(convertToEntity(bookDtoRequest));
       return convertToResponse(savedBook);
    }

    @Override
    public BookDtoResponse getBook(Integer id) {

        Optional<Book> singleBook = bookRepo.findById(id);

        if(singleBook.isPresent()){
            Book book = singleBook.get();
            return convertToResponse(book);
        }
        return null;
    }

    @Override
    public List<BookDtoResponse> getAllBook() {

        return bookRepo.findAll()
                .stream()
                .map(book ->
                        BookDtoResponse.builder()
                                .name(book.getName())
                                .author(book.getAuthor())
                                .price(book.getPrice())
                                .page(book.getPage()).build())
                .collect(Collectors.toList());
    }

    @Override
    public BookDtoResponse updateBook(BookDtoRequest bookDtoRequest, Integer id) {
       Optional<Book> book = bookRepo.findById(id);
       if(book.isPresent()){
           Book singleBook = book.get();
           singleBook.setName(bookDtoRequest.getName());
           singleBook.setAuthor(bookDtoRequest.getAuthor());
           singleBook.setPrice(bookDtoRequest.getPrice());
           singleBook.setPage(bookDtoRequest.getPage());

           bookRepo.save(singleBook);
           return convertToResponse(singleBook);
       }
        return null;
    }

    public Book convertToEntity(BookDtoRequest bookDtoRequest){
        return Book.builder()
                .name(bookDtoRequest.getName())
                .author(bookDtoRequest.getAuthor())
                .price(bookDtoRequest.getPrice())
                .page(bookDtoRequest.getPage())
                .build();
    }

    public BookDtoResponse convertToResponse(Book book){
        return BookDtoResponse.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .price(book.getPrice())
                .page(book.getPage())
                .build();
    }

}
