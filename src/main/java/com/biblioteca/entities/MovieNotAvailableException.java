package com.biblioteca.entities;

public class MovieNotAvailableException extends ItemNotAvailableException {
    public MovieNotAvailableException(String message) {
        super(message);
    }
}
