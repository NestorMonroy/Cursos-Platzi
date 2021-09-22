package com.anncode.amazonviewer.model;

import java.util.ArrayList;

/**
 *  <h1> Serie </h1>
 * Serie una clase que hereda {@link Film}
 * <p>
 *
 * Esta clase contiene el método abstracto
 * {@code view()} Que es obligatorio implementar. Ya que hereda directamente
 * de la clase abstracta Film
 *
 *
 * @author NestorMonroy
 * @version 1.1
 * @since 2021
 */
public class Serie extends Film {

    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;


    public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
        super(title, genre, creator, duration);
        // TODO Auto-generated constructor stub
        this.sessionQuantity = sessionQuantity;
    }


    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n :: SERIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }
    /**
     * Este método nos crea una lista de series
     */
    public static ArrayList<Serie> makeSeriesList() {
        ArrayList<Serie> series = new ArrayList();

        for (int i = 1; i <= 5; i++) {
            Serie serie = new Serie("Serie " + i, "genero " + i, "creador " + i, 1200, 5);
            serie.setChapters(Chapter.makeChaptersList(serie));
            series.add(serie);
        }
        return series;
    }

    /**
     * {@inheritDoc }
     */

    @Override
    public void view() {
        // TODO Auto-generated method stub
        setViewed(true);
    }

}
