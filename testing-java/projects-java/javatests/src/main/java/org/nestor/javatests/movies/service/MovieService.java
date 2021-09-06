package org.nestor.javatests.movies.service;

import org.nestor.javatests.movies.data.MovieRepository;
import org.nestor.javatests.movies.model.Genre;
import org.nestor.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(Integer length) {
        if (length != null && length < 0) {
            throw new IllegalArgumentException("Negative values not allowed");
        } else {
            return movieRepository.findAll().stream()
                    .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
        }
    }

    public Collection<Movie> findMoviesByName(String name) {
        if (name == null) return null;
        return movieRepository.findAll().stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        Collection<Movie> movies = movieRepository.findAll();
        if (template.getId() == null) {
            if (template.getMinutes() != null && template.getMinutes() < 0) {
                throw new IllegalArgumentException("negative values not allowed");
            } else {
                movies = templateFilter(template, movies);
            }
        } else {
            movies = movies.stream().filter(m -> m.getId() == template.getId()).collect(Collectors.toList());
        }
        return movies;
    }

    private Collection<Movie> templateFilter(Movie template, Collection<Movie> movies) {
        if (template.getName() != null) {
            movies = movies.stream()
                    .filter(m -> m.getName().toLowerCase()
                            .contains(template.getName().toLowerCase())).collect(Collectors.toList());
        }
        if (template.getMinutes() != null && template.getMinutes() >= 0) {
            movies = movies.stream()
                    .filter(m -> m.getMinutes() <= template.getMinutes()).collect(Collectors.toList());

        }
        if (template.getGenre() != null) {
            movies = movies.stream().filter(m -> m.getGenre() == template.getGenre()).collect(Collectors.toList());
        }
        return movies;
    }
}
