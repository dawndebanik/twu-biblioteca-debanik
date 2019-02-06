package com.biblioteca;

import java.util.List;

// represents a repository of books
interface BookCollection {
    List getAllBooks();
    String representation();
}
