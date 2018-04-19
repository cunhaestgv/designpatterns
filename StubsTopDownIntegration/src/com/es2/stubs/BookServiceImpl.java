package com.es2.stubs;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findBookByAuthor(String name) {
        return bookDao.findBookByAuthor(name);
    }

}
