package org.nestor.javatests.movies.service;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.nestor.javatests.movies.data.MovieRepository;
import org.nestor.javatests.movies.model.Genre;
import org.nestor.javatests.movies.model.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, ""),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Director 2"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Director 1"),
                        new Movie(5, "Scream", 119, Genre.HORROR, ""),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, ""),
                        new Movie(7, "Matrix", 136, Genre.ACTION, ""),
                        new Movie(8, "Superman", 112, Genre.THRILLER, "Ejemplo")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        //List<Integer> movieIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMoviesByLength(120);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6, 8)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_movies_by_negative_minutes() {
        Collection<Movie> movies = movieService.findMoviesByLength(-103);
        assertThat(movies, CoreMatchers.is(Arrays.asList() ) );
    }

    @Test
    public void find_movies_by_name_null() {
        Collection<Movie> movies = movieService.findMoviesByName(null);
        assertThat(movies, nullValue());
    }

    @Test
    public void find_movies_by_genre_and_minutes() {
        assertThat(getMovieIds(movieService.findMoviesByTemplate(
                new Movie(null,null, 112, Genre.THRILLER, "")
        )), CoreMatchers.is(Arrays.asList(4,8)));
    }

    @Test
    public void find_movies_by_genre_and_name() {
        assertThat(
                getMovieIds(movieService.findMoviesByTemplate(
                        new Movie(null, "Dark", null, null, ""))),
                CoreMatchers.is(Collections.singletonList(1)));
    }


}
