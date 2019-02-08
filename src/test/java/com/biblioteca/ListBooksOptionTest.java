package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.ListBooksOption;
import com.biblioteca.menu.MenuOption;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksOptionTest {
    @Test
    void expectsListOfBooksToBePrintedWhenSelected() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption listBooks = new ListBooksOption(
                new FixedBookCollection(), ioDriver, new ConsoleFormatter());

        listBooks.select();

        verify(ioDriver).display("Available books:\n\n"+
                "+--------------------------------+--------------------------------+--------------------------------+\n"+
                "|                                |                                |                                |\n"+
                "|                           Name |                         Author |             Year of Publishing |\n"+
                "|                                |                                |                                |\n"+
                "+--------------------------------+--------------------------------+--------------------------------+\n"+
                "|                  War and Peace |                    Leo Tolstoy |                           1867 |\n"+
                "+--------------------------------+--------------------------------+--------------------------------+\n"+
                "|          To Kill a Mockingbird |                     Harper Lee |                           1960 |\n"+
                "+--------------------------------+--------------------------------+--------------------------------+\n");
    }
}
