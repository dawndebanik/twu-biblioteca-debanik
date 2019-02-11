package com.biblioteca.entities;

import com.biblioteca.exceptions.ItemDoesNotBelongHereException;
import com.biblioteca.exceptions.ItemNotAvailableException;

import java.util.List;

// represents a repository of items in Bibliotheca
public interface ItemCollection {
    List<Item> getAvailable();

    void remove(String itemName) throws ItemNotAvailableException;

    boolean isEmpty();

    void add(String itemName) throws ItemDoesNotBelongHereException;
}
