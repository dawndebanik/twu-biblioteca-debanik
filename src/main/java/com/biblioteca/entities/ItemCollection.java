package com.biblioteca.entities;

import java.util.List;

public interface ItemCollection {
    List<Item> getAvailable();
    void remove(String itemName) throws ItemNotAvailableException;
    boolean isEmpty();
    void add(String itemName) throws ItemDoesNotBelongHereException;
}
