package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.option.ListItemsOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import com.biblioteca.ui.ConsoleUIDriver;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListItemsOptionTest {
    @Test
    void expectsListOfBooksToBePrintedWhenSelected() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption listBooks =
                new ListItemsOption("List Books", new FixedBookCollection(), new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));

        listBooks.select();

        verify(ioDriver).display(contains("War and Peace"));
        verify(ioDriver).display(contains("To Kill a Mockingbird"));
    }
}
