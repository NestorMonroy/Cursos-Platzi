package com.nestor.amazonviewer.model;

import com.nestor.amazonviewer.dao.MovieDAO;
import com.nestor.util.AmazonUtil;


import java.util.Date;
import java.util.List;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable IVisiualizable}
 *
 * @author NestorMonroy
 * @version 1.1
 * @since 2021
 */

public class Movie extends Film implements IVisualizable, MovieDAO {

    private int id;
    private String dateString;

    public Movie() {
    }

    public Movie(int id, int duration, String title, String genre, String creator, short year) {
        super(duration, title, genre, creator);
        this.setYear(year);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static List<Movie> makeMoviesList() {
        Movie movie = new Movie();
        return movie.read();
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    /**
     * {@inheritDoc}
     *
     * @return String. Detalle de la informacion de la Pelicula, como titulo, genero, duracion, etc.
     */
    @Override
    public String toString() {
        return "\n::MOVIE::" +
                "\nTitle: " + this.getTitle() +
                "\nGenre: " + this.getGenre() +
                "\nYear: " + this.getYear() +
                "\nCreator: " + this.getCreator() +
                "\nDuration: " + this.getDuration() +
                "\nSeconds viewed: " + this.getTimeViewed() +
                "\nDate: " + this.getDateString();
    }

    /**
     * {@inheritDoc}
     *
     * @param startDate {@code Date} Fecha en la que se inicia la visualización.
     */
    @Override
    public void startToSee(Date startDate) {
        setStartDate(startDate);
    }

    /**
     * {@inheritDoc}
     *
     * @param endDate {@code Date} Fecha en la que se finaliza la visualización.
     */
    @Override
    public void stopToSee(Date endDate) {
        if (getStartDate().getTime() < endDate.getTime()) {
            setTimeViewed((int) (endDate.getTime() - getStartDate().getTime()));
        } else {
            setTimeViewed(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void view() {
        setViewed(true);
        startToSee(new Date());
        Movie movie = new Movie();
        movie.setMovieViewed(this);
        for (int i = 0; i < 100; i++) {
            System.out.println("...You are seeing " + getTitle() + "...");
        }
        AmazonUtil.timeDelay(2);
        stopToSee(new Date());
        System.out.println("\n::YOU JUST SAW::" + toString());
    }

}





