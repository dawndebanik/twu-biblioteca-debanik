package com.biblioteca.entities;

public class MovieDoesNotBelongHereException extends ItemDoesNotBelongHereException {
    public MovieDoesNotBelongHereException(String message) {
        super(message);
    }
}
