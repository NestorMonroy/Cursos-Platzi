package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.anncode.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection {
    //default: Puede ser llamado fuera de la interface
    default Movie setMovieViewed(Movie movie) {
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM " + TMOVIE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.parseInt(rs.getString(TMOVIE_DURATION)),
                        Short.parseShort(rs.getString(TMOVIE_YEAR))
                );
                movie.setId(Integer.parseInt(rs.getString(TMOVIE_ID)));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return movies;
    }

    private boolean getMovieViewed() {
        return false;
    }

}
