package com.biblioteca;

// represents a bound set of blank sheets for writing in
class Book {
    private final String name;

    Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name : " + name;
    }
}
