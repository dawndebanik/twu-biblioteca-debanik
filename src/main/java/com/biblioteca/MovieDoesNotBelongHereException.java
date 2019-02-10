package com.biblioteca;

// represents a special case where the movie trying to be added
// does not belong to bibliotheca
public class MovieDoesNotBelongHereException extends ItemDoesNotBelongHereException {
    public MovieDoesNotBelongHereException(String message) {
        super(message);
    }
}
