package com.biblioteca;

// represents a special case where a movie is not available
public class MovieNotAvailableException extends ItemNotAvailableException {
    public MovieNotAvailableException(String message) {
        super(message);
    }
}
