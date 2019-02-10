package com.biblioteca.format;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.Item;
import com.biblioteca.menu.Menu;

import java.util.List;

// represents how data is showed on the console
public class ConsoleFormatter implements Formatter {

    private static final String ROW_FORMAT = "| %1$30s | %2$30s | %3$30s |\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String EMPTY_STRING = "";
    private static final String HEADER_YEAR = "Year of Publishing";
    private static final String HEADER_AUTHOR = "Author";
    private static final String HEADER_NAME = "Name";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String NEWLINE = "\n";
    private static final int COLUMN_COUNT = 3;
    private static final int ROW_SIZE = 32;
    private static final String MENU_HEADER = "Menu:";
    private static final String ENTER_NUMBER_PROMPT = "Enter the number next to the option you want to select";
    private static final String QUIT_TO_EXIT_PROMPT = "Type 'quit' to exit the application.";
    private static final String NO_BOOKS_AVAILABLE_PROMPT = "Sorry, no books are available right now.";
    private static final String TABS_3 = "\t\t\t";

    @Override
    public String format(BookCollection collection) {
        if (collection.isEmpty()){
            return NO_BOOKS_AVAILABLE_PROMPT + NEWLINE + NEWLINE;
        }

        List<Item> books = collection.getAvailable();
        StringBuilder builder = new StringBuilder();
        builder.append(AVAILABLE_BOOKS_HEADER + NEWLINE + NEWLINE);
        builder.append(rowBorder());
        builder.append(String.format(ROW_FORMAT, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING));
        builder.append(String.format(ROW_FORMAT, HEADER_NAME, HEADER_AUTHOR, HEADER_YEAR));
        builder.append(String.format(ROW_FORMAT, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING));
        builder.append(rowBorder());

        for (Item bookItem : books) {
            Book book = (Book) bookItem;
            builder.append(format(book));
        }

        return builder.toString();
    }

    @Override
    public String format(Book book) {
        return String.format(ROW_FORMAT, book.name(), book.author(), book.year()) + rowBorder();
    }

    @Override
    public String format(String message) {
        return message;
    }

    @Override
    public String format(Menu menu) {
        int menuIndex = 1;
        StringBuilder builder = new StringBuilder();
        builder.append(ENTER_NUMBER_PROMPT + NEWLINE);
        builder.append(QUIT_TO_EXIT_PROMPT + NEWLINE + NEWLINE);
        builder.append(MENU_HEADER + NEWLINE + NEWLINE);
        List<String> optionNames = menu.getDisplayOptions();
        for (String optionName : optionNames) {
            builder.append(menuIndex).append(". ").append(optionName).append(NEWLINE);
            menuIndex++;
        }
        return builder.toString();
    }

    private String rowBorder() {
        StringBuilder builder = new StringBuilder();
        builder.append(PLUS);
        for (int i = 0; i < COLUMN_COUNT; i++) {
            for (int j = 0; j < ROW_SIZE; j++) {
                builder.append(MINUS);
            }
            builder.append(PLUS);
        }
        return builder.toString() + NEWLINE;
    }
}
