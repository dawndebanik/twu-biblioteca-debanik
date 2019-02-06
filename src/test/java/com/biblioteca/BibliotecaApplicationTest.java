package com.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaApplicationTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        when(consoleDriver.readInput()).thenReturn("1");

        BibliotecaApplication app =
                new BibliotecaApplication(consoleDriver, new StaticCollectionOfBooks());

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca Application!\n");
    }

    @Test
    void expectsListOfBooksToBeShownAfterTheWelcomeMessage() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        when(consoleDriver.readInput()).thenReturn("1");

        BookCollection collectionOfBooks =
                new BookCollection() {
                    @Override
                    public List getAllBooks() {
                        return Collections.singletonList(new Book("War and Peace", "Leo Tolstoy", "1867"));
                    }

                    @Override
                    public String representation() {
                        return String.format("1%1$10s", new Book("War and Peace", "Leo Tolstoy", "1867").representation());
                    }
                };
        BibliotecaApplication app =
                new BibliotecaApplication(consoleDriver, collectionOfBooks);

        app.run();

        verify(consoleDriver).display("1                 War and Peace                   Leo Tolstoy                          1867");
    }


    @Test
    void expectsBookListToBeShownWhenUserEnters1() {
        IODriver userEnters1 = mock(IODriver.class);
        when(userEnters1.readInput()).thenReturn("1");

        BibliotecaApplication app =
                new BibliotecaApplication
                        (userEnters1, new StaticCollectionOfBooks());


        app.run();

        verify(userEnters1, times(1)).display("Available books:");
        verify(userEnters1, times(1)).display("         1                 War and Peace                   Leo Tolstoy                          1867\n" +
                "         2         To Kill a Mockingbird                    Harper Lee                          1960\n");
    }

    @Test
    void expectsInvalidOptionPromptWhenUserEntersInvalidInput() {
        IODriver userEntersInvalid = mock(ConsoleIODriver.class);
        when(userEntersInvalid.readInput()).thenReturn("5");

        BibliotecaApplication app =
                new BibliotecaApplication
                        (userEntersInvalid, new StaticCollectionOfBooks());

        app.run();

        verify(userEntersInvalid, atLeastOnce()).display("Select a valid option!");
    }
}
