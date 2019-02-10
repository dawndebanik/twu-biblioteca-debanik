package ui;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.ItemCollection;
import com.biblioteca.menu.Menu;

// represents a contract how the interaction
// with the user is defined
public interface UIDriver {

    String readInput();
    void show(ItemCollection collection);
    void show(String message);
    void show(Menu menu);
}
