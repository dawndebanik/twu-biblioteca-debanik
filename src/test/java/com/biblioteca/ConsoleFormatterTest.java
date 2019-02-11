package com.biblioteca;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.format.Formatter;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.ListItemsOption;
import com.biblioteca.menu.Menu;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import com.biblioteca.ui.ConsoleUIDriver;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ConsoleFormatterTest {
    @Test
    void expectsBookToBeFormattedProperly() {
        Book aBook = new Book("Contact", "Carl Sagan", "1997");
        Formatter formatter = new ConsoleFormatter();
        String expected =
                "|                        Contact |                     Carl Sagan |                           1997 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n";

        assertEquals(expected, formatter.format(aBook));
    }

    @Test
    void expectsBookCollectionToBeFormattedProperly() {
        BookCollection collection = new FixedBookCollection();
        Formatter formatter = new ConsoleFormatter();
        String expected = "Available books:\n" +
                "\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                                |                                |                                |\n" +
                "|                           Name |                         Author |                           Year |\n" +
                "|                                |                                |                                |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                  War and Peace |                    Leo Tolstoy |                           1867 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|          To Kill a Mockingbird |                     Harper Lee |                           1960 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n";

        assertTrue(formatter.format(collection).contains(expected));
    }

    @Test
    void expectsMenuToBeFormattedProperly() {
        MenuOption listBooks = new ListItemsOption("List Books");
        Menu menu = new Menu(Collections.singletonList(listBooks), mock(InvalidOption.class), new ConsoleUIDriver());
        Formatter formatter = new ConsoleFormatter();
        String expected = "Enter the number next to the option you want to select\n" +
                "Type 'quit' to exit the application.\n" +
                "\n" +
                "Menu:\n" +
                "\n" +
                "1. List Books\n";

        assertEquals(expected, formatter.format(menu));
    }
}
