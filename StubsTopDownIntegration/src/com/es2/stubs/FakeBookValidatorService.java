package com.es2.stubs;

/**
 * Implementation of book validator.
 *
 */
public class FakeBookValidatorService implements BookValidatorService {

    @Override
    public boolean isValid(Book book) {
        if (book == null)
            return false;

        if ("bot".equals(book.getAuthor())) {
            return false;
        } else {
            return true;
        }

    }
}
