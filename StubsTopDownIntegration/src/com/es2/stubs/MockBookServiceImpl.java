package com.es2.stubs;

import java.util.ArrayList;
import java.util.List;

//I am a mock object!
public class MockBookServiceImpl implements BookService {

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> books = new ArrayList<>();

        if ("mkyong".equals(author)) {
            books.add(new Book("mkyong in action","mkyong","123456789"));
            books.add(new Book("abc in action","mkyong","1233434789"));
            books.add(new Book("bot","mkyong","19889977888"));
        }

        return books;
    }
    
}
