package com.biblioteca;

// represents special case when an item is not available
public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String message) {
        super(message);
    }
}
