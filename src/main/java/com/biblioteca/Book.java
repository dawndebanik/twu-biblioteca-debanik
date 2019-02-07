package com.biblioteca;

import java.util.Objects;

// represents a bound set of blank sheets for writing in
class Book {
    private final String name;
    private final String author;
    private final String year;

    Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }

    String representation() {
        return String.format("%1$30s%2$30s%3$30s", name, author, year);
    }
}
