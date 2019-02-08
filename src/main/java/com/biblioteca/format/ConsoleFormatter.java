package com.biblioteca.format;

import com.biblioteca.Book;
import com.biblioteca.BookCollection;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

public class ConsoleFormatter implements Formatter {

    private static final String ROW_FORMAT = "| %1$30s | %2$30s | %3$30s |\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String EMPTY_STRING = "";
    private static final String HEADER_YEAR = "Year of Publishing";
    private static final String HEADER_AUTHOR = "Author";
    private static final String HEADER_NAME = "Name";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String NEWLINE = "\n";
    private static final int COLUMN_COUNT = 3;
    private static final int ROW_SIZE = 32;

    @Override
    public String formatBookCollection(BookCollection collection) {
        StringBuilder builder = new StringBuilder();
        List<Book> books = collection.getAvailableBooks();
        builder.append(AVAILABLE_BOOKS_HEADER+ NEWLINE +NEWLINE);
        builder.append(rowBorder());
        builder.append(String.format(ROW_FORMAT, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING));
        builder.append(String.format(ROW_FORMAT, HEADER_NAME, HEADER_AUTHOR, HEADER_YEAR));
        builder.append(String.format(ROW_FORMAT, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING));
        builder.append(rowBorder());

        for (Book book : books) {
            builder.append(formatBook(book));
        }

        return builder.toString();
    }

    @Override
    public String formatBook(Book book) {
        return String.format(ROW_FORMAT,
                book.name(), book.author(), book.year()) + rowBorder();
    }

    private String rowBorder() {
        StringBuilder builder = new StringBuilder();
        builder.append(PLUS);
        for (int i = 0; i < COLUMN_COUNT; i++) {
            for (int j = 0; j < ROW_SIZE; j++) {
                builder.append(MINUS);
            }
            builder.append(PLUS);
        }
        return builder.toString() + NEWLINE;
    }
}
