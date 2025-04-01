package View;

import Module.Genre;
import Control.WorkManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create {
    Scanner scanner = new Scanner(System.in);
    private WorkManager workManager;

    public Create(WorkManager workManager) {
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

        if (selectedGenres.isEmpty()) {
            System.out.println("⚠️ A lista de gêneros não pode estar vazia. Adicione pelo menos um gênero.");
            return addGenresMedia();
        }
        return selectedGenres;
    }

    public boolean confirmationBoolean() {
        boolean result = false;
        while (!result) {
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

    public void addAnotherMedia_Question() {
        int result = 0;
        while (result == 0) {
            System.out.println("Você deseja adcionar outro?");
            System.out.println("[1] - Sim");
            System.out.println("[2] - Não");
            System.out.print("Digite a opção desejada: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                createBook();
            } else if (input.equals("2")) {
                result = 1;
            } else {
                System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
        }
    }


    public void createBook() {

        System.out.println("<----------------------------->");
        System.out.println("Digite o titulo do Livro:");
        String title = scanner.nextLine();

        System.out.println("Digite o titulo original do Livro:");
        String originalTitle = scanner.nextLine();
        if (originalTitle.isEmpty()) {
            originalTitle = title;
        }

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
        boolean copy = confirmationBoolean();

        System.out.println("<----------------------------->");
        System.out.println("Você Já leu o Livro?:");
        boolean seen = confirmationBoolean();

        workManager.createBook(seen,title, genres,  yearRelease, author, publisher, isbn, copy);
        addAnotherMedia_Question();


    }






/*
    public void createShow() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o titulo da Serie:");
        String title = scanner.nextLine();

        System.out.println("Digite o titulo original da Serie:");
        String originalTitle = scanner.nextLine();
        if (originalTitle.isEmpty()) {
            originalTitle = title;
        }

        System.out.println("<----------------------------->");
        System.out.println("Escolhas os Generos da Serie:");
        List<Genre> genres = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Digite o ano de Lançamento da Serie:");
        int yearRelease = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Onde você assistiu:");
        String whereWatch = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Você já assistiu a Serie?");
        boolean copy = confirmationCopy();

        System.out.println("<----------------------------->");
        System.out.println("Digite Quantas Temporadas a Serie Tem:");
        int seasonTemp = Integer.parseInt(scanner.nextLine());

        workManager.createShow(title, genres, yearRelease, whereWatch, copy);


    }
    public void createSeason() {

        System.out.println("<----------------------------->");
        System.out.println("Essa é a Ultima Temporada?");
        System.out.println("[1] - Sim");
        System.out.println("[2] - Não");
        System.out.print("Digite a opção desejada: ");
        String ultimaTemp = scanner.nextLine();

        if (ultimaTemp(equals("1"){

            System.out.println("<----------------------------->");
            System.out.println("Digite o Ano de Conclusão da Temporada:");
            String yearConclusion = scanner.nextLine();
        }

        System.out.println("<----------------------------->");
        System.out.println("Digite a quantidade de Episodios da Temporada:");
        int seasonEpisode = Integer.parseInt(scanner.nextLine());

        workManager.createSeason(yearConclusion, seasonEpisode);
    }

    /*
    public void createFilm() {
    System.out.println("<----------------------------->");
    System.out.println("Digite o titulo do Filme:");
    String title = scanner.nextLine();

    System.out.println("<----------------------------->");
    System.out.println("Digite o Titulo Original do Filme:");
    String originalTitle = scanner.nextLine();
            if (originalTitle.isEmpty()) {
            originalTitle = title;
        }

    System.out.println("<----------------------------->");
    System.out.println("Escolhas os Generos do Filme:");
    List<Genre> genres = addGenresMedia();

    System.out.println("<----------------------------->");
    System.out.println("Digite o ano de Lançamento do Filme:");
    int yearRelease = Integer.parseInt(scanner.nextLine());

    System.out.println("<----------------------------->");
    System.out.println("Digite o Diretor do Filme:");
    String director = scanner.nextLine();

    System.out.println("<----------------------------->");
    System.out.println("Onde você assistiu:");
    String whereWatch = scanner.nextLine();

    System.out.println("<----------------------------->");
    System.out.println("Você já assistiu o Filme?");
    boolean copy = confirmationCopy();

    workManager.createFilm(title, genres, yearRelease, originalTitle, director, whereWatch, copy);
    }
     */













}
