package com.biblioteca.entities;

import com.biblioteca.ItemDoesNotBelongHereException;
import com.biblioteca.MovieDoesNotBelongHereException;
import com.biblioteca.MovieNotAvailableException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedMovieCollection implements MovieCollection {
    private static final String MOVIE_NOT_CHECKED_OUT_MESSAGE = "This movie was not checked out";
    private static final String MOVIE_UNAVAILABLE_MESSAGE = "No movie with the requested name is available";
    public static final int EMPTY_LIST_SIZE = 0;

    private List<Movie> availableMovies = new ArrayList<>(Arrays.asList(
            new Movie("Pulp Fiction", "Quentin Tarantino", "1994", 9),
            new Movie("Taxidriver", "Martin Scorsese", "1976", 8),
            new Movie("The Silence of the Lambs", "Jonathan Demme", "1991", 9),
            new Movie("Schindler's List", "Steven Spielberg", "1993", 9)));

    private List<Movie> checkedOutMovies = new ArrayList<>();

    @Override
    public List<Item> getAvailable() {
        return availableMovies.stream().map(movie -> (Item) movie).collect(Collectors.toList());
    }

    @Override
    public void remove(String movieName) throws MovieNotAvailableException {
        Movie movieToRemove = getMovieByName(movieName, availableMovies);
        availableMovies.remove(movieToRemove);
        checkedOutMovies.add(movieToRemove);
    }

    @Override
    public boolean isEmpty() {
        return availableMovies.size() == EMPTY_LIST_SIZE;
    }

    @Override
    public void add(String movieName) throws ItemDoesNotBelongHereException {
        Movie movieToAdd;
        try {
            movieToAdd = getMovieByName(movieName, checkedOutMovies);
        } catch (MovieNotAvailableException e) {
            throw new MovieDoesNotBelongHereException(MOVIE_NOT_CHECKED_OUT_MESSAGE);
        }
        checkedOutMovies.remove(movieToAdd);
        availableMovies.add(movieToAdd);
    }

    private Movie getMovieByName(String movieName, List<Movie> collectionToSearch) throws MovieNotAvailableException {
        for (Item movieItem: collectionToSearch){
            Movie movie = (Movie) movieItem;
            if (movie.name().equals(movieName)){
                return movie;
            }
        }
        throw new MovieNotAvailableException(MOVIE_UNAVAILABLE_MESSAGE);
    }
}
