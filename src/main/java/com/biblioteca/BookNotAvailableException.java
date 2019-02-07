package com.biblioteca;

public class BookNotAvailableException extends Exception {

    BookNotAvailableException(String message) {
        super(message);
    }
}
