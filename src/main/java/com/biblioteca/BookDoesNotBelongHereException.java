package com.biblioteca;

public class BookDoesNotBelongHereException extends Exception {
    public BookDoesNotBelongHereException(String message) {
        super(message);
    }
}
