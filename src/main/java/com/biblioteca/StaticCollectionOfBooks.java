package com.biblioteca;

import java.util.Arrays;
import java.util.List;

// represents a predefined repository of books
public class StaticCollectionOfBooks implements BookCollection {
    private static final String NEWLINE = "\n";
    private List<Book> books = Arrays.asList(
            new Book("War and Peace", "Leo Tolstoy", "1867"),
            new Book("To Kill a Mockingbird", "Harper Lee", "1960")
    );

    @Override
    public List<Book> getAllBooks() {
        return books;
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
