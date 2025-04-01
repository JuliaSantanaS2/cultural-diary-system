package View;

import java.util.Scanner;

public class Menu {

    public void clean() {
        ClearScreen.clear();
    }

    //MENU PRINCIPAL
    public int showMenu(){
        Scanner scanner = new Scanner(System.in);
        String option;
        boolean isValidOption = false;

        do {

            System.out.println("<----------------------------->");
            System.out.println("Welcome to the Cultural Diary System");
            System.out.println("Version 1.0");
            System.out.println("Author: <Davi Figuerêdo and Julia Santana>");
            System.out.println("<----------------------------->");
            System.out.println("1 - Register");
            System.out.println("2 - Review");
            System.out.println("3 - Search");
            System.out.println("4 - Backup (Not implemented yet)");
            System.out.println("5 - Exit");
            System.out.println("------------------------------>");
            System.out.println("Please, select an option:");

            option = scanner.nextLine();

            switch (option){
                case "1":
                    return 1;

                case "2":
                    return 2;

                case "3":
                    return 3;

                case "4":
                    return 4;
                case "5":
                    return 5;
                default:
                    clean();
                    System.out.println("Invalid option");

            }
        }
        while (option.equals("5"));
        return -1;
    }

    // MENU DE SELEÇÃO DO REGISTRO
    public int menuRegister(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidOption = false;
        String option;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the registration option:");
            System.out.println("1 - Register new cultural diary");
            System.out.println("2 - Edit cultural diary");
            System.out.println("3 - Return to the cultural diary menu");
            System.out.println("<------------------------------->\n");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option.equals("3"));
        return -1;
    }

    //MENU DE ADIÇÃO DE REGISTRO
    public int addRegister(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidOption = false;
        String option;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add new book");
            System.out.println("2 - Add new show");
            System.out.println("3 - Add new film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option.equals("4"));
        return -1;
    }

    //MENU DE EDIÇÃO DE ALGUM REGISTRO
    public int editRegister(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidOption = false;
        String option;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Edit book");
            System.out.println("2 - Edit show");
            System.out.println("3 - Edit film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            option = scanner.nextLine();

            switch (option){
                case "1":
                    return 1;
                case "2" :
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option.equals("4"));
        return -1;
    }

}