package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.option.CheckoutOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import ui.ConsoleUIDriver;

import static org.mockito.Mockito.*;

class CheckoutOptionTest {
    @Test
    void expectsCheckoutToBeDoneWhenOptionSelected() throws ItemNotAvailableException {
        BookCollection collection = mock(FixedBookCollection.class);
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption checkout =
                new CheckoutOption("Checkout", collection,
                        new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));
        when(ioDriver.readInput()).thenReturn("War and Peace");

        checkout.select();

        verify(collection).remove("War and Peace");
        verify(ioDriver).display(contains("Thank you! Enjoy the book."));
    }

    @Test
    void expectsCheckoutToBeUnsuccessfulWhenBookUnavailable() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption checkout =
                new CheckoutOption("Checkout",
                        new FixedBookCollection(), new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));
        when(ioDriver.readInput()).thenReturn("Pride and Prejudice");

        checkout.select();

        verify(ioDriver, atLeastOnce()).display(contains("That book is not available."));
    }
}
