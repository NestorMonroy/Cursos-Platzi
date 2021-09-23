package com.nestor.amazonviewer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.nestor.amazonviewer.model.*;
import com.nestor.makereport.Report;
import com.nestor.util.AmazonUtil;


public class Main {

    /**
     * <h1>AmazonViewer</h1>
     * AmazonViewer es un programa que permite visualizar Películas, Series con sus respectivos Chapters,
     * Books y Magazines. Te permite generar reportes generales y con fecha del dia.
     * <p>
     * Existen algunas reglas como que todos los elementos pueden ser visualizados o leídos a exception
     * de las Magazines, estos solo pueden ser vistas a modo de exposicion sin ser leídas.
     *
     * @author NestorMonroy
     * @version 1.1
     * @since 2021
     */


    static List<Movie> movies = Movie.makeMoviesList();
    static List<Serie> series = Serie.makeSeriesList();
    static List<Book> books = Book.makeBooksList();
    static List<Magazine> magazines = Magazine.makeMagazinesList();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("\n:: WELCOME TO AMAZON VIEWER ::");
            System.out.println("  Please select one option:");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report With Date");
            System.out.println("0. Exit");

            option = scanner.next();
            switch (option) {
                case "1":
                    showMovies();
                    break;
                case "2":
                    showSeries();
                    break;
                case "3":
                    showBooks();
                    break;
                case "4":
                    showMagazines();
                    break;
                case "5":
                    makeReport();
                    break;
                case "6":
                    makeReport(new Date());
                    break;
                case "0":
                    System.out.println("\nThe execution has been finished.\n");
                    break;
                default:
                    System.out.println("\nThat option doesn't exist, please choose another.\n");
                    break;
            }
        } while (!option.equals("0"));
    }

    private static void showMovies() {
        String option;
        do {
            System.out.println("\n:: MOVIES ::\n");
            //AtomicInteger Genera numero unico
            AtomicInteger index = new AtomicInteger(1);

//            for (int i = 0; i < movies.size(); i++) { //1. Movie 1
//                System.out.println(i+1 + ". " +
//                movies.get(i).getTitle() +
//                " Seen: " + movies.get(i).isViewed()
//                );
//            }

            //Lambdas apartir de Java8
            movies.forEach(movie -> System.out.println(
                    index.getAndIncrement() + ". " + movie.getTitle() + " Seen: " + movie.getViewed()));

            System.out.println("0. Return to Main Menu");
            option = AmazonUtil.validateUserResponseMenu(movies.size());
            if (!option.equals("0") && !option.equals("")) {
                Movie movieSelected = movies.get(Integer.parseInt(option) - 1);
                movieSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showSeries() {
        String option;
        do {
            System.out.println("\n:: SERIES ::\n");
            AtomicInteger index = new AtomicInteger(1);

//            for (int i = 0; i < series.size(); i++) { //1. Serie 1
//                System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
//            }

            series.forEach(serie -> System.out.println(
                    index.getAndIncrement() + ". " + serie.getTitle() + " Seen: " + serie.getViewed()));
            System.out.println("0. Return to Main Menu");
            option = AmazonUtil.validateUserResponseMenu(series.size());
            if (!option.equals("0") && !option.equals("")) {
                System.out.println("\n:: SERIE " + option + " ::\n");
                Serie serie = series.get(Integer.parseInt(option) - 1);
                showChapters(serie.getChapters());
                serie.view();
            }
        } while (!option.equals("0"));
    }

    private static void showChapters(List<Chapter> chapters) {
        String option;
        do {
            System.out.println("\n:: CHAPTERS ::\n");
            AtomicInteger index = new AtomicInteger(1);

//            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
//                System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
//            }

            chapters.forEach(chapter -> System.out.println(
                    index.getAndIncrement() + ". " + chapter.getTitle() + " Seen: " + chapter.getViewed()));

            System.out.println("0. Return to Main Menu");
            option = AmazonUtil.validateUserResponseMenu(chapters.size());

            if (!option.equals("0") && !option.equals("")) {
                Chapter chapterSelected = chapters.get(Integer.parseInt(option) - 1);
                chapterSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showBooks() {
        String option;
        do {
            System.out.println("\n:: BOOKS ::\n");
            AtomicInteger index = new AtomicInteger(1);
            books.forEach(book -> System.out.println(
                    index.getAndIncrement() + ". " + book.getTitle() + " Read: " + book.isReaded()));
            System.out.println("0. Return to Main Menu");
            option = AmazonUtil.validateUserResponseMenu(books.size());
            if (!option.equals("0") && !option.equals("")) {
                Book bookSelected = books.get(Integer.parseInt(option) - 1);
                bookSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showMagazines() {
        String option;
        do {
            System.out.println("\n:: MAGAZINES ::\n");
            AtomicInteger index = new AtomicInteger(1);
            magazines.forEach(magazine -> System.out.println(
                    index.getAndIncrement() + ". " + magazine.getTitle() + " Last Release: "
                            + new SimpleDateFormat("dd/MM/yyyy").format(magazine.getLastRelease())));
            System.out.println("0. Return to Main Menu");
            option = AmazonUtil.validateUserResponseMenu(magazines.size());
            if (!option.equals("0") && !option.equals("")) {
                Magazine magazineSelected = magazines.get(Integer.parseInt(option) - 1);
                magazineSelected.setReaded(true);
                magazineSelected.startToSee(new Date());
                for (int i = 0; i < 100; i++) {
                    System.out.println("...You are reading the " + magazineSelected.getTitle() + "...");
                }
                AmazonUtil.timeDelay(2);
                System.out.println("\n::YOU JUST SAW::" + magazineSelected);
            }
        } while (!option.equals("0"));
    }

    private static void makeReport() {
        /*

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";

        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";

            }
        }

        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";

                }
            }
        }


        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";

            }
        }
       }

         */


        System.out.println("\n:: CREATING REPORT WITHOUT DATE ::\n");
        Report report = new Report("Report.txt", ":: ALREADY SEEN ::\n");
        StringBuilder content = new StringBuilder(); //StringBuilder, permite concatenar
        //Stream & filter
        movies.stream()
                .filter(movie -> movie.getViewed().equals("Yes"))
                .forEach(movie -> content.append(movie.toString()).append("\n"));

        //Predicate: Condicion dentro de filter
        //Predicate<Serie> seriePredicate = s -> Boolean.parseBoolean(s.getViewed());

        series.stream()
                //.filter(seriePredicate)
                .filter(serie -> serie.getViewed().equals("Yes"))
                .forEach(serie -> content.append(serie.toString()).append("\n"));
        //Consumer:expresión que recibe un parámetro de entrada <T>,
        //pero que no retorna o genera ningún valor de salida. Son funciones terminales.

        Consumer<Serie> chaptersViewed = serie -> {
            List<Chapter> chapters = serie.getChapters();
            chapters.stream()
                    .filter(chapter -> chapter.getViewed().equals("Yes"))
                    .forEach(chapter -> content.append(chapter.toString()).append("\n"));
        };

        series.stream().forEach(chaptersViewed);

        books.stream()
                .filter(book -> book.isReaded().equals("Yes"))
                .forEach(book -> content.append(book.toString()).append("\n"));
        magazines.stream()
                .filter(magazine -> magazine.isReaded().equals("Yes"))
                .forEach(magazine -> content.append(magazine.toString()).append("\n"));
        report.setContent(content.toString());
        try {
            report.makeReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeReport(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy-H-m-s");
        String dateFormat = simpleDateFormat.format(date);
        System.out.println("\n:: REPORT DATED " + date + " ::\n");
        Report report = new Report("Report-" + dateFormat + ".txt", ":: ALREADY SEEN ::\n");
        StringBuilder content = new StringBuilder();
        movies.stream()
                .filter(movie -> movie.getViewed().equals("Yes"))
                .forEach(movie -> content.append(movie.toString()).append("\n"));
        series.stream()
                .filter(serie -> serie.getViewed().equals("Yes"))
                .forEach(serie -> content.append(serie.toString()).append("\n"));
        Consumer<Serie> chaptersViewed = serie -> {
            List<Chapter> chapters = serie.getChapters();
            chapters.stream()
                    .filter(chapter -> chapter.getViewed().equals("Yes"))
                    .forEach(chapter -> content.append(chapter.toString()).append("\n"));
        };
        series.stream().forEach(chaptersViewed);
        books.stream()
                .filter(book -> book.isReaded().equals("Yes"))
                .forEach(book -> content.append(book.toString()).append("\n"));
        magazines.stream()
                .filter(magazine -> magazine.isReaded().equals("Yes"))
                .forEach(magazine -> content.append(magazine.toString()).append("\n"));
        report.setContent(content.toString());
        try {
            report.makeReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
