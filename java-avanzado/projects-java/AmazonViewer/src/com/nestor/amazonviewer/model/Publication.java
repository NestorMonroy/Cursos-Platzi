package com.nestor.amazonviewer.model;

import java.util.Date;

/**
 * <h1>Publication</h1>
 * Es una clase padre
 * <p>
 * Esta es una clase base de la familia Publication, la cual
 * contiene atributos para Book y Magazine
 *
 * @author NestorMonroy
 * @version 1.1
 * @since 2021
 */

public class Publication {
    private String title;
    private String editorial;
    private String[] authors;
    private Date publicationDate;
    private int timeReaded;
    private boolean readed;

    Publication(String title, String editorial, String[] authors, Date publicationDate) {
        this.title = title;
        this.editorial = editorial;
        this.authors = authors;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public String isReaded() {
        return (readed) ? "Yes" : "No";
    }

    public String getEditorial() {
        return editorial;
    }

    public String[] getAuthors() {
        return authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getTimeReaded() {
        return timeReaded / 1000;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }
}
