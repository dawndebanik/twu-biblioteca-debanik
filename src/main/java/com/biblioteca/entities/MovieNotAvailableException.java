package com.biblioteca.entities;

class MovieNotAvailableException extends ItemNotAvailableException {
    MovieNotAvailableException(String message) {
        super(message);
    }
}
