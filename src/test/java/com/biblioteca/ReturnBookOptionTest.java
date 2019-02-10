package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.entities.ItemDoesNotBelongHereException;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.option.MenuOption;
import com.biblioteca.menu.option.ReturnBookOption;
import org.junit.jupiter.api.Test;
import ui.ConsoleUIDriver;
import ui.UIDriver;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

class ReturnBookOptionTest {
    @Test
    void expectsSuccessfulMessageOnProperReturnOfBook() throws ItemDoesNotBelongHereException {
        BookCollection collection = mock(FixedBookCollection.class);
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption returnBook =
                new ReturnBookOption("Return a book", collection,
                        new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));
        when(ioDriver.readInput()).thenReturn("War and Peace");

        returnBook.select();

        verify(collection).add("War and Peace");
        verify(ioDriver).display(contains("Thank you for returning the book."));
    }

    @Test
    void expectsUnsuccessfulMessageOnFaultyReturnOfBook() {
        BookCollection collection = new FixedBookCollection();
        UIDriver consoleUIDriver = mock(ConsoleUIDriver.class);
        MenuOption returnBook =
                new ReturnBookOption("Return a book", collection, consoleUIDriver);
        when(consoleUIDriver.readInput()).thenReturn("Some random book");

        returnBook.select();

        // verify(collection).addBook("Some random book");
        verify(consoleUIDriver, atLeastOnce()).show(contains("That is not a valid book to return."));
    }
}
