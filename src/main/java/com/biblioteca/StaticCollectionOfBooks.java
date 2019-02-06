package com.biblioteca;

import java.util.Arrays;
import java.util.List;

// represents a predefined repository of books
public class StaticCollectionOfBooks implements BookCollection {
    private static final String NEWLINE = "\n";
    private List<Book> books = Arrays.asList(
            new Book("Head First Java"),
            new Book("Clean Code")
    );

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public String representation() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            builder.append(book).append(NEWLINE);
        }

        return builder.toString();
    }
}
