package View;

import Module.Genre;
import Control.WorkManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create {
    Scanner scanner = new Scanner(System.in);
    WorkManager workManager = new WorkManager();



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

    if (selectedGenres.isEmpty()) {
        System.out.println("⚠️ A lista de gêneros não pode estar vazia. Adicione pelo menos um gênero.");
        return addGenresMedia();
    }

    return selectedGenres;
}

    public boolean confirmationCopy() {
        boolean result = false;
        while (!result) {
            System.out.println("Você tem cópia do livro?");
            System.out.println("[1] - Sim");
            System.out.println("[2] - Não");
            System.out.print("Digite a opção desejada: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            } else {
                System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
        }
        return false;
    }


    public void createBook() {

        System.out.println("<----------------------------->");
        System.out.println("Digite o titulo do Livro:");
        String title = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Escolhas os Generos do Livro:");
        List<Genre> genres = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Digite o ano de Publicação do Livro:");
        int yearRelease = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite o Autor do Livro:");
        String author = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite a Editora do Livro:");
        String publisher = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite o ISBN do Livro:");
        String isbn = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Você tem Copia do  Livro:");
        boolean copy = confirmationCopy();

        workManager.createBook(title, genres, yearRelease, author, publisher, isbn, copy);
    }





    public void createShow() {

    }
    public void createFilm() {

    }























}
