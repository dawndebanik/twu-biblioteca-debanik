package com.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleFormatterTest {
    @Test
    void expectsBookToBeFormattedProperly() {
        Book aBook = new Book("Contact", "Carl Sagan", "1997");
        Formatter formatter = new ConsoleFormatter();
        String expected =
                "|                        Contact |                     Carl Sagan |                           1997 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n";

        assertEquals(expected, formatter.formatBook(aBook));
    }

    @Test
    void expectsBookCollectionToBeFormattedProperly() {
        BookCollection collection = new FixedBookCollection();
        Formatter formatter = new ConsoleFormatter();
        String expected =
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                                |                                |                                |\n" +
                "|                           Name |                         Author |             Year of Publishing |\n" +
                "|                                |                                |                                |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                  War and Peace |                    Leo Tolstoy |                           1867 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|          To Kill a Mockingbird |                     Harper Lee |                           1960 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n";

        assertEquals(expected, formatter.formatBookCollection(collection));
    }
}
