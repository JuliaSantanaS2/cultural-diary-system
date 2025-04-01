package View;

import Module.Review;
import Module.Book;
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
    private WorkManager workManager;

    public CreateReview(WorkManager workManager) {
        this.workManager = workManager;
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

    public String dateNow() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
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
                // Implementar criação de filme
                break;
            case "3":
                // Implementar criação de Seie/Temporada
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
}