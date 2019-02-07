package com.biblioteca;

class BookNotAvailableException extends Exception {

    BookNotAvailableException(String message) {
        super(message);
    }
}
