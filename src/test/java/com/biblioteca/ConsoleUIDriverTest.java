package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConsoleUIDriverTest {
    @Test
    void expectsMessageToBeDisplayedProperly() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        UIDriver consoleUIDriver = new ConsoleUIDriver(ioDriver, new ConsoleFormatter());

        consoleUIDriver.show("Hello world!");

        verify(ioDriver).display("\n***\tHello world!\t***\n");
    }

    @Test
    void expectsBookCollectionToBeDisplayedProperly() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        UIDriver consoleUIDriver = new ConsoleUIDriver(ioDriver, new ConsoleFormatter());

        consoleUIDriver.show(new FixedBookCollection());

        verify(ioDriver).display("Available books:\n" +
                "\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                                |                                |                                |\n" +
                "|                           Name |                         Author |             Year of Publishing |\n" +
                "|                                |                                |                                |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|                  War and Peace |                    Leo Tolstoy |                           1867 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n" +
                "|          To Kill a Mockingbird |                     Harper Lee |                           1960 |\n" +
                "+--------------------------------+--------------------------------+--------------------------------+\n");
    }
}
