package com.biblioteca.entities;

// represents a bound set of blank sheets for writing in
public class Book implements Item{
    private final String name;
    private final String author;
    private final String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
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
