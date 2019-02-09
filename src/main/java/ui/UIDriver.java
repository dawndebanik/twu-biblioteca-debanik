package ui;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.menu.Menu;

// represents a contract how the interaction
// with the user is defined
public interface UIDriver {

    String readInput();
    void show(BookCollection collection);
    void show(String message);
    void show(Menu menu);
}
