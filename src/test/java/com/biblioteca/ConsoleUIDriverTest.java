package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.ListItemsOption;
import com.biblioteca.menu.Menu;
import org.junit.jupiter.api.Test;
import com.biblioteca.ui.ConsoleUIDriver;
import com.biblioteca.ui.UIDriver;

import java.util.Collections;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConsoleUIDriverTest {
    @Test
    void expectsMessageToBeDisplayedProperly() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        UIDriver consoleUIDriver = new ConsoleUIDriver(ioDriver, new ConsoleFormatter());

        consoleUIDriver.show("Hello world!");

        verify(ioDriver).display("Hello world!");
    }

    @Test
    void expectsBookCollectionToBeDisplayedProperly() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        UIDriver consoleUIDriver = new ConsoleUIDriver(ioDriver, new ConsoleFormatter());

        consoleUIDriver.show(new FixedBookCollection());

        verify(ioDriver).display(contains("Available books:\n" +
                "\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                                |                                |                                |\n" +
                "|                           Name |                         Author |                           Year |\n" +
                "|                                |                                |                                |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                  War and Peace |                    Leo Tolstoy |                           1867 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|          To Kill a Mockingbird |                     Harper Lee |                           1960 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n"));
    }

    @Test
    void expectsMenuToBeDisplayedProperly() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        UIDriver consoleUIDriver = new ConsoleUIDriver(ioDriver, new ConsoleFormatter());

        consoleUIDriver.show(
                new Menu(Collections.singletonList(new ListItemsOption("List Books")),
                        new InvalidOption("Invalid"), consoleUIDriver));

        verify(ioDriver).display("Enter the number next to the option you want to select\n" +
                "Type 'quit' to exit the application.\n" +
                "\n" +
                "Menu:\n" +
                "\n" +
                "1. List Books\n");
    }
}
