/* package View;

// isso é um comentario de ovo de pascoa ;)
import java.util.Scanner;
import Control.WorkManager;

public class Menu {

    //MENU PRINCIPAL
    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("<----------------------------->");
            System.out.println("Welcome to the Cultural Diary System");
            System.out.println("Version 1.0");
            System.out.println("Author: <Davi Figuerêdo and Julia Santana>");
            System.out.println("<----------------------------->");
            System.out.println("1 - Register");
            System.out.println("2 - Review");
            System.out.println("3 - Backup (Not implemented yet)");
            System.out.println("4 - Exit");
            System.out.println("------------------------------>");
            System.out.println("Please, select an option:");
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    register();
                    break;
                case "2":
                    review();
                    break;

                //case "3": (not implemented)

                case "4":
                    System.out.println("Bye :3");
                    break;

                default:
                    System.out.println("Invalid option");

            }
        }while(opcao.equals("4"));
    }

    // MENU DE SELEÇÃO DO REGISTRO
    public void register(){
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the registration option:");
            System.out.println("1 - Register new cultural diary");
            System.out.println("2 - Edit cultural diary");
            System.out.println("3 - Return to the cultural diary menu");
            System.out.println("<------------------------------->\n");
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    addRegister();
                    break;

                case "2":
                    editRegister();
                    break;

                case "3":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while(opcao.equals("3"));
    }

    //MENU DE ADIÇÃO DE REGISTRO
    public void addRegister(){
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add new book");
            System.out.println("2 - Add new show");
            System.out.println("3 - Add new film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    WorkManager.addBooks();
                    break;
                case "2":
                    WorkManager.addShow();
                    break;
                case "3":
                    WorkManager.addFilm();
                    break;
                case "4":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }while (opcao.equals("4"));
    }

    //MENU DE EDIÇÃO DE ALGUM REGISTRO
    public void editRegister(){
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {


            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Edit book");
            System.out.println("2 - Edit show");
            System.out.println("3 - Edit film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            opcao = scanner.nextLine();

            switch (opcao){
                case "1":

                case "2" :

                case "3":

                case "4":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }while (opcao.equals("4"));
    }

    //MENU DE SELEÇÃO DE REVIEW
    public void review(){
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add a review");
            System.out.println("2 - Edit a review");
            System.out.println("3 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":

                case "2":

                case "3":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while (opcao.equals("3"));
    }

    //MENU DE ADIÇÃO DE REVIEW
    public void addReview(){
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {


            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add a review for book");
            System.out.println("2 - Add a review for film");
            System.out.println("3 - Add a review for show");
            System.out.println("<------------------------------->");
            opcao = scanner.nextLine();

            switch (opcao){
                //vazio por falta da classe
                case "1":

                case "2":

                case "3":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }while (opcao.equals("4"));
    }
    //MENU DE EDIÇÃO DE REVIEW
    public void editReview(){
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {


            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Edit a book review");
            System.out.println("2 - Edit a film review");
            System.out.println("3 - Edit a show review");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            opcao = scanner.nextLine();

            switch (opcao){
                case "1":

                case "2":

                case "3":

                case "4":
                    menu();
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }while (opcao.equals("4"));
    }
}

 */
