package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Module.Media;
import Module.Genre;
import Module.Book;
import Module.Review;


public class WorkManager {

    private final List<Genre> genreLibrary;
    private final List<Book> bookLibrary;
    private Map<String, List<Review>> reviewsLibraryMap;
    private Map<String, Media> mediaLibraryMap;

    public WorkManager() {

        this.genreLibrary = new ArrayList<>();
        this.bookLibrary = new ArrayList<>();
        this.reviewsLibraryMap = new HashMap<>();
        this.mediaLibraryMap = new HashMap<>();

        initializeGenres();
        
    }

    // New Genre
    public void addGenre(String genreName){

        genreLibrary.add(new Genre(genreName));
        System.out.println("✅ Gênero cadastrado com sucesso!"); // Colocar View

    }

    public List<Genre> getGenres() {
        return genreLibrary;
    }

    public void initializeGenres() {
        addGenre("Ação");
        addGenre("Romance");
        addGenre("Cassino");
        addGenre("Aventura");

    }


    // Create new Book
    public void createBook(String title,List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book book = new Book (title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(book);
    }

// Quero printar a lista de livros
    public void printBooks() {
        for (Book b : bookLibrary) {
            System.out.println(b.toString());
        }
    }
    public void getBooks() {
        for (Book b : bookLibrary) {
            System.out.println(b.toString());
        }
    }

    public void createReviewBook(String title, String comment, int stars, String reviewDate) {
        if (mediaLibraryMap.containsKey(title)) {
            Media media = mediaLibraryMap.get(title);

            // Verifica se o usuário já viu a obra, aqui você pode colocar a lógica do seu sistema
            boolean seen = hasUserSeenMedia(title);  // Suponha que tenha esse método de verificação
            if (seen) {
                Review newReview = new Review(comment, stars, reviewDate);  // Cria uma nova review
                List<Review> reviews = reviewsLibraryMap.get(title);  // Obtém a lista de reviews do livro
                reviews.add(newReview);  // Adiciona a review à lista de reviews do livro
                System.out.println("✅ Review adicionada com sucesso ao livro: " + title);
            } else {
                System.out.println("Você precisa ter visto o livro antes de deixar uma review.");
            }
        } else {
            System.out.println("Livro não encontrado: " + title);
        }
    }



    // Create new Film
    //public Film createFilm(String title, List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        //Book bookUser = new Book (title, genres, yearRelease, author, publisher, isbn, copy);
        //bookLibrary.add(bookUser);
        //return bookUser;
    //}

}