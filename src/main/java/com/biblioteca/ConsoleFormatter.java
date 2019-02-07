package com.biblioteca;

import java.util.List;

public class ConsoleFormatter implements Formatter {

    private static final String ROW_FORMAT = "| %1$30s | %2$30s | %3$30s |\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    @Override
    public String formatBookCollection(BookCollection collection) {
        StringBuilder builder = new StringBuilder();
        List<Book> books = collection.getAvailableBooks();
        builder.append(AVAILABLE_BOOKS_HEADER+"\n"+"\n");
        builder.append(rowBorder());
        builder.append(String.format(ROW_FORMAT, "", "", ""));
        builder.append(String.format(ROW_FORMAT, "Name", "Author", "Year of Publishing"));
        builder.append(String.format(ROW_FORMAT, "", "", ""));
        builder.append(rowBorder());

        for (Book book : books) {
            builder.append(formatBook(book));
        }

        return builder.toString();
    }

    @Override
    public String formatBook(Book book) {
        return String.format(ROW_FORMAT, book.name(), book.author(), book.year()) + rowBorder();
    }

    private String rowBorder() {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 32; j++) {
                builder.append("-");
            }
            builder.append("+");
        }
        return builder.toString() + "\n";
    }
}
