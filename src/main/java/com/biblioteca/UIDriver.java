package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.Menu;
import com.biblioteca.menu.MenuOption;

// represents a contract how the interaction
// with the user is defined
public abstract class UIDriver {
    final IODriver ioDriver;
    final Formatter formatter;

    UIDriver(IODriver ioDriver, Formatter formatter){
        this.ioDriver = ioDriver;
        this.formatter = formatter;
    }

    UIDriver(){
        this(new ConsoleIODriver(), new ConsoleFormatter());
    }

    public abstract String readInput();
    public abstract void show(BookCollection collection);
    public abstract void show(String message);
    public abstract void show(Menu menu);
}
