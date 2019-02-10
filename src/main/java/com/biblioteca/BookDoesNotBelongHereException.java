package com.biblioteca;

import com.biblioteca.entities.ItemDoesNotBelongHereException;

public class BookDoesNotBelongHereException extends ItemDoesNotBelongHereException {
    public BookDoesNotBelongHereException(String message) {
        super(message);
    }
}
