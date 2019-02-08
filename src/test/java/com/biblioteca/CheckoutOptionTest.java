package com.biblioteca;

import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.CheckoutOption;
import com.biblioteca.menu.MenuOption;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutOptionTest {
    @Test
    void expectsCheckoutToBeDoneWhenOptionSelected() throws BookNotAvailableException{
        BookCollection collection = mock(FixedBookCollection.class);
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption checkout =
                new CheckoutOption(collection, ioDriver, new ConsoleFormatter());
        when(ioDriver.readInput()).thenReturn("War and Peace");

        checkout.select();

        verify(collection).removeBook("War and Peace");
        verify(ioDriver).display("Thank you! Enjoy the book.");
    }

    @Test
    void expectsCheckoutToBeUnsuccessfulWhenBookUnavailable() throws BookNotAvailableException{
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption checkout =
                new CheckoutOption(new FixedBookCollection(), ioDriver, new ConsoleFormatter());
        when(ioDriver.readInput()).thenReturn("Pride and Prejudice");

        checkout.select();

        verify(ioDriver, atLeastOnce()).display("That book is not available.");
    }
}
