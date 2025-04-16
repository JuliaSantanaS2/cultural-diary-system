package View;

import Control.WorkManager;
import java.util.Scanner;
import java.util.ArrayList;
import Module.Book;

public class Screen {

    Menu menu = new Menu();
    WorkManager workManager = new WorkManager();
    Create create = new Create(workManager);
    CreateReview createReview = new CreateReview(workManager);

    public void start() {
        int option_one = menu.showMenu();

        switch (option_one) {
            case 1:
                showRegisterMenu();

                break;
            case 2:
                createReview.showCreateReview();
                System.out.println("Books");
                workManager.getBooks();
                break;
            case 3:
                workManager.printLibraryTable();
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
                //showEditRegister();
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
                System.out.println("Lista de livros na biblioteca:");
                workManager.getBooks();
                showAddRegister();
                break;
            case 2:
                //create.createShow();
                System.out.println("Invalid option.");
                break;
            case 3:
                //create.createFilm();
                System.out.println("Invalid option.");
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