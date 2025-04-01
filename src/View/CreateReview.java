package View;

import Module.Review;
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


    public List<Genre> addGenresMedia() {
        List<Genre> allGenres = workManager.getGenres();
        List<Genre> selectedGenres = new ArrayList<>();

        while (true) {
            System.out.println("Selecione um gênero (digite o número correspondente):");
            for (int i = 0; i < allGenres.size(); i++) {
                System.out.println((i + 1) + " - " + allGenres.get(i).getGenre());
            }

            int genreIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            Genre genre = allGenres.get(genreIndex);
            if (!selectedGenres.contains(genre)) {
                selectedGenres.add(genre);
            }

            System.out.println("Deseja adicionar mais um gênero? (s/n)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("s")) {
                break;
            }
        }

    public String dateNow() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }


    public void showCreateReview() {
        System.out.println("<----------------------------->");
        System.out.println("Escolha o tipo de mídia:");
        System.out.println("1. Livro");
        System.out.println("2. Filme");
        System.out.println("3. Série/Temporada");
        System.out.println("5. Voltar");

        String option = scanner.nextLine();

        switch (option) {
            case "1":
                createReviewBook();
                break;
            case "2":
                // Implementar criação de filme
                break;
            case "3":
                // Implementar criação de música
                break;
            case "4":
                // Implementar criação de jogo
                break;
            case "5":
                // Voltar ao menu anterior
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void createReviewBook() {

        System.out.println("<----------------------------->");
        System.out.println("Digite a sua Review sobre o Book:");
        String comment = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        int stars = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite sua Stars entre 1 e 5:");
        String reviewDate = dateNow();


        workManager.createReviewBook(comment, stars, reviewDate);


    }
}