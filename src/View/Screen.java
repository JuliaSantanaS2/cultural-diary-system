package View;

import Control.WorkManager;
import java.util.Scanner;

public class Screen {

    WorkManager workManager = new WorkManager();
    Search search = new Search(workManager);
    Create create = new Create(workManager);
    CreateReview createReview = new CreateReview(workManager);


    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option_stars_menu;

        do {
            System.out.println("<----------------------------->");
            System.out.println("Welcome to the Cultural Diary System");
            System.out.println("Version 1.0");
            System.out.println("Author: <Davi Figuerêdo and Julia Santana>");
            System.out.println("<----------------------------->");
            System.out.println("1 - Register"); //showRegisterMenu
            System.out.println("2 - Review"); //createReview.showCreateReview
            System.out.println("3 - Search"); // showSearchMenu
            System.out.println("4 - Backup (Not implemented yet)"); //start
            System.out.println("5 - Exit"); //exit
            System.out.println("------------------------------>");
            System.out.println("Please, select an option:");

            option_stars_menu = scanner.nextInt();
            ClearScreen.clear();

            switch (option_stars_menu) {
                case 1:
                    showRegisterMenu();
                    break;
                case 2:
                    createReview.showCreateReview();
                    break;
                case 3:
                    showSearchMenu();
                    break;
                case 4:
                    start();
                    System.out.println("Backup not implemented yet.");
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (option_stars_menu != 5);

    }

    public void showRegisterMenu() {
        Scanner scanner = new Scanner(System.in);
        int option_register_menu;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the registration option:");
            System.out.println("1 - Register new cultural diary"); // showAddRegister
            System.out.println("2 - Genres"); // showAddGenres
            System.out.println("3 - Return to the cultural diary menu"); //stars
            System.out.println("<------------------------------->\n");
            option_register_menu = scanner.nextInt();
            ClearScreen.clear();

            switch (option_register_menu) {
                case 1:
                    showAddRegister();
                    break;
                case 2:
                    showAddGenres();
                    break;
                case 3:
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                    start();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_register_menu != 3);
    }

    public void showAddRegister() {
        int result_create = create.menuCreat();
        if (result_create == 4) {
            start();
        }
    }

    public void showAddGenres() {
        Scanner scanner = new Scanner(System.in);
        int option_addGenres;
        String genreName;


        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add new genre"); // Call Workmanager.addGenre
            System.out.println("2 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            option_addGenres = scanner.nextInt();
            scanner.nextLine();

            switch (option_addGenres) {
                case 1:
                    System.out.println("<------------------------------->");
                    System.out.println("Please type which genre you would like to add.:");
                    genreName = scanner.nextLine();
                    workManager.addGenre(genreName);

                    ClearScreen.clear();
                    System.out.println("✅ Gender successfully registered!");
                    System.out.println("All genres currently added:\n");
                    workManager.getGenresTest();
                    break;

                case 2:
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                    showRegisterMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option_addGenres != 2);

    }

    public void showSearchMenu() {
        Scanner scanner = new Scanner(System.in);
        int option_search_menu;

        do {
            System.out.println("<------------------------------->");
            System.out.println("What would you like to do?");
            System.out.println("1 - Search for media in the journal"); // search.mediaSearchMenu
            System.out.println("2 - List all media"); // showAddGenres
            System.out.println("3 - Return to the cultural diary menu"); //stars
            System.out.println("<------------------------------->\n");
            option_search_menu = scanner.nextInt();
            ClearScreen.clear();

            switch (option_search_menu) {
                case 1:
                    search.mediaSearchMenu();
                    break;
                case 2:
                    search.mediaListMenu();
                    break;
                case 3:
                    ClearScreen.clear();
                    System.out.println("🔙 Returning to previous menu...");
                    start();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_search_menu != 3);
    }

}








