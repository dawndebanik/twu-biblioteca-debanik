package com.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void expectsTwoBooksWithSameDetailsToBeEqual() {
        Book contact = new Book("Contact", "Carl Sagan", "1997");
        Book anotherCopyOfContact = new Book("Contact", "Carl Sagan", "1997");

        assertEquals(contact, anotherCopyOfContact);
    }
}
