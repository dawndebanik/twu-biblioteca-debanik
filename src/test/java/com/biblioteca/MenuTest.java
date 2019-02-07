package com.biblioteca;

import com.biblioteca.menu.CheckoutOption;
import com.biblioteca.menu.InvalidOption;
import com.biblioteca.menu.Menu;
import com.biblioteca.menu.MenuOption;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void expectsMenuToSelectProperOptionBasedOnInpurString() {
        Map<String, MenuOption> options = new HashMap<>();
        MenuOption checkout = mock(CheckoutOption.class);
        options.put("Checkout",
                checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption);

        menu.select("Checkout");

        verify(checkout, atLeastOnce()).select();
    }

    @Test
    void expectsInvalidOptionToBeSelectedWhenInputIsInvalid() {
        Map<String, MenuOption> options = new HashMap<>();
        MenuOption checkout = mock(CheckoutOption.class);
        options.put("Checkout",
                checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption);

        menu.select("random");

        verify(defaultOption, atLeastOnce()).select();
    }
}
