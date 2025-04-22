package Control;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Module.Media;
import Module.Films;
import Module.Season;
import Module.Show;
import Module.Genre;
import Module.Book;
import Module.Review;


public class WorkManager {

    private final List<Genre> genreLibrary;
    private final List<Review> reviewLibrary;
    private final List<Book> bookLibrary;
    private final List<Films> filmLibrary;
    private final List<Show> showLibrary;
    private final List<Media> media;


    public WorkManager() {

        this.genreLibrary = new ArrayList<>();
        this.reviewLibrary = new ArrayList<>();
        this.bookLibrary = new ArrayList<>();
        this.filmLibrary = new ArrayList<>();
        this.showLibrary = new ArrayList<>();
        this.media = new ArrayList<>();

        initializeGenres();

    }

    // NEW GENRE
    public void addGenre(String genreName){
        genreLibrary.add(new Genre(genreName));
        Collections.sort(genreLibrary);
    }

    public List<Genre> getGenres() {
        return genreLibrary;
    }


    // ACHO QUE POSSO EXCLUIR
    public void getGenresTest() {

        for (Genre genre : genreLibrary) {
            System.out.println("- " + genre.getGenre());
        }
    }

    // EXCLUIR QUANDO VOU ENTREGAR OU DEIXAR SÓ PARA FACILITAR OS TRABALHO
    public void initializeGenres() {
        addGenre("Ação");
        addGenre("Romance");
        addGenre("Cassino");
        addGenre("Aventura");
        addGenre("Filosofia");

        createBook(true, "Robbit", Arrays.asList(new Genre("Ação"), new Genre("Romance")), 2023, "Robbit", "Robbit", "1234567890", true);
        createBook(false, "O Alquimista", Arrays.asList(new Genre("Ficção"), new Genre("Filosofia")), 1988, "Paulo Coelho", "HarperCollins", "9780061122415", false);
        createBook(true, "Harry Potter e a Pedra Filosofal", Arrays.asList(new Genre("Filosofia"), new Genre("Aventura")), 1988, "J.K. Rowling", "Bloomsbury", "9780747532699", true);
        createBook(false, "1984", Arrays.asList(new Genre("Ficção Científica"), new Genre("Filosofia")), 1988, "George Orwell", "Secker & Warburg", "9780451524935", false);
        createBook(true, "O Senhor dos Anéis", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 1988, "J.R.R. Tolkien", "Allen & Unwin", "9780618640157", true);
        createBook(true, "Dom Quixote", Arrays.asList(new Genre("Clássico"), new Genre("Comédia")), 1988, "Miguel de Cervantes", "Francisco de Robles", "9788424114078", false);
        createBook(false, "Crime e Castigo", Arrays.asList(new Genre("Drama"), new Genre("Psicológico")), 1866, "Fiodor Dostoiévski", "The Russian Messenger", "9780143107637", true);
        createBook(true, "O Pequeno Príncipe", Arrays.asList(new Genre("Infantil"), new Genre("Filosofia")), 1943, "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "9782070612758", false);
        createBook(false, "Cem Anos de Solidão", Arrays.asList(new Genre("Realismo Mágico"), new Genre("Ficção")), 1967, "Gabriel García Márquez", "Sudamericana", "9780241968581", true);
        createBook(true, "Orgulho e Preconceito", Arrays.asList(new Genre("Romance"), new Genre("Drama")), 1813, "Jane Austen", "T. Egerton", "9780141439518", false);
        createBook(false, "O Hobbit", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 1937, "J.R.R. Tolkien", "George Allen & Unwin", "9780345339683", true);
        createBook(true, "Moby Dick", Arrays.asList(new Genre("Aventura"), new Genre("Clássico")), 1851, "Herman Melville", "Harper & Brothers", "9781503280786", false);
        createBook(false, "Drácula", Arrays.asList(new Genre("Terror"), new Genre("Gótico")), 1897, "Bram Stoker", "Archibald Constable and Company", "9780486411095", true);
        createBook(true, "O Nome do Vento", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 2007, "Patrick Rothfuss", "DAW Books", "9780756404741", true);
        createBook(false, "As Crônicas de Nárnia", Arrays.asList(new Genre("Fantasia"), new Genre("Infantil")), 1950, "C.S. Lewis", "Geoffrey Bles", "9780066238503", false);
        createBook(true, "O Código Da Vinci", Arrays.asList(new Genre("Mistério"), new Genre("Thriller")), 2003, "Dan Brown", "Doubleday", "9780385504201", true);
        createBook(false, "Os Miseráveis", Arrays.asList(new Genre("Drama"), new Genre("Histórico")), 1862, "Victor Hugo", "A. Lacroix, Verboeckhoven & Cie.", "9780451419439", false);
        createBook(true, "A Revolução dos Bichos", Arrays.asList(new Genre("Satírico"), new Genre("Distopia")), 1945, "George Orwell", "Secker & Warburg", "9780451526342", true);
        createBook(false, "Sherlock Holmes: Um Estudo em Vermelho", Arrays.asList(new Genre("Mistério"), new Genre("Detetive")), 1887, "Arthur Conan Doyle", "Ward, Lock & Co.", "9781514646060", false);
        createBook(true, "Percy Jackson e o Ladrão de Raios", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 2005, "Rick Riordan", "Disney-Hyperion", "9780786838653", true);

        createShow(
                Arrays.asList("Bruce Willis", "Samuel L. Jackson", "Jeremy Irons"),
                true,
                "TESTE TEMPORADA",
                Arrays.asList(new Genre("Ação"), new Genre("Thriller")),
                1995,
                "Duro de Matar: Vingança",
                Arrays.asList("Netflix", "Amazon Prime"),
                128
        );

        createFilm(
                Arrays.asList("Bruce Willis", "Samuel L. Jackson", "Jeremy Irons"),
                true,
                "Die Hard with a Vengeance",
                Arrays.asList(new Genre("Ação"), new Genre("Thriller")),
                1995,
                "Duro de Matar: Vingança",
                Arrays.asList("Netflix", "Amazon Prime"),
                "John McTiernan",
                128,
                "Jonathan Hensleigh"
        );

        createFilm(
                Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"),
                false,
                "The Matrix",
                Arrays.asList(new Genre("Ficção Científica"), new Genre("Ação")),
                1999,
                "Matrix",
                Arrays.asList("HBO Max", "Netflix"),
                "The Wachowskis",
                136,
                "Lilly Wachowski, Lana Wachowski"
        );

        createFilm(
                Arrays.asList("Tom Hanks", "Tim Allen", "Don Rickles"),
                true,
                "Toy Story",
                Arrays.asList(new Genre("Animação"), new Genre("Família")),
                1995,
                "Toy Story",
                Arrays.asList("Disney+", "Amazon Prime"),
                "John Lasseter",
                81,
                "Joss Whedon, Andrew Stanton"
        );

        int result2 = createReviewFilm(
                "Toy Story",
                "Excelente filme de ação com muita adrenalina!",
                5,
                "2025/04/17"
        );

        int result3 =  createReviewFilm(
                "The Matrix",
                "Um clássico da ficção científica, com cenas de ação memoráveis.",
                5,
                "2025/04/17");

        int result1 = createReviewBook(
                "Robbit",
                "Uma obra-prima do cinema, com uma direção incrível e uma história profunda.",
                5,
                "2025/04/17"
        );

        int result20 = createReviewBook(
                "Harry Potter e a Pedra Filosofal",
                "Filme cheio de reviravoltas, com um enredo desafiador e visual impressionante.",
                4,
                "2025/04/17"
        );


        createShow(Arrays.asList("Bruce Willis", "Samuel L. Jackson", "Jeremy Irons"), true, "Breakin Bad", Arrays.asList(new Genre("Ação"), new Genre("Aventura")),
                1995,
                "Duro de Matar: Vingança",
                Arrays.asList("Netflix", "Amazon Prime"),
                128
        );

        createSeason("Breakin Bad", 1, 10, "2025/04/17");
        createSeason("Breakin Bad", 2, 10, "2025/04/17");

        createReviewShow(
                "Breakin Bad",
                1,
                "Uma obra-prima do cinema, com uma direção incrível e uma história profunda.",
                5,
                "2025/04/17"
        );

        createReviewShow(
                "Breakin Bad",
                2,
                "Uma obra-prima do cinema, com uma direção incrível e uma história profunda.",
                1,
                "2025/04/17"
        );

        createReviewShow(
                "Breakin Bad",
                2,
                "Uma obra-prima do cinema, com uma direção incrível e uma história profunda.",
                3,
                "2025/04/17"
        );

    }


    // METHODS RELATED TO BOOKS =====================================================================================

    // CREATE NEW BOOK
    public void createBook(boolean seen, String title,List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book book = new Book (seen, title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(book);
        media.add(book);
    }

    // CREATE REVIEW BOOK
    public int createReviewBook(String title, String comment, int stars, String reviewDate) {
        for (Book book : bookLibrary) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isSeen()) {
                    Review newReview = new Review(comment, stars, reviewDate);

                    book.addReview(newReview);
                    reviewLibrary.add(newReview);

                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    // AUXILIARY METHOD OF "createReviewBook": SELECT THE CORRESPONDING FILM IN CLASS CREATE REVIEW
    public List<String> getBooksName() {
        List<String> bookTitles = new ArrayList<>();  // Lista para armazenar os títulos
        for (Book b : bookLibrary) {
            bookTitles.add(b.getTitle());  // Adiciona o título à lista
        }
        return bookTitles;  // Retorna a lista com os títulos
    }


    // METHODS RELATED TO FILMS =============================================================================================================================

    // CREATE NEW FILM
    public void createFilm(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, String direction, int runningtime, String screenplay){
        Films film = new Films (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, direction, runningtime, screenplay);
        filmLibrary.add(film);
        media.add(film);
    }

    // CREATE REVIEW FILM
    public int createReviewFilm(String title, String comment, int stars, String reviewDate) {
        for (Films film : filmLibrary) {
           if (film.getTitle() != null && film.getTitle().equalsIgnoreCase(title)) {
                if (film.isSeen()) {
                    Review newReview = new Review(comment, stars, reviewDate);

                    film.addReview(newReview);
                    reviewLibrary.add(newReview);

                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    // AUXILIARY METHOD OF "createReviewFilm": SELECT THE CORRESPONDING FILM IN CLASS CREATE REVIEW
    public List<String> getFilmName() {
        List<String> filmTitles = new ArrayList<>();
        for (Films f : filmLibrary) {
            filmTitles.add(f.getTitle());
        }
        return filmTitles;
    }

    // METHODS RELATED TO SHOW/SEASON =============================================================================================================================

    // CREATE NEW SHOW
    public void createShow(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, int yearEnd){
        Show show = new Show (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, yearEnd);
        showLibrary.add(show);
        media.add(show);
    }



    // CREATE NEW SEASON
    public int createSeason(String title, int seasonNumber, int episodeCount, String releaseDate) {
        for (Show show : showLibrary) {
            if (show.getTitle() != null && show.getTitle().equalsIgnoreCase(title)) {
                if (show.isSeen()) {
                    Season newSeason = new Season(seasonNumber, episodeCount, releaseDate);
                    show.addSeason(newSeason);
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    // AUXILIARY METHOD OF "createSeason": SELECT THE CORRESPONDING SHOW IN CLASS CREATE
    public List<String> getShowName() {
        List<String> showTitles = new ArrayList<>();
        for (Show s : showLibrary) {
            showTitles.add(s.getTitle());
        }
        return showTitles;
    }

    // CREATE REVIEW SEASON
    public int createReviewShow(String showTitle, int seasonNumber, String comment, int stars, String reviewDate) {
        for (Show show : showLibrary) {
            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                for (Season season : show.getSeasons()) {
                    if (season.getSeasonNumber() == seasonNumber) {

                        Review newReview = new Review(comment, stars, reviewDate);
                        season.addReview(newReview);
                        reviewLibrary.add(newReview);
                        return 0; // Review criada com sucesso

                    }
                }
                return 3; // Temporada não encontrada
            }
        }
        return 1; // Série não encontrada
    }

    // AUXILIARY METHOD OF "getSeasonsByShowName": SELECT THE CORRESPONDING SEASON IN CLASS CREATE REVIEW
    public List<Integer> getSeasonsByShowName(String showTitle) {
        for (Show show : showLibrary) {
            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                List<Integer> seasonNumbers = new ArrayList<>();
                for (Season season : show.getSeasons()) {
                    seasonNumbers.add(season.getSeasonNumber());
                }
                return seasonNumbers; // Retorna os números das temporadas
            }
        }
        return Collections.emptyList(); // Retorna uma lista vazia se a série não for encontrada
    }

    // TALVEZ N PRECISE E PODE EXVLUIR, NO CASO EU ACHO QUE TAVA SÓ UDANDO PARA VER SE SALVOU
    public void getShow() {
        for (Show show : showLibrary) {
            System.out.println(show.toString());
            for (Season season : show.getSeasons()) {
                System.out.println("  Temporada " + season.getSeasonNumber() + ":");
                for (Review review : season.getReviews()) {
                    System.out.println("    - " + review.toString());
                }
            }
        }
    }



    // METHODS RELATED TO SEARCH =============================================================================================================================

    // SEARCH MEDIA BY TITLE
    public List<Media> searchByTitle(String title) {
        return media.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // SEARCH MEDIA BY YEAR
    public List<Media> searchByYear(int year) {
        return media.stream()
                .filter(m -> m.getYearRelease() == year)
                .collect(Collectors.toList());
    }


    // SEARCH MEDIA BY GENRE
    public List<Media> searchByGenre(String genreName) {
        if (genreName == null || genreName.trim().isEmpty()) {
            return Collections.emptyList();
        } String searchNameLower = genreName.trim().toLowerCase();

        return this.media.stream()
                .filter(m -> {
                    List<Genre> genresDaMedia = m.getGenres();
                    if (genresDaMedia == null || genresDaMedia.isEmpty()) {
                        return false;
                    }
                    return genresDaMedia.stream()
                            .filter(Objects::nonNull)
                            .anyMatch(g -> g.getGenre() != null && g.getGenre().toLowerCase().contains(searchNameLower));
                })
                .collect(Collectors.toList());
    }

    // SEARCH BOOK BY AUTHOR
    public List<Book> searchBooksByAuthor(String author) {
        return bookLibrary.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    // SEARCH BOOK BY ISBN
    public List<Book> searchBooksByISBN(String isbn) {
        return bookLibrary.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .collect(Collectors.toList());
    }

    // SEARCH FILM BY DIRECTOR
    public List<Films> searchFilmsByDirector(String director) {
        return filmLibrary.stream()
                .filter(f -> f.getDirection().toLowerCase().contains(director.toLowerCase()))
                .collect(Collectors.toList());
    }

    // SEARCH MEDIA BY CAST
    public List<Films> searchFilmsByCast(String actor) {
        return filmLibrary.stream()
                .filter(f -> f.getCast().stream().anyMatch(a -> a.toLowerCase().contains(actor.toLowerCase())))
                .collect(Collectors.toList());
    }


    // SEARCH MEDIA BY CAST
    public List<Show> searchShowsByCast(String actor) {
        return showLibrary.stream()
                .filter(s -> s.getCast().stream().anyMatch(a -> a.toLowerCase().contains(actor.toLowerCase())))
                .collect(Collectors.toList());
    }

    // COLOCAR PARA MOSTRAR TUDO
    public List<Media> listMediaAlphabetically() {
        return media.stream()
                .sorted(Comparator.comparing(Media::getTitle))
                .collect(Collectors.toList());
    }

    // REVIEW SCORES
    public static float calculateAverage(Media m) {
        if (m == null) {
            return 0f;
        }

        if (m instanceof Book || m instanceof Films) {
            List<Review> reviews = m.getReviews();
            if (reviews == null || reviews.isEmpty()) {
                return 0f;
            }
            Review lastReview = reviews.get(reviews.size() - 1);
            return (lastReview != null) ? lastReview.getStars() : 0f;
        }

        else if (m instanceof Show) {
            Show show = (Show) m;
            List<Season> seasons = show.getSeasons();
            if (seasons == null || seasons.isEmpty()) {
                return 0f;
            }

            float totalStarsSum = 0;
            int totalReviewCount = 0;

            for (Season season : seasons) {
                if (season != null) {
                    List<Review> seasonReviews = season.getReviews();
                    if (seasonReviews != null && !seasonReviews.isEmpty()) {
                        for (Review review : seasonReviews) {
                            if (review != null) {
                                totalStarsSum += review.getStars();
                                totalReviewCount++;
                            }
                        }
                    }
                }
            }

            if (totalReviewCount == 0) {
                return 0f;
            }
            return totalStarsSum / totalReviewCount;
        }

        else {
            return 0f;
        }
    }

    // MEDIA LIST LISTING
    public List<Media> getFilteredAndSortedMedia(Integer filterYear, Genre filterGenre, int sortOption) {
        // 1. Começa com TODAS as mídias
        List<Media> filteredList = this.media.stream()
                // 2. PRIMEIRO FILTRO (ANO):
                //    Só deixa passar mídias que ou não têm filtro de ano (filterYear==null)
                //    OU cujo ano bate com filterYear.
                .filter(media -> filterYear == null || media.getYearRelease() == filterYear)

                // 3. SEGUNDO FILTRO (GÊNERO):
                //    Opera APENAS sobre as mídias que JÁ PASSARAM pelo filtro de ANO.
                //    Só deixa passar mídias (que já passaram pelo filtro de ano) que
                //    ou não têm filtro de gênero (filterGenre==null)
                //    OU cuja lista de gêneros contém o filterGenre.
                .filter(media -> filterGenre == null || media.getGenres().contains(filterGenre))

                // 4. Coleta o resultado: APENAS as mídias que passaram por AMBOS os filtros.
                .collect(Collectors.toList());

        // 5. Ordena a lista filtrada com base no sortOption
        switch (sortOption) {
            case 1: // Avaliação: Maior para Menor
                filteredList.sort((m1, m2) -> {
                    float avg1 = WorkManager.calculateAverage(m1); // Usa o método estático
                    float avg2 = WorkManager.calculateAverage(m2);
                    return Float.compare(avg2, avg1); // Ordem decrescente
                });
                break;
            case 2: // Avaliação: Menor para Maior
                filteredList.sort((m1, m2) -> {
                    float avg1 = WorkManager.calculateAverage(m1);
                    float avg2 = WorkManager.calculateAverage(m2);
                    return Float.compare(avg1, avg2); // Ordem crescente
                });
                break;
            case 3: // Alfabético (A-Z)
            default: // Qualquer outro valor também ordena alfabeticamente
                filteredList.sort(Comparator.comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER));
                break;
        }

        // 6. Retorna a lista filtrada e ordenada
        return filteredList;
    }





} // AQUI É DA CLASS