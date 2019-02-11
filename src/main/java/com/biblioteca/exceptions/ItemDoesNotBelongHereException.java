package com.biblioteca.exceptions;

// represents special case where the item trying to be
// returned does not belong to Bibliotheca
public class ItemDoesNotBelongHereException extends Exception {
    ItemDoesNotBelongHereException(String message) {
        super(message);
    }
}
