package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;

import java.sql.*;
import java.util.ArrayList;

import static com.anncode.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection {
    //default: Puede ser llamado fuera la interface
    default Movie setMovieViewed(Movie movie) {
        try (Connection connection = connectToDB()) {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " + TVIEWED +
                    " (" + TVIEWED_IDMATERIAL + ", " + TVIEWED_IDELEMENT + ", " + TVIEWED_IDUSUARIO + ")" +
                    " VALUES(" + ID_TMATERIALS[0] + ", " + movie.getId() + ", " + TUSER_IDUSUARIO + ")";
            if (statement.executeUpdate(query) > 0) {
                System.out.println("Se marco en Visto");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
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
                movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.parseInt(rs.getString(TMOVIE_ID))));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return movies;
    }

    private boolean getMovieViewed(PreparedStatement preparedStatement,
                                   Connection connection,
                                   int id_movie) {
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED +
                " WHERE " + TVIEWED_IDMATERIAL + "= ?" +
                " AND " + TVIEWED_IDELEMENT + " = ?" +
                " AND " + TVIEWED_IDUSUARIO + " = ?";
        ResultSet rs = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID_TMATERIALS[0]);
            preparedStatement.setInt(2, id_movie);
            preparedStatement.setInt(3, TUSER_IDUSUARIO);

            rs = preparedStatement.executeQuery();
            viewed = rs.next();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return viewed;
    }
}
