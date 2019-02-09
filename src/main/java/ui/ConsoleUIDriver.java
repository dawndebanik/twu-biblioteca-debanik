package ui;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.Menu;

// represents how the user sees
// the output on the console
public class ConsoleUIDriver implements UIDriver {
    private final IODriver ioDriver;
    private final Formatter formatter;

    public ConsoleUIDriver(IODriver ioDriver, Formatter formatter) {
        this.ioDriver = ioDriver;
        this.formatter = formatter;
    }

    public ConsoleUIDriver() {
        this(new ConsoleIODriver(), new ConsoleFormatter());
    }

    @Override
    public String readInput() {
        return ioDriver.readInput().trim();
    }

    @Override
    public void show(BookCollection collection) {
        ioDriver.display(formatter.format(collection));
    }

    @Override
    public void show(String message) {
        ioDriver.display(formatter.format(message));
    }

    @Override
    public void show(Menu menu) {
        ioDriver.display(formatter.format(menu));
    }
}
