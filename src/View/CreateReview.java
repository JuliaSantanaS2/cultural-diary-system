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



    public CreateReview(WorkManager workManager) {
        this.workManager = workManager;
     }



    public String dateNow() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    public void messager(int result) {
        if (result == 0) {
            System.out.println("Review criada com sucesso!");
        } else if (result == 1) {
            System.out.println("Livro não encontrado.");
        } else if (result == 2) {
            System.out.println("Você ainda não viu esse livro.");
        }
        else {
            System.out.println("Erro ao criar a review.");
        }
    }

    public void showCreateReview() {

        int result;
        System.out.println("<----------------------------->");
        System.out.println("Escolha o tipo de mídia:");
        System.out.println("1. Livro");
        System.out.println("2. Filme");
        System.out.println("3. Série/Temporada");
        System.out.println("5. Voltar");

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
                //
                break;
            case "5":
                // Voltar ao menu anterior
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void createReviewBookData() {


        System.out.println("<----------------------------->");
        System.out.println("Qual Livro você deseja fazer a Review?:");
        String title = selectBookFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Digite a sua Review sobre o Book:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        String reviewDate = dateNow();

        int result = workManager.createReviewBook(title,comment, stars, reviewDate);
        messager(result);
    }

    public String selectBookFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o título do livro que você deseja selecionar:");

        List<String> books = workManager.getBooksName();
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + " - " + books.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return books.get(nameBookIndex);
    }


    // Método para criar uma review de filme
    public void createReviewFilmsData() {


        System.out.println("<----------------------------->");
        System.out.println("Qual Filme você deseja fazer a Review?:");
        String title = selectFilmFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Digite a sua Review sobre o Filme:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        String reviewDate = dateNow();

        int result = workManager.createReviewFilm(title,comment, stars, reviewDate);
        messager(result);
    }

    public String selectFilmFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o título do Filme que você deseja selecionar:");

        List<String> film = workManager.getFilmName();
        for (int i = 0; i < film.size(); i++) {
            System.out.println((i + 1) + " - " + film.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return film.get(nameBookIndex);
    }

    // Método para criar uma review de série
    public void createReviewShowSerieData() {

        System.out.println("<----------------------------->");
        System.out.println("Qual Serie você deseja fazer a Review?:");
        String title = selectShowFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Qual Temporada você deseja fazer a Review?:");
        int seasonNumber = selectSeasonFromLibrary(title);

        System.out.println("<----------------------------->");
        System.out.println("Digite a sua Review sobre o Serie:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        String reviewDate = dateNow();

        int result = workManager.createReviewShow(title,seasonNumber,comment, stars, reviewDate);
        messager(result);
        workManager.getShow();
    }

    public String selectShowFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o título do Serie que você deseja selecionar:");

        List<String> film = workManager.getShowName();
        for (int i = 0; i < film.size(); i++) {
            System.out.println((i + 1) + " - " + film.get(i));
        }

        int nameBookIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return film.get(nameBookIndex);
    }

    public int selectSeasonFromLibrary(String title) {
        System.out.println("<----------------------------->");
        System.out.println("Digite o número da Temporada que você deseja selecionar:");

        List<Integer> seasons = workManager.getSeasonsByShowName(title);
        for (int i = 0; i < seasons.size(); i++) {
            System.out.println((i + 1) + " - " + seasons.get(i));
        }

        int nameSeasonIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        return seasons.get(nameSeasonIndex);
    }






}