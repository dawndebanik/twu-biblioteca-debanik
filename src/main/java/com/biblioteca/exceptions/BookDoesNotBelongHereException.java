package com.biblioteca.exceptions;

// represents a special case where the book trying to be added
// does not belong to bibliotheca
public class BookDoesNotBelongHereException extends ItemDoesNotBelongHereException {
    public BookDoesNotBelongHereException(String message) {
        super(message);
    }
}
