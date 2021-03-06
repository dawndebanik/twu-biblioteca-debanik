package com.biblioteca.io;

import java.util.Scanner;

// represents a medium to readInput/write data from the console
public class ConsoleIODriver implements IODriver {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
