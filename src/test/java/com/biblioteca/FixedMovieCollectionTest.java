package com.biblioteca;

import com.biblioteca.entities.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixedMovieCollectionTest {
    @Test
    void expectsFixedCollectionOfBooksToBeReturned() {
        MovieCollection fixedCollection = new FixedMovieCollection();
        List<Movie> expectedMovies = Arrays.asList(
                new Movie("Pulp Fiction", "Quentin Tarantino", "1994", 9),
                new Movie("Taxidriver", "Martin Scorsese", "1976", 8),
                new Movie("The Silence of the Lambs", "Jonathan Demme", "1991", 9),
                new Movie("Schindler's List", "Steven Spielberg", "1993", 9));

        List<Item> actualMovies = fixedCollection.getAvailable();

        assertEquals(expectedMovies.size(), actualMovies.size());
        for (int index = 0; index < actualMovies.size(); index++) {
            Movie movie = (Movie) actualMovies.get(index);
            assertEquals(expectedMovies.get(index).name(), movie.name());
        }
    }

    @Test
    void expectsBookToBeUnavailableAfterCheckout() throws ItemNotAvailableException {
        MovieCollection fixedCollection = new FixedMovieCollection();
        String movieName = "Pulp Fiction";

        fixedCollection.remove(movieName);

        for (Item movieItem : fixedCollection.getAvailable()) {
            Movie movie = (Movie) movieItem;
            assertNotEquals("Pulp Fiction", movie.name());
        }
    }

    @Test
    void expectsUnsuccessfulRemovalWhenBookNotPresent() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "Pride and Prejudice";

        assertThrows(BookNotAvailableException.class, () -> fixedCollection.remove(bookName));
    }

    @Test
    void expectsSuccessfulInsertionWhenBookWasCheckedOut() throws ItemNotAvailableException {
        MovieCollection fixedCollection = new FixedMovieCollection();
        String movieName = "Pulp Fiction";
        fixedCollection.remove(movieName);

        assertDoesNotThrow(() -> fixedCollection.add(movieName));
    }

    @Test
    void expectsUnsuccessfulInsertionWhenBookWasNotCheckedOut() {
        MovieCollection fixedCollection = new FixedMovieCollection();
        String movieName = "Pup Fiction";

        assertThrows(MovieDoesNotBelongHereException.class, () -> fixedCollection.add(movieName));
    }
}
