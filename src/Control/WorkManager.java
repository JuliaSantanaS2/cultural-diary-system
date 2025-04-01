package Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Module.Media;
import Module.Genre;
import Module.Book;
import Module.Review;


public class WorkManager {

    private final List<Genre> genreLibrary;
    private final List<Review> reviewLibrary;

    private final List<Book> bookLibrary;

    //private Map<String, Media> mediaLibraryMap;

    public WorkManager() {

        this.genreLibrary = new ArrayList<>();
        this.reviewLibrary = new ArrayList<>();
        this.bookLibrary = new ArrayList<>();

        //this.reviewsLibraryMap = new HashMap<>();
        //this.mediaLibraryMap = new HashMap<>();

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

        createBook(true, "Robbit", Arrays.asList(new Genre("Ação"), new Genre("Romance")), 2023, "Robbit", "Robbit", "1234567890", true);

    }


    // About the Book
    public void createBook(boolean seen, String title,List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book book = new Book (seen, title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(book);
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
                    getReview();
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




    // Create new Film
    //public Film createFilm(String title, List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        //Book bookUser = new Book (title, genres, yearRelease, author, publisher, isbn, copy);
        //bookLibrary.add(bookUser);
        //return bookUser;
    //}

}