package View;

import Module.Review;
import Module.Book;
import Module.Show;
import Control.WorkManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateReview {
    Scanner scanner = new Scanner(System.in);
    final WorkManager workManager;
    private Screen screen;

    public CreateReview(WorkManager workManager) {
        this.workManager = workManager;
     }

    public String dateNow() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    public void messager(int result) {
        if (result == 0) {
            System.out.println("Review created successfully!");
        } else if (result == 1) {
            System.out.println("Book not found.");
        } else if (result == 2) {
            System.out.println("You haven't read this book yet.");
        } else {
            System.out.println("Error creating the review.");
        }
    }


    public void showCreateReview() {

        System.out.println("<----------------------------->");
        System.out.println("Choose the type of media:");
        System.out.println("1. Book");
        System.out.println("2. Film");
        System.out.println("3. Series/Season");
        System.out.println("4. Back");

        String option = scanner.nextLine();

        switch (option) {
            case "1":
                createReviewBookData();
                break;
            case "2":
                createReviewFilmsData();
                break;
            case "3":
                createReviewShowSerieData();
                break;
            case "4":
                ClearScreen.clear();
                System.out.println("🔙 Returning to previous menu...");
                screen.start();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    public void createReviewBookData() {

        System.out.println("<----------------------------->");
        System.out.println("Which book would you like to review?");
        String title = selectBookFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Write your review about the book:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Rate the book (1 to 5 stars):");
        int stars = Integer.parseInt(scanner.nextLine());

        String reviewDate = dateNow();

        int result = workManager.createReviewBook(title, comment, stars, reviewDate);
        messager(result);
    }


    public String selectBookFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the title of the book you want to select:");

        List<String> books = workManager.getBooksName();
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + " - " + books.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return books.get(nameBookIndex);
    }


    public void createReviewFilmsData() {


        System.out.println("<----------------------------->");
        System.out.println("Which movie would you like to review?");
        String title = selectFilmFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Write your review about the movie:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter your rating (stars) between 1 and 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        String reviewDate = dateNow();

        int result = workManager.createReviewFilm(title,comment, stars, reviewDate);
        messager(result);
    }

    public String selectFilmFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the title of the movie you want to select:");

        List<String> film = workManager.getFilmName();
        for (int i = 0; i < film.size(); i++) {
            System.out.println((i + 1) + " - " + film.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return film.get(nameBookIndex);
    }

    public void createReviewShowSerieData() {

        System.out.println("<----------------------------->");
        System.out.println("Which series would you like to review?");
        String title = selectShowFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Which season would you like to review?");
        int seasonNumber = selectSeasonFromLibrary(title);

        System.out.println("<----------------------------->");
        System.out.println("Write your review about the series:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter your rating (stars) from 1 to 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        String reviewDate = dateNow();

        int result = workManager.createReviewShow(title,seasonNumber,comment, stars, reviewDate);
        messager(result);
        workManager.getShow();
    }

    public String selectShowFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the title of the series you want to select:");

        List<String> film = workManager.getShowName();
        for (int i = 0; i < film.size(); i++) {
            System.out.println((i + 1) + " - " + film.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return film.get(nameBookIndex);
    }

    public int selectSeasonFromLibrary(String title) {
        System.out.println("<----------------------------->");
        System.out.println("Enter the season number you want to select:");

        List<Integer> seasons = workManager.getSeasonsByShowName(title);
        for (int i = 0; i < seasons.size(); i++) {
            System.out.println((i + 1) + " - " + seasons.get(i));
        }

        int nameSeasonIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return seasons.get(nameSeasonIndex);
    }






}