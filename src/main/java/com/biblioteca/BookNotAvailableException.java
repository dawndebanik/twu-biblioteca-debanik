package com.biblioteca;

// represents a special case where a book queried for isn not present
public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
