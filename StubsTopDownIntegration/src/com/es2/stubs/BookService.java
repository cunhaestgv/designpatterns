package com.es2.stubs;

import java.util.List;

/**
 * Service to return a list of books by author name.
 *
 */
public interface BookService {
    List<Book> findBookByAuthor(String author);
}
