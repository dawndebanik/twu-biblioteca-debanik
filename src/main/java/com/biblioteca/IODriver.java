package com.biblioteca;

// represents a contract where a medium can read/write data
interface IODriver {
    void display(String message);
    String read();
}
