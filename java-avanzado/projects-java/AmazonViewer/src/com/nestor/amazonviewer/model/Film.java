package com.nestor.amazonviewer.model;

import java.util.Date;

/**
 * <H1>Film</H1>
 * Film es una clase padre abstracta
 * <p>
 * Esta clase es la clase base de la Familia films, como es abstracta no pueden crearse instancias.
 * Contiene el método abstracto
 * {@code view()} que es obligatorio implementar para todo aquél que pertenezca a la familia.
 *
 * @author NestorMonroy
 * @version 1.1
 * @since 2021
 */
public abstract class Film {
    //Clase abstracta no se implementan todos los métodos
    //No se pueden crear instancias
    private int duration;
    private int timeViewed;
    private String title;
    private String genre;
    private String creator;
    private short year;
    private boolean viewed;
    private Date startDate;

    public Film() {
    }

    public Film(int duration, String title, String genre, String creator) {
        this.duration = duration;
        this.title = title;
        this.genre = genre;
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public int getTimeViewed() {
        return timeViewed / 1000;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getCreator() {
        return creator;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getViewed() {
        return (viewed) ? "Yes" : "No";
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * {@code view()} es un método abstracto de implementación obligatoria.
     */
    public abstract void view();
}