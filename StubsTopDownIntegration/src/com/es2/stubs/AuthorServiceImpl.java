package com.es2.stubs;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    private BookService bookService;
    private BookValidatorService bookValidatorService;

    public BookValidatorService getBookValidatorService() {
        return bookValidatorService;
    }

    public void setBookValidatorService(BookValidatorService bookValidatorService) {
        this.bookValidatorService = bookValidatorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

	//How to test this method ???
    @Override
    public int getTotalBooks(String author) {

        List<Book> books = bookService.findBookByAuthor(author);

        //filters some bot writers
        List<Book> filtered = books.stream().filter(
                x -> bookValidatorService.isValid(x))
                .collect(Collectors.toList());

        //other business logic

        return filtered.size();


    }
}
