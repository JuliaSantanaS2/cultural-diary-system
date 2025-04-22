package View;

import Module.Genre;
import Control.WorkManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Create {
    Scanner scanner = new Scanner(System.in);
    final WorkManager workManager;

    public Create(WorkManager workManager) {
        this.workManager = workManager;
    }

    public int menuCreat() {
        Scanner scanner = new Scanner(System.in);
        int option_create_menu;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add new book");
            System.out.println("2 - Add new show");
            System.out.println("3 - Add new film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            option_create_menu = scanner.nextInt();

            switch (option_create_menu) {
                case 1:
                    createBook();
                    break;
                case 2:
                    menuShow();
                    break;
                case 3:
                    createFilm();
                    break;
                case 4:
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_create_menu != 4);
        return option_create_menu;

    }

    // Method to add genres to the media
    public List<Genre> addGenresMedia() {
        List<Genre> allGenres = workManager.getGenres();
        List<Genre> selectedGenres = new ArrayList<>();

        while (true) {
            System.out.println("Select a genre (type the corresponding number):");
            for (int i = 0; i < allGenres.size(); i++) {
                System.out.println((i + 1) + " - " + allGenres.get(i).getGenre());
            }

            int genreIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            Genre genre = allGenres.get(genreIndex);
            if (!selectedGenres.contains(genre)) {
                selectedGenres.add(genre);
            }

            System.out.println("Do you want to add another genre? (y/n)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                break;
            }
        }

        if (selectedGenres.isEmpty()) {
            System.out.println("⚠️ Genre list cannot be empty. Please add at least one genre.");
            return addGenresMedia();
        }
        return selectedGenres;
    }

    // Method to confirm if the user has a copy of the media or has seen it
    public boolean confirmationBoolean() {
        while (true) {
            System.out.println("[1] - Yes");
            System.out.println("[2] - No");
            System.out.print("Enter your choice: ");

            try {
                int input = Integer.parseInt(scanner.nextLine());

                if (input == 1) {
                    return true;
                } else if (input == 2) {
                    return false;
                } else {
                    System.out.println("⚠️ Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a number.");
            }
        }
    }

    // Method to confirm if the user wants to add another media
    public void addAnotherMedia_Question() {
        while (true) {
            System.out.println("Would you like to add another?");
            System.out.println("[1] - Yes");
            System.out.println("[2] - No");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                createBook(); // You can adjust this to be dynamic later
            } else if (input.equals("2")) {
                break;
            } else {
                System.out.println("⚠️ Invalid option. Please try again.");
            }
        }
    }


    public void createBook() {

        System.out.println("<----------------------------->");
        System.out.println("Enter the book title:");
        String title = scanner.nextLine();

        System.out.println("Enter the original title of the book:");
        String originalTitle = scanner.nextLine();
        if (originalTitle.isEmpty()) {
            originalTitle = title;
        }

        System.out.println("<----------------------------->");
        System.out.println("Choose the genres of the book:");
        List<Genre> genres = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Enter the year of publication:");
        int yearRelease = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter the publisher of the book:");
        String publisher = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter the ISBN of the book:");
        String isbn = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Do you own a copy of the book?");
        boolean copy = confirmationBoolean();

        System.out.println("<----------------------------->");
        System.out.println("Have you read the book?");
        boolean seen = confirmationBoolean();

        workManager.createBook(seen, title, genres, yearRelease, author, publisher, isbn, copy);
        addAnotherMedia_Question();
    }

    public void createFilm() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the movie title:");
        String title_films = scanner.nextLine();

        System.out.println("Enter the original title of the movie:");
        String originalTitle_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Choose the genres of the movie:");
        List<Genre> genres_films = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Enter the release year:");
        int yearRelease_films = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the movie duration in minutes:");
        int runningtime_films = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the director of the movie:");
        String direction_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter the screenwriter of the movie:");
        String screenplay_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Enter the cast of the movie:");
        System.out.println("<--Separate with ',' (comma)-->");
        String input_cast = scanner.nextLine();
        List<String> cast = Arrays.asList(input_cast.split(",\\s*"));

        System.out.println("<----------------------------->");
        System.out.println("Enter where to watch the movie:");
        System.out.println("<--Separate with ',' (comma)-->");
        String input_whereWatch = scanner.nextLine();
        List<String> whereWatch = Arrays.asList(input_whereWatch.split(",\\s*"));

        System.out.println("<----------------------------->");
        System.out.println("Have you watched the movie?");
        boolean seen = confirmationBoolean();

        workManager.createFilm(cast, seen, title_films, genres_films, yearRelease_films, originalTitle_films, whereWatch, direction_films, runningtime_films, screenplay_films);

        addAnotherMedia_Question();
    }


    public void menuShow() {
        Scanner scanner = new Scanner(System.in);
        int option_show_menu;

        do {
            System.out.println("<----------------------------->");
            System.out.println("Select an option:");
            System.out.println("[1] - Add a new series");
            System.out.println("[2] - Add a new season");
            System.out.println("[3] - Return to the previous menu");
            System.out.println("<----------------------------->");
            option_show_menu = scanner.nextInt();

            switch (option_show_menu) {
                case 1:
                    createShow();
                    break;
                case 2:
                    createSeason();
                    break;
                case 3:
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                    menuCreat();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_show_menu != 3);


    }


    public void createShow() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the title of the series:");
        String title = scanner.nextLine();

        System.out.println("Enter the original title of the series:");
        String originalTitle = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Choose the genres of the series:");
        List<Genre> genres = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Enter the cast of the series:");
        System.out.println("<--Separate by ',' (comma)-->");
        String input_cast = scanner.nextLine();
        List<String> cast = Arrays.asList(input_cast.split(",\\s*"));

        System.out.println("<----------------------------->");
        System.out.println("Enter the release year of the series:");
        int yearRelease = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the end year of the series:");
        int yearEnd = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter where to watch the series:");
        System.out.println("<--Separate by ',' (comma)-->");
        String input_whereWatch = scanner.nextLine();
        List<String> whereWatch = Arrays.asList(input_whereWatch.split(",\\s*"));

        System.out.println("<----------------------------->");
        System.out.println("Have you watched the series?");
        boolean seen = confirmationBoolean();

        workManager.createShow(cast, seen, title, genres, yearRelease, originalTitle, whereWatch, yearEnd);

    }

    public void createSeason() {

        System.out.println("<----------------------------->");
        System.out.println("Which series do you want to review?");
        String title = selectShowFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Enter the season number:");
        int seasonNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the number of episodes in the season:");
        int episodeCount = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Enter the season's release date:");
        System.out.println("Format dd/mm/yyyy:");
        String releaseDate = scanner.nextLine();

        workManager.createSeason(title, seasonNumber, episodeCount, releaseDate);
        workManager.getShow();
    }

    public String selectShowFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Enter the number of the series you want to select:");

        List<String> show = workManager.getShowName();
        for (int i = 0; i < show.size(); i++) {
            System.out.println((i + 1) + " - " + show.get(i));
        }

        int showIndex = -1;
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Empty input! Please enter a number.");
                continue;
            }

            try {
                showIndex = Integer.parseInt(input) - 1;

                if (showIndex < 0 || showIndex >= show.size()) {
                    System.out.println("Number out of range. Try again.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            }
        }
        return show.get(showIndex);
    }
}















