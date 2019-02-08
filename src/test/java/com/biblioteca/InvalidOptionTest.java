package com.biblioteca;

import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.InvalidOption;
import com.biblioteca.menu.MenuOption;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InvalidOptionTest {
    @Test
    void expectsInvalidOptionPromptWhenChoiceIsInvalid() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption invalid = new InvalidOption(new FixedBookCollection(), ioDriver, new ConsoleFormatter());
        when(ioDriver.readInput()).thenReturn("9");

        invalid.select();

        verify(ioDriver).display("Select a valid option!");
    }
}
