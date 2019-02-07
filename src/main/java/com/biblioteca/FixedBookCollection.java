package com.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// represents a predefined repository of books
public class FixedBookCollection implements BookCollection {
    private static final String NEWLINE = "\n";
    private List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book("War and Peace", "Leo Tolstoy", "1867"),
                    new Book("To Kill a Mockingbird", "Harper Lee", "1960")
            ));

    @Override
    public List<Book> getAvailableBooks() {
        return books;
    }

    @Override
    public void removeBook(String bookName) throws BookNotAvailableException{
        for (Book book : books) {
            if (book.name().equals(bookName)) {
                books.remove(book);
                return;
            }
        }
        throw new BookNotAvailableException("No book with the requested name is available");
    }
}