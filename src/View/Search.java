package View;

import java.util.Scanner;
import Control.WorkManager;
import Module.Media;
import java.util.List;
import java.util.Map;

public class Search {


    Screen screen;

    final WorkManager workManager;

    public Search(WorkManager workManager) {
        this.workManager = workManager;
    }

    public void clean() {
        ClearScreen.clear();
    }


    //Serao implementados os metodos de busca
    public void mediaSearchMenu() {
        Scanner scanner = new Scanner(System.in);
        int option_listing, option_sort, option_filter;

        System.out.println("<------------------------------->");
        System.out.println("Option for listing");
        System.out.println("1 - All lists");
        System.out.println("2 - Search");
        System.out.println("3 - Return to the main menu");
        System.out.println("<------------------------------->\n");
        option_listing = scanner.nextInt();

        if (option_listing == 1) {
            workManager.printAllMedia();
            return;
        }
        if (option_listing == 2) {
            mediaSearchmenu2();
            return;
        }

        if (option_listing == 3) {
            screen.start();
        }

        System.out.println("<------------------------------->");
        System.out.println("Would you like to sort by rating?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        System.out.println("3 - Return to the main menu");
        System.out.println("<------------------------------->\n");
        option_sort = scanner.nextInt();

        if (option_sort == 3) {
            screen.start();
        }

        System.out.println("<------------------------------->");
        System.out.println("Would you like to filter?");
        System.out.println("1 - Yes, by year");
        System.out.println("2 - Yes, by genre");
        System.out.println("3 - Yes, by genre and year");
        System.out.println("4 - No");
        System.out.println("5 - Return to the main menu");
        System.out.println("<------------------------------->\n");
        option_filter = scanner.nextInt();

        if (option_filter == 5) {
            screen.start();
        }

    }

    //Serao implementados os metodos de list
    public void mediaListMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n<------------------------------->");
            System.out.println("List all media - choose criteria:");
            System.out.println("1 - Alphabetical (A–Z)");
            System.out.println("2 - By Genre");
            System.out.println("3 - By Release Year");
            System.out.println("4 - Return");
            System.out.print("Option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    List<Media> list = workManager.listMediaAlphabetically();
                    printMediaTable(list);
                }
                case 2 -> {
                    Map<String, List<Media>> byGenre = workManager.listMediaByGenre();
                    for (var entry : byGenre.entrySet()) {
                        System.out.println("\n🎬 Gênero: " + entry.getKey());
                        printMediaTable(entry.getValue());
                    }
                }
                case 3 -> {
                    Map<Integer, List<Media>> byYear = workManager.listMediaByYear();
                    for (var entry : byYear.entrySet()) {
                        System.out.println("\n📅 Ano: " + entry.getKey());
                        printMediaTable(entry.getValue());
                    }
                }
                case 4 -> System.out.println("🔙 Returning to previous menu...");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (option != 4);
    }

    /** Impressão tabulada das mídias */
    private void printMediaTable(List<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("📭 Nenhuma mídia encontrada.");
            return;
        }
        System.out.printf("%-30s | %-15s | %-6s | %-6s%n",
                "Título", "Tipo", "Ano", "★ Aval");
        System.out.println("---------------------------------------------------------------");
        for (Media m : mediaList) {
            String title = truncate(m.getTitle(), 30);
            String type  = m.getClass().getSimpleName();
            int    year  = m.getYearRelease();
            float avg = WorkManager.calculateAverage(m);
            System.out.printf("%-30s | %-15s | %-6d | %-6.1f%n",
                    title, type, year, avg);
        }
    }

    private String truncate(String s, int len) {
        return s.length() > len ? s.substring(0, len - 3) + "..." : s;
    }



    // Para fazer o print por caracteristica
    public void mediaSearchmenu2() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select a search option:");
            System.out.println("1 - Search by title");
            System.out.println("2 - Search book by author");
            System.out.println("3 - Search by genre");
            System.out.println("4 - Search by year");
            System.out.println("5 - Search book by ISBN");
            System.out.println("6 - Search film by director");
            System.out.println("7 - Search film by cast");
            System.out.println("8 - Search series by cast");
            System.out.println("9 - Return to main menu");
            System.out.println("<------------------------------->");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    workManager.searchByTitle(title).forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    workManager.searchBooksByAuthor(author).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    workManager.searchByGenre(genre).forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    workManager.searchByYear(year).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    workManager.searchBooksByISBN(isbn).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    workManager.searchFilmsByDirector(director).forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("Enter actor/actress name: ");
                    String actor = scanner.nextLine();
                    workManager.searchFilmsByCast(actor).forEach(System.out::println);
                    break;
                case 8:
                    System.out.print("Enter actor/actress name: ");
                    String showActor = scanner.nextLine();
                    workManager.searchShowsByCast(showActor).forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Returning...");
                    break;
                default:
                    System.out.println("❌ Invalid option.");
            }

        } while (option != 9);
    }

    public void searchByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title to search:");
        String input = scanner.nextLine().toLowerCase();

        workManager.searchByTitle(input);
    }

}

