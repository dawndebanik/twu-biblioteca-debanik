package com.biblioteca.entities;

public class ItemDoesNotBelongHereException extends Exception {
    public ItemDoesNotBelongHereException(String message) {
        super(message);
    }
}
