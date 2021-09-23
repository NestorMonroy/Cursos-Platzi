package com.nestor.amazonviewer.dao;

import com.nestor.amazonviewer.db.IDBConnection;
import com.nestor.amazonviewer.model.Movie;
import com.nestor.amazonviewer.db.DataBase;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface MovieDAO extends IDBConnection {

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectDB()) {
            String query = String.format("SELECT * FROM %s", DataBase.TMOVIE);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt(DataBase.TMOVIE_ID),
                        resultSet.getInt(DataBase.TMOVIE_DURATION),
                        resultSet.getString(DataBase.TMOVIE_TITLE),
                        resultSet.getString(DataBase.TMOVIE_GENRE),
                        resultSet.getString(DataBase.TMOVIE_CREATOR),
                        resultSet.getShort(DataBase.TMOVIE_YEAR));
                String movieViewed = getMovieViewed(connection, resultSet.getInt(DataBase.TMOVIE_ID));
                movie.setViewed(!movieViewed.equals(""));
                movie.setDateString(movieViewed);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return movies;
    }

    default void setMovieViewed(Movie movie) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = simpleDateFormat.format(movie.getStartDate());
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (" +
                        "(SELECT %s FROM %s WHERE %s = '%s'), %s," +
                        "(SELECT %s FROM %s), '%s')",
                DataBase.TVIEWED, DataBase.TVIEWED_ID_MATERIAL, DataBase.TVIEWED_ID_ELEMENT, DataBase.TVIEWED_ID_USER, DataBase.TVIEWED_DATE,
                DataBase.TMATERIAL_ID, DataBase.TMATERIAL, DataBase.TMATERIAL_NAME, DataBase.TMOVIE, movie.getId(),
                DataBase.TUSER_ID, DataBase.TUSER, dateFormatted);
        try (Connection connection = connectDB()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private String getMovieViewed(Connection connection, int idMovie) {
        String query = String.format("SELECT * FROM %s WHERE %s = " +
                        "( SELECT %s FROM %s WHERE %s = '%s' ) " +
                        "AND %s = ? AND %s = " +
                        "( SELECT %s FROM %s )",
                DataBase.TVIEWED, DataBase.TVIEWED_ID_MATERIAL,
                DataBase.TMATERIAL_ID, DataBase.TMATERIAL, DataBase.TMATERIAL_NAME, DataBase.TMOVIE,
                DataBase.TVIEWED_ID_ELEMENT, DataBase.TVIEWED_ID_USER,
                DataBase.TUSER_ID, DataBase.TUSER);
        String date = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idMovie);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                date = resultSet.getString(DataBase.TVIEWED_DATE);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return date;
    }
}