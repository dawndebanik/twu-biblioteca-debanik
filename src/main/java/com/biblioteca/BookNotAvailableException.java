package com.biblioteca;

import com.biblioteca.entities.ItemNotAvailableException;

// represents a special case where a book queried for isn not present
public class BookNotAvailableException extends ItemNotAvailableException {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
