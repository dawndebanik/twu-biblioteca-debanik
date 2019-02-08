package com.biblioteca;

import com.biblioteca.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void expectsBookToStoreProperDetails() {
        Book contactBook = new Book("Contact", "Carl Sagan", "1997");

        assertEquals("Contact", contactBook.name());
        assertEquals("Carl Sagan", contactBook.author());
        assertEquals("1997", contactBook.year());
    }
}
