package com.nestor.amazonviewer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Chapter</h1>
 * Hereda de {@link Movie}
 *
 * @author NestorMonroy
 * @version 1.1
 * @see Film
 * @since 2021
 */

public class Chapter extends Movie {

    private int id;
    private int seasonNumber;

    public Chapter(int id, int duration, String title, String genre, String creator, short year, int seasonNumber) {
        super(id, duration, title, genre, creator, year);
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public static List<Chapter> makeChaptersList() {
        List<Chapter> chapters = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            chapters.add(new Chapter(i, 45, "Chapter " + i, "Genre " + i, "Author " + i, (short) (2014 + 1), i));
        }
        return chapters;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "\n::CHAPTER::" +
                "\nTitle: " + this.getTitle() +
                "\nGenre: " + this.getGenre() +
                "\nYear: " + this.getYear() +
                "\nCreator: " + this.getCreator() +
                "\nDuration: " + this.getDuration() +
                "\nSeconds viewed: " + this.getTimeViewed();
    }
}
