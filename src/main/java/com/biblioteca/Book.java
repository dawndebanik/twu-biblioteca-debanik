package com.biblioteca;

import java.util.Arrays;
import java.util.Objects;

// represents a bound set of blank sheets for writing in
public class Book {
    private final String name;
    private final String author;
    private final String year;

    Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    String representation() {
        return String.format("%1$30s%2$30s%3$30s", name, author, year);
    }

    public String name() {
        return name;
    }

    public String author() {
        return author;
    }

    public String year() {
        return year;
    }
}
