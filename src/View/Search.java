package View;

import java.util.Scanner;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import Module.Book;
import Module.Films;
import Module.Media;
import Module.Show;
import Module.Season;
import Module.Review;
import Module.Genre;
import Module.AudioVisualMedia;

import Control.WorkManager;


public class Search {

    final WorkManager workManager;
    private Scanner scanner;

    public Search(WorkManager workManager) {
        this.workManager = workManager;
        this.scanner = new Scanner(System.in);
    }

    public void mediaSearchMenu() {
        int option;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select a search option:");

            System.out.println("\n<--- Specific Search Menu --->");
            System.out.println("Search by which criteria?");
            System.out.println("0 - Return to Previous Menu");
            System.out.println("1 - Title");
            System.out.println("2 - Genre");
            System.out.println("3 - Release Year");
            System.out.println("4 - Person (Author, Director, Cast)");
            System.out.println("5 - ISBN (Books Only)");
            System.out.println("<--------------------------------->");
            System.out.print("Option: ");
            System.out.println("<------------------------------->");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // Title
                    searchByTitleOption();
                    break;
                case 2: // Genres
                    searchByGenreOption();
                    break;
                case 3: // Year
                    searchByYearOption();
                    break;
                case 4: // People
                    searchByPersonOption();
                    break;
                case 5: // ISBN
                    searchByIsbnOption();
                    break;
                case 0:
                    System.out.println("🔙 Returning to previous menu...");
                    ClearScreen.clear();
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }

        } while (option != 0);

    }

    private void searchByTitleOption() {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.println("\nSearching by title: '" + title + "'...");
        List<Media> results = workManager.searchByTitle(title);
        printMediaTable(results);
        pauseForUser();
    }

    private void searchByGenreOption() {
        System.out.print("Enter the genre name: ");
        String genreName = scanner.nextLine();
        System.out.println("\nSearching by genre: '" + genreName + "'...");
        List<Media> results = workManager.searchByGenre(genreName);
        printMediaTable(results);
        pauseForUser();
    }

    private void searchByYearOption() {
        System.out.print("Enter the release year: ");
        int year;
        try {
            year = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Search cancelled.");
            return;
        }
        System.out.println("\nSearching by year: " + year + "...");
        List<Media> results = workManager.searchByYear(year);
        printMediaTable(results);
        pauseForUser();
    }

    private void searchByPersonOption() {
        System.out.print("Enter the person's name (Author, Director, Actor/Actress): ");
        String personName = scanner.nextLine();

        System.out.println("Search for '" + personName + "' in which category(s)?");
        System.out.println("1 - Books only (Author)");
        System.out.println("2 - Movies only (Director/Cast)");
        System.out.println("3 - Series only (Cast)");
        System.out.println("4 - All");
        System.out.print("Option: ");

        int scopeOption = readIntInput();

        System.out.println("\nSearching by person: '" + personName + "'...");
        List<Media> combinedResults = new java.util.ArrayList<>();

        if (scopeOption == 1 || scopeOption == 4) {
            combinedResults.addAll(workManager.searchBooksByAuthor(personName));
        }
        if (scopeOption == 2 || scopeOption == 4) {
            combinedResults.addAll(workManager.searchFilmsByDirector(personName));
            combinedResults.addAll(workManager.searchFilmsByCast(personName));
        }
        if (scopeOption == 3 || scopeOption == 4) {
            combinedResults.addAll(workManager.searchShowsByCast(personName));
        }
        if (scopeOption < 1 || scopeOption > 4) {
            System.out.println("Invalid scope option. No search by person performed.");
        }

        List<Media> uniqueResults = combinedResults.stream()
                .filter(distinctByKey(Media::getTitle))
                .collect(java.util.stream.Collectors.toList());

        printMediaTable(uniqueResults);
        pauseForUser();
    }

    // Helper para distinct em Streams (requer import java.util.function.Function e java.util.concurrent.ConcurrentHashMap)
    public static <T> java.util.function.Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
        java.util.Set<Object> seen = java.util.concurrent.ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private void searchByIsbnOption() {
        System.out.print("Enter the book's ISBN: ");
        String isbn = scanner.nextLine();
        if (isbn.trim().isEmpty()) {
            System.out.println("Search by ISBN cancelled (empty input).");
            return;
        }
        System.out.println("\nSearching by ISBN: '" + isbn + "'...");
        List<? extends Media> results = workManager.searchBooksByISBN(isbn);
        printMediaTable((List<Media>) results);
        pauseForUser();
    }


    /**
     * Reads an integer from the scanner with basic error handling
     */
    private int readIntInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print("Option: ");
            }
        }
    }

    /**
     * Pauses execution, waiting for the user to press Enter
     */
    private void pauseForUser() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }


    public void mediaListMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n<------------------------------->");
            System.out.println("List all media - choose criteria:");
            System.out.println("1 - Alphabetical (A–Z)");
            System.out.println("2 - Forting and Filtering");
            System.out.println("3 - Return");
            System.out.print("Option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    ClearScreen.clear();
                    List<Media> list = workManager.listMediaAlphabetically();
                    printDetailedMediaList(list, "Lista Completa em Ordem Alfabética");
                    printMediaTable(list);
                }
                case 2 -> {
                    ClearScreen.clear();
                    sortingAndFilter();
                }
                case 3 -> {
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                }
            }
        } while (option != 3);
    }

    public void sortingAndFilter() {


        Scanner scanner = new Scanner(System.in);
        int optionYear, sortOption;
        String optionGenre;
        Integer filterYear = null;
        Genre filterGenre = null;

        System.out.println("Would you like to filter the list by release year?");
        System.out.println("[1] - YES");
        System.out.println("[2] - NO");
        System.out.print("Option: ");
        optionYear = scanner.nextInt();
        scanner.nextLine();

        if (optionYear == 1) {
            System.out.println("\nWhich year would you like to search for?");
            filterYear = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("\nWould you like to filter the list by genre?");
        System.out.println("[1] - YES");
        System.out.println("[2] - NO");
        System.out.print("Option: ");
        int optionGenreInt = scanner.nextInt();
        scanner.nextLine();

        if (optionGenreInt == 1) {
            filterGenre = selectSingleGenreFilter();
            if (filterGenre != null) {
                System.out.println(">> Filtering by genre:" + filterGenre.getGenre());
            } else {
                System.out.println(">> No valid genre selected/found. Genre filter will not be applied.");
            }
        }

        System.out.println("\nWhich sorting would you like?");
        System.out.println("[1] - From highest rated to lowest rated.");
        System.out.println("[2] - From lowest rated to highest rated.");
        System.out.println("[3] - Alphabetical (A-Z)");
        System.out.print("Option: ");
        sortOption = scanner.nextInt();
        scanner.nextLine();

        ClearScreen.clear();
        List<Media> resultList = workManager.getFilteredAndSortedMedia(filterYear, filterGenre, sortOption);
        printMediaTable(resultList);
    }

    private Genre selectSingleGenreFilter() {
        Scanner scanner = new Scanner(System.in);
        ClearScreen.clear();
        System.out.println("Which genre would you like to search for?");
        System.out.print("Please enter the genre: \n");
        List<Genre> allGenres = workManager.getGenres();
        if (allGenres.isEmpty()) return null;
        System.out.println("\n0 - None");
        for (int i = 0; i < allGenres.size(); i++) {
            System.out.println((i + 1) + " - " + allGenres.get(i));
        }
        System.out.print("\nChoose the genre number (or 0):");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice > 0 && choice <= allGenres.size()) {
                return allGenres.get(choice - 1);
            }
        } catch (NumberFormatException e) { /* Ignora erro, retorna null */ }
        return null;
    }

    // This method prints the media list in a table format
    private void printMediaTable(List<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("📭 No media found..");
            return;
        }
        System.out.printf("%-30s | %-10s | %-6s | %-10s| %-10s%n",
                "Title", "Type", "Year", "★ Rating", "Genre");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        for (Media m : mediaList) {
            String title = truncate(m.getTitle(), 30);
            String type = m.getClass().getSimpleName();
            int year = m.getYearRelease();
            float avg = WorkManager.calculateAverage(m);

            String genresString;
            if (m.getGenres() == null || m.getGenres().isEmpty()) {
                genresString = "(N/A)";
            } else {
                genresString = m.getGenres().stream()
                        .filter(Objects::nonNull)
                        .map(Genre::toString)
                        .collect(Collectors.joining(", "));
            }
            System.out.printf("%-30s | %-10s | %-6d | %-10.1f | %-10s%n",
                    title, type, year, avg, genresString);
        }
    }


    private String truncate(String s, int len) {
        return s.length() > len ? s.substring(0, len - 3) + "..." : s;
    }

    private void printDetailedMediaList(List<Media> mediaList, String titleForList) {
        System.out.println("\n<=======================================================>");
        System.out.println("          " + titleForList);
        System.out.println("<=======================================================>");

        if (mediaList == null || mediaList.isEmpty()) {
            System.out.println("\n          ### No media found. ###");
            System.out.println("<=======================================================>");
            return;
        }

        int count = 1;
        for (Media m : mediaList) {
            System.out.println("\n--- Item #" + count++ + " -----------------------------------------");

            // --- Common Information (from the Media class) ---
            System.out.println("  Title: " + m.getTitle());

            // Tries to get the original title if it's an AudioVisualMedia
            if (m instanceof AudioVisualMedia) {
                AudioVisualMedia avm = (AudioVisualMedia) m;

                // Only displays if it's different from the main title and not null
                if (avm.getOriginalTitle() != null && !avm.getOriginalTitle().equalsIgnoreCase(m.getTitle())) {
                    System.out.println("  Original Title: " + avm.getOriginalTitle());
                }
            }
            System.out.println("  Release Year: " + m.getYearRelease());

            String genresString = "(None)";
            if (m.getGenres() != null && !m.getGenres().isEmpty()) {
                genresString = m.getGenres().stream()
                        .filter(Objects::nonNull)
                        .map(Genre::toString)
                        .collect(Collectors.joining(", "));
            }
            System.out.println("  Genre: " + genresString);
            System.out.println("  Seen/Read? " + (m.isSeen() ? "Yes" : "No"));
            System.out.printf("  Review: %.1f ★%n", WorkManager.calculateAverage(m));

            //
            if (m instanceof Book) {
                Book book = (Book) m;
                System.out.println("  Type: Book");
                System.out.println("  Author: " + book.getAuthor());
                System.out.println("  Publisher: " + book.getPublisher());
                System.out.println("  ISBN: " + book.getIsbn());
                System.out.println("  Do you own a copy? " + (book.getCopy() ? "Sim" : "Não"));
                // Prints the book reviews using the auxiliary method
                printReviewsForMedia(m.getReviews(), "  ");

            } else if (m instanceof Films) {
                Films film = (Films) m;
                System.out.println("  Type: Film");
                System.out.println("  Direction: " + film.getDirection());
                System.out.println("  Screenplay: " + film.getScreenplay());
                System.out.println("  Duration: " + film.getRunningtime() + " min");

                // Prints Cast and Where to Watch using the auxiliary method
                printStringList(film.getCast(), "  Cast: ");
                printStringList(film.getWhereWatch(), "  Where to Watch: ");
                printReviewsForMedia(m.getReviews(), "  ");

            } else if (m instanceof Show) {
                Show show = (Show) m;
                System.out.println("  Type: TV Show");

                if (show.getYearEnd() > 0 && show.getYearEnd() != show.getYearRelease()) {
                    System.out.println("  Period: " + show.getYearRelease() + " - " + show.getYearEnd());
                }

                printStringList(show.getCast(), "  Cast: ");
                printStringList(show.getWhereWatch(), "  Where to Watch: ");

                // Season Details
                if (show.getSeasons() != null && !show.getSeasons().isEmpty()) {
                    System.out.println("  Seasons (" + show.getSeasons().size() + "):");
                    // Iterates over each season of the show
                    for (Season season : show.getSeasons()) {
                        // Checks for null season
                        if (season != null) {
                            System.out.println("    - Season " + season.getSeasonNumber() + ":");
                            System.out.println("      Episodes: " + season.getEpisodeCount());
                            System.out.println("      Release: " + season.getReleaseDate());
                            // Prints reviews for this season using the auxiliary method
                            printReviewsForMedia(season.getReviews(), "      ");
                        } else {
                            System.out.println("    - (Error: null season found)");
                        }
                    }
                } else {
                    System.out.println("  Seasons: (No seasons registered)");
                }
                // General reviews are not printed for Show, as they are found in the seasons
            } else {
                // Case for other types of Media that may exist
                System.out.println("  Type: Unknown Media");
            }

        }

        System.out.println("---------------------------------------------------");
    }

    private void printReviewsForMedia(List<Review> reviews, String prefix) {
        if (reviews != null && !reviews.isEmpty()) {
            System.out.println(prefix + "Reviews:");

            for (Review review : reviews) {
                if (review != null) {
                    System.out.println(prefix + "  * " + review);
                } else {
                    System.out.println(prefix + "  * (Error: null review found)");
                }
            }
        } else {
            System.out.println(prefix + "Reviews: (null or empty)");
        }
    }

    private void printStringList(List<String> list, String label) {
        String content = "(Not specified)";

        if (list != null && !list.isEmpty()) {

            content = list.stream()
                    .filter(s -> s != null && !s.trim().isEmpty())
                    .collect(Collectors.joining(", "));

            if (content.isEmpty()) {
                content = "(Not specified)";
            }
        }

        System.out.println(label + content);
    }

}





