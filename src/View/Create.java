package View;

import Module.Genre;
import Control.WorkManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Create {
    Scanner scanner = new Scanner(System.in);
    final WorkManager workManager;
    private Screen screen;

    public Create(WorkManager workManager) {
        this.workManager = workManager;
    }

    public int menuCreat() {
        Scanner scanner = new Scanner(System.in);
        int option_create_menu;

        do {
            System.out.println("<------------------------------->");
            System.out.println("Select the option:");
            System.out.println("1 - Add new book");
            System.out.println("2 - Add new show");
            System.out.println("3 - Add new film");
            System.out.println("4 - Return to the cultural diary menu");
            System.out.println("<------------------------------->");
            option_create_menu = scanner.nextInt();

            switch (option_create_menu) {
                case 1:
                    createBook();
                    break;
                case 2:
                    menuShow();
                    break;
                case 3:
                    createFilm();
                    break;
                case 4:
                    System.out.println("Return.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while (option_create_menu != 4);
        return option_create_menu;

    }

    // Method to add genres to the media
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
    // Method to confirm if the user has a copy of the media or seen it
    public boolean confirmationBoolean() {
        boolean result = false;
        while (!result) {
            System.out.println("[1] - Sim");
            System.out.println("[2] - Não");
            System.out.print("Digite a opção desejada: ");

            int input = scanner.nextInt();

            if (input == 1) {
                return true;
            } else if (input == 2) {
                return false;
            } else {
                System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
        }
        return false;
    }

    // Method to confirm if the user wants to add another media
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

        workManager.createBook(seen, title, genres, yearRelease, author, publisher, isbn, copy);
        addAnotherMedia_Question();


    }

    public void createFilm() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o titulo do Filme:");
        String title_films = scanner.nextLine();

        System.out.println("Digite o titulo original do Livro:");
        String originalTitle_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Escolhas os Generos do Filme:");
        List<Genre> genres_films = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Digite o ano de lançamento:");
        int yearRelease_films = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite a duração do filme em minutos:");
        int runningtime_films = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite o Direção do Filme:");
        String direction_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite a Roterista do Filme:");
        String screenplay_films = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Digite o elenco do Filme:");
        System.out.println("<--Digite separado por ',' (Virgula)-->");
        String input_cast = scanner.nextLine();
        List<String> cast = Arrays.asList(input_cast.split(",\\s*"));


        System.out.println("<----------------------------->");
        System.out.println("Digite onde assistir o filme:");
        System.out.println("<--Digite separado por ',' (Virgula)-->");
        String input_whereWatch = scanner.nextLine();
        List<String> whereWatch = Arrays.asList(input_whereWatch.split(",\\s*"));


        System.out.println("<----------------------------->");
        System.out.println("Você Já assistiu o Filme?:");
        boolean seen = confirmationBoolean();

        workManager.createFilm(cast, seen, title_films, genres_films, yearRelease_films, originalTitle_films, whereWatch, direction_films, runningtime_films, screenplay_films);

        addAnotherMedia_Question();
    }

    public void menuShow() {
        Scanner scanner = new Scanner(System.in);
        int option_show_menu;

        do {
            System.out.println("<----------------------------->");
            System.out.println("Selecione a opção:");
            System.out.println("[1] - Adicionar uma nova série");
            System.out.println("[2] - Adicionar uma nova temporada");
            System.out.println("[3] - Voltar ao menu anterior");
            System.out.println("<----------------------------->");
            option_show_menu = scanner.nextInt();

            switch (option_show_menu) {
                case 1:
                    createShow();
                    break;
                case 2:
                    createSeason();
                    break;
                case 3:
                    menuCreat();
                    System.out.println("Retornar.");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        while (option_show_menu != 3);


    }


    public void createShow() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o titulo da Serie:");
        String title = scanner.nextLine();

        System.out.println("Digite o titulo original da Serie:");
        String originalTitle = scanner.nextLine();

        System.out.println("<----------------------------->");
        System.out.println("Escolhas os Generos da Serie:");
        List<Genre> genres = addGenresMedia();

        System.out.println("<----------------------------->");
        System.out.println("Digite o elenco do Serie:");
        System.out.println("<--Digite separado por ',' (Virgula)-->");
        String input_cast = scanner.nextLine();
        List<String> cast = Arrays.asList(input_cast.split(",\\s*"));

        System.out.println("<----------------------------->");
        System.out.println("Digite o ano de Lançamento da Serie:");
        int yearRelease = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite o ano de Lançamento de Encerramento:");
        int yearEnd = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite onde assistir o filme:");
        System.out.println("<--Digite separado por ',' (Virgula)-->");
        String input_whereWatch = scanner.nextLine();
        List<String> whereWatch = Arrays.asList(input_whereWatch.split(",\\s*"));


        System.out.println("<----------------------------->");
        System.out.println("Você já assistiu a Serie?");
        boolean seen = confirmationBoolean();

        workManager.createShow(cast, seen, title, genres, yearRelease, originalTitle, whereWatch, yearEnd);

    }

    public void createSeason() {

        System.out.println("<----------------------------->");
        System.out.println("Qual Livro você deseja fazer a Review?:");
        String title = selectShowFromLibrary();

        System.out.println("<----------------------------->");
        System.out.println("Digite o número da temporada:");
        int seasonNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite a quantidade de episódios da temporada:");
        int episodeCount = Integer.parseInt(scanner.nextLine());

        System.out.println("<----------------------------->");
        System.out.println("Digite a data de lançamento da temporada:");
        System.out.println("Formato dd/mm/aaaa:");
        String releaseDate = scanner.nextLine();

        workManager.createSeason(title,seasonNumber, episodeCount, releaseDate);
        workManager.getShow();
    }

    public String selectShowFromLibrary() {
        System.out.println("<----------------------------->");
        System.out.println("Digite o número da série que você deseja selecionar:");

        List<String> show = workManager.getShowName();
        for (int i = 0; i < show.size(); i++) {
            System.out.println((i + 1) + " - " + show.get(i));
        }

        int showIndex = -1;
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Entrada vazia! Digite um número.");
                continue;
            }

            try {
                showIndex = Integer.parseInt(input) - 1;

                if (showIndex < 0 || showIndex >= show.size()) {
                    System.out.println("Número fora do intervalo. Tente novamente.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        return show.get(showIndex);
    }



}















