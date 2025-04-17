package Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

import Module.Media;
import Module.Films;
import Module.Season;
import Module.Show;
import Module.Genre;
import Module.Book;
import Module.Review;
import java.util.Collections;



public class WorkManager {

    private final List<Genre> genreLibrary;
    private final List<Review> reviewLibrary;

    private final List<Book> bookLibrary;
    private final List<Films> filmLibrary;
    private final List<Show> showLibrary;
    private final List<Media> media;

    //private Map<String, Media> mediaLibraryMap;

    public WorkManager() {

        this.genreLibrary = new ArrayList<>();
        this.reviewLibrary = new ArrayList<>();
        this.bookLibrary = new ArrayList<>();
        this.filmLibrary = new ArrayList<>();
        this.showLibrary = new ArrayList<>();
        this.media = new ArrayList<>();

        //this.reviewsLibraryMap = new HashMap<>();
        //this.mediaLibraryMap = new HashMap<>();

        initializeGenres();

    }

    // New Genre
    public void addGenre(String genreName){

        genreLibrary.add(new Genre(genreName));
        Collections.sort(genreLibrary);


    }

    public List<Genre> getGenres() {
        return genreLibrary;
    }

    public void getGenresTest() {

        for (Genre genre : genreLibrary) {
            System.out.println("- " + genre.getGenre());
        }
    }

    public void initializeGenres() {
        addGenre("Ação");
        addGenre("Romance");
        addGenre("Cassino");
        addGenre("Aventura");

        createBook(true, "Robbit", Arrays.asList(new Genre("Ação"), new Genre("Romance")), 2023, "Robbit", "Robbit", "1234567890", true);
        createBook(false, "O Alquimista", Arrays.asList(new Genre("Ficção"), new Genre("Filosofia")), 1988, "Paulo Coelho", "HarperCollins", "9780061122415", false);
        createBook(true, "Harry Potter e a Pedra Filosofal", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 1997, "J.K. Rowling", "Bloomsbury", "9780747532699", true);
        createBook(false, "1984", Arrays.asList(new Genre("Ficção Científica"), new Genre("Distopia")), 1949, "George Orwell", "Secker & Warburg", "9780451524935", false);
        createBook(true, "O Senhor dos Anéis", Arrays.asList(new Genre("Fantasia"), new Genre("Aventura")), 1954, "J.R.R. Tolkien", "Allen & Unwin", "9780618640157", true);
        createBook(true, "Dom Quixote", Arrays.asList(new Genre("Clássico"), new Genre("Comédia")), 1605, "Miguel de Cervantes", "Francisco de Robles", "9788424114078", false);
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


    }


    // About the Book
    public void createBook(boolean seen, String title,List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book book = new Book (seen, title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(book);
        media.add(book);
    }


    public void getBooks() {
        for (Book b : bookLibrary) {
            System.out.println(b.toString());
        }
    }

    public List<String> getBooksName() {
        List<String> bookTitles = new ArrayList<>();  // Lista para armazenar os títulos
        for (Book b : bookLibrary) {
            bookTitles.add(b.getTitle());  // Adiciona o título à lista
        }
        return bookTitles;  // Retorna a lista com os títulos
    }



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

    public void getReview() {
        for (Review b : reviewLibrary) {
            System.out.println(b.toString());
        }
    }

    // Não usando
    public void printLibraryTable() {

        System.out.printf("%-20s | %-20s | %-4s%n", "Title", "Author", "Year");
        System.out.println("--------------------------------------------------------");

        for (Book book : bookLibrary) {
            String title = book.getTitle();
            String author = book.getAuthor();

            // Se for maior que 17 caracteres, corta e adiciona "..."
            if (title.length() > 17) {
                title = title.substring(0, 17) + "...";
            }

            if (author.length() > 17) {
                author = author.substring(0, 17) + "...";
            }

            System.out.printf("%-20s | %-15s | %-4d%n", title, author, book.getYearRelease());
        }
    }

    public void printAllMedia() {

        // Cria uma lista combinada de livros e filmes e Serie (Falta colocar)
        //List<Media> media = new ArrayList<>();
        //media.addAll(bookLibrary);
        //media.addAll(filmLibrary);

        //media.sort(Comparator.comparing(Media::getTitle));

        System.out.printf("%-20s | %-20s | %-5s | %-5s%n", "Title", "Author/Director", "Year", "Stars");
        System.out.println("---------------------------------------------------------------");


        for (Media item : media) {
            String title = item.getTitle();
            if (title.length() > 17) title = title.substring(0, 17) + "...";

            String creator = "";
            float stars = 0;

            if (item instanceof Book) {
                Book book = (Book) item;
                creator = book.getAuthor();
                if (creator.length() > 17) creator = creator.substring(0, 17) + "...";

                if (!item.getReviews().isEmpty()) {
                    stars = item.getReviews().get(item.getReviews().size() - 1).getStars();
                }

                // Verifica se o item é um Film
            } else if (item instanceof Films) {
                Films film = (Films) item;
                creator = film.getDirection();
                if (creator.length() > 17) creator = creator.substring(0, 17) + "...";

                //Muda depois para pegar a ultima stars
                if (!item.getReviews().isEmpty()) {
                    stars = calculateAverageStars(item.getReviews());
                }
            }
            // Imprime os dados formatados
            System.out.printf("%-20s | %-20s | %-4d | %-5.1f%n", title, creator, item.getYearRelease(), stars);
        }
    }

    // ISSO È PARA SERIE
    private float calculateAverageStars(List<Review> reviews) {
        float sum = 0;
        for (Review review : reviews) {
            sum += review.getStars();
        }
        return sum / reviews.size(); // Retorna a média
    }


    // ABOUT FILM

    // Create new Film
    public void createFilm(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, String direction, int runningtime, String screenplay){
        Films film = new Films (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, direction, runningtime, screenplay);
        filmLibrary.add(film);
        media.add(film);
    }

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



    public List<String> getFilmName() {
        List<String> filmTitles = new ArrayList<>();
        for (Films f : filmLibrary) {
            filmTitles.add(f.getTitle());
        }
        return filmTitles;
    }

    // Create new Show
    public void createShow(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, int yearEnd){
        Show show = new Show (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, yearEnd);
        showLibrary.add(show);
        media.add(show);
    }

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

    public List<String> getShowName() {
        List<String> showTitles = new ArrayList<>();  // Lista para armazenar os títulos
        for (Show s : showLibrary) {
            showTitles.add(s.getTitle());  // Adiciona o título à lista
        }
        return showTitles;  // Retorna a lista com os títulos
    }

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



}