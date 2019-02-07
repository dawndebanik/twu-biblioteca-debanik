package com.biblioteca.io;

// represents a contract where a medium can readInput/write data
public interface IODriver {
    void display(String message);
    String readInput();
}
