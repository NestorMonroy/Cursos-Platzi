package com.anncode.amazonviewer.model;

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
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean viewed;


    public Film(String title, String genre, String creator, int duration) {
        super();
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String isViewed() {
        String visto = "";
        if (viewed == true) {
            visto = "Sí";
        } else {
            visto = "No";
        }

        return visto;
    }

    public boolean getIsViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    /**
     * Método abstracto
     * {@code view()} que es obligatorio para la familia porque es abstracto
     */
    public abstract void view();

}