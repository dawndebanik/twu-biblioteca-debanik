package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.ListBooksOption;
import com.biblioteca.menu.MenuOption;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksOptionTest {
    @Test
    void expectsListOfBooksToBePrintedWhenSelected() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption listBooks =
                new ListBooksOption("List Books", new FixedBookCollection(), new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));

        listBooks.select();

        verify(ioDriver).display(contains("War and Peace"));
        verify(ioDriver).display(contains("To Kill a Mockingbird"));
    }
}
