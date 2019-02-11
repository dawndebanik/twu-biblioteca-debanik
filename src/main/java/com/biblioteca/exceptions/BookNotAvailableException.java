package com.biblioteca.exceptions;

// represents a special case where a book queried for isn not present
public class BookNotAvailableException extends ItemNotAvailableException {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
