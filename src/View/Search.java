package View;

import java.util.Scanner;
import Control.WorkManager;

public class Search {


    Screen screen ;

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
        System.out.println("2 - Individual lists ");
        System.out.println("3 - Return to the main menu");
        System.out.println("<------------------------------->\n");
        option_listing = scanner.nextInt();

        if (option_listing == 10) {
            workManager.printAllMedia();
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

        //workManager.printAllMedia();

    }

    //Serao implementados os metodos de list
    public void mediaListMenu() {
        Scanner scanner = new Scanner(System.in);
        int option_list;

        do {
            System.out.println("<------------------------------->");
            System.out.println("What would you like to do?");
            System.out.println("1 - ");
            System.out.println("2 - ");
            System.out.println("3 - ");
            System.out.println("<------------------------------->\n");
            option_list = scanner.nextInt();

            switch (option_list) {
                case 1:
                    System.out.println("Return1lis.");
                    break;
                case 2:
                    System.out.println("Return2lis.");
                    break;
                case 3:
                    System.out.println("Returnlist.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_list != 3);
    }

}