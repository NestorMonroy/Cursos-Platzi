package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.model.Movie;

import java.util.ArrayList;

public interface MovieDAO {
    //default: Puede ser llamado fuera de la interface
    default Movie setMovieViewed(Movie movie) {
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }

    private boolean getMovieViewed() {
        return false;
    }

}
