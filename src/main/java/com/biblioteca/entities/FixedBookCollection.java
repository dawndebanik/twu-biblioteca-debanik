package com.biblioteca.entities;

import com.biblioteca.BookDoesNotBelongHereException;
import com.biblioteca.BookNotAvailableException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// represents a predefined repository of availableBooks
public class FixedBookCollection implements BookCollection {
    private static final String BOOK_NOT_CHECKED_OUT_MESSAGE = "This book was not checked out";
    private static final String BOOK_UNAVAILABLE_MESSAGE = "No book with the requested name is available";

    private List<Book> availableBooks = new ArrayList<>(
            Arrays.asList(
                    new Book("War and Peace", "Leo Tolstoy", "1867"),
                    new Book("To Kill a Mockingbird", "Harper Lee", "1960"),
                    new Book("Kafka on the Shore", "Haruki Murakami", "2002"),
                    new Book("Nineteen Eighty-Four", "George Orwell", "1949")));
    private List<Book> checkedOutBooks = new ArrayList<>();

    @Override
    public List<Item> getAvailable() {
        return availableBooks.stream().map(book -> (Item) book).collect(Collectors.toList());
    }

    @Override
    public void remove(String bookName) throws BookNotAvailableException {
        Book bookToRemove = getBookByBookName(bookName, availableBooks);
        availableBooks.remove(bookToRemove);
        checkedOutBooks.add(bookToRemove);
    }

    @Override
    public boolean isEmpty() {
        return availableBooks.size() == 0;
    }

    @Override
    public void add(String bookName) throws BookDoesNotBelongHereException {
        Book bookToAdd;
        try {
            bookToAdd = getBookByBookName(bookName, checkedOutBooks);
        } catch (BookNotAvailableException e) {
            throw new BookDoesNotBelongHereException(BOOK_NOT_CHECKED_OUT_MESSAGE);
        }
        checkedOutBooks.remove(bookToAdd);
        availableBooks.add(bookToAdd);
    }

    private Book getBookByBookName(String bookName, List<Book> collectionToSearch) throws BookNotAvailableException {
        for (Item bookItem: collectionToSearch){
            Book book = (Book) bookItem;
            if (book.name().equals(bookName)){
                return book;
            }
        }
        throw new BookNotAvailableException(BOOK_UNAVAILABLE_MESSAGE);
    }
}