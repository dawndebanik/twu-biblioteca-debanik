package com.biblioteca.entities;

// represents a film
public class Movie implements Item{
    private final String name;
    private final String year;
    private final String director;
    private final int rating;

    public Movie(String name, String director, String year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String name() {
        return name;
    }

    public String year() {
        return year;
    }

    public String director() {
        return director;
    }

    public int rating() {
        return rating;
    }
}
