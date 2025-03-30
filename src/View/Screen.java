package View;

import Control.WorkManager;
import java.util.Scanner;

public class Screen {

    Menu menu = new Menu();
    WorkManager workManager = new WorkManager();
    Create create = new Create();

    public void start() {
        int option_one = menu.showMenu();

        switch (option_one) {
            case 1:
                showRegisterMenu();
                break;
            case 2:
                System.out.println("Review not implemented yet.");
                break;
            case 3:
                System.out.println("Search not implemented yet.");
                break;
            case 4:
                System.out.println("Backup not implemented yet.");
                break;
            case 5:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid option.");

        }
    }

    private void showRegisterMenu() {
        int option_two = menu.menuRegister();

        switch (option_two) {
            case 1:
                showAddRegister();
                break;
            case 2:
                showEditRegister();
                break;
            case 3:
                System.out.println("Return.");
                start();
                break;
            default:
                System.out.println("Invalid option.");

        }

    }

    private void showAddRegister() {
        int option_three = menu.addRegister();

        switch (option_three) {
            case 1:
                create.createBook();
                workManager.getBooks();
                System.out.println("todos os libros.");
                break;
            case 2:
                create.createShow();
                break;
            case 3:
                create.createFilm();
                break;
            case 4:
                showRegisterMenu();
                break;
            default:
                System.out.println("Invalid option.");

        }






    }

    private void showEditRegister() {
        menu.editRegister();






    }








}