package com.biblioteca.entities;

public class MovieDoesNotBelongHereException extends ItemDoesNotBelongHereException {
    MovieDoesNotBelongHereException(String message) {
        super(message);
    }
}
