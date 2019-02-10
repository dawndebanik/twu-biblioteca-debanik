package com.biblioteca;

import com.biblioteca.entities.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    @Test
    void expectsBookToStoreProperDetails() {
        Movie masaanMovie = new Movie("Masaan", "Neeraj Ghaywan", "2015", 8);

        assertEquals("Masaan", masaanMovie.name());
        assertEquals("Neeraj Ghaywan", masaanMovie.director());
        assertEquals("2015", masaanMovie.year());
        assertEquals(8, masaanMovie.rating());
    }
}
