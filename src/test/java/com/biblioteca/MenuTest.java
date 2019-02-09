package com.biblioteca;

import com.biblioteca.menu.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void expectsMenuToSelectProperOptionBasedOnInputString() {
        MenuOption checkout = mock(CheckoutOption.class);
        List<MenuOption> options = new ArrayList<>();
        options.add(checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption, new ConsoleUIDriver());

        menu.select("1");

        verify(checkout, atLeastOnce()).select();
    }

    @Test
    void expectsInvalidOptionToBeSelectedWhenInputIsInvalid() {
        MenuOption checkout = mock(CheckoutOption.class);
        List<MenuOption> options = new ArrayList<>();
        options.add(checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption, new ConsoleUIDriver());

        menu.select("random");

        verify(defaultOption, atLeastOnce()).select();
    }

    @Test
    void expectsProperDisplayOptionsFromMenu() {
        MenuOption checkout = new CheckoutOption("Checkout");
        MenuOption invalid = new InvalidOption("Invalid");
        Menu menu = new Menu(Collections.singletonList(checkout), invalid, new ConsoleUIDriver());

        assertEquals(Collections.singletonList("Checkout"), menu.getDisplayOptions());
    }
}
