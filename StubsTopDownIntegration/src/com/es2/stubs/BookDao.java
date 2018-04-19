package com.es2.stubs;

import java.util.List;

/**
 * Data Access Object that performs queries over a database of books.
 *
 */
public interface BookDao {

    List<Book> findBookByAuthor(String author);
    
}
