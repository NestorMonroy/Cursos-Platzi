package org.nestor.javatests.movies.data;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nestor.javatests.movies.model.Genre;
import org.nestor.javatests.movies.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                new Movie(2, "Dark Memento", 113, Genre.THRILLER, "Director 1"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Director 2")
        )));
    }


    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Dark Memento", 113, Genre.THRILLER, "Director 1")));
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> movies = movieRepository.findByName("Dark");
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                new Movie(2, "Dark Memento", 113, Genre.THRILLER , "Director 1"))));
    };

    @Test
    public void load_movie_by_second_way() {
        Collection<Movie> movies= movieRepository.findByName("dark");
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                new Movie(4, "Dark Phoenix", 190, Genre.COMEDY, "Director 2"))));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie(5, "Super 8", 112, Genre.THRILLER, "Director 3");
        movieRepository.saveOrUpdate(movie);
        Movie movieFromDb = movieRepository.findById(5);
        assertThat(movieFromDb, is(new Movie(5, "Super 8", 112, Genre.THRILLER, "Director 3")));
    }


    @Test
    public void load_movie_by_director() {
        Collection<Movie> movies = movieRepository.findByDirector("Director 1");
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"Director 1"),
                new Movie(2, "Dark Memento", 113, Genre.THRILLER, "Director 1"))));
    }


    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }

}

