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
    public Book getBookWithIndex(int index) {
        return books.get(index - 1);
    }

    @Override
    public void checkOutBook(Book book) {
        books.remove(book);
    }

    @Override
    public String representation() {
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            builder.append(String.format("%1$10s", count));
            builder.append(book.representation()).append(NEWLINE);
            count++;
        }

        return builder.toString();
    }
}
