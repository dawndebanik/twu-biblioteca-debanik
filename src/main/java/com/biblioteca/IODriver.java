package com.biblioteca;

// represents a contract where a medium can readInput/write data
interface IODriver {
    void display(String message);
    String readInput();
}
