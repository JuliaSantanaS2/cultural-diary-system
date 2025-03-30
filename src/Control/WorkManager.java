package Control;

import java.util.ArrayList;
import java.util.List;

import Module.Media;
import Module.Genre;
import Module.Book;


public class WorkManager {


    //private final List<Media> mediaLibrary;
    private final List<Genre> genreLibrary;
    private final List<Book> bookLibrary;


    //private final List<Review> reviewLibrary;

    public WorkManager() {

        //this.mediaLibrary = new ArrayList<Media>();
        this.genreLibrary = new ArrayList<Genre>();
        this.bookLibrary = new ArrayList<>();


        //this.reviewLibrary = new ArrayList<>();

        initializeGenres();
        
    }

    // New Genre
    public void addGenre(String genreName){
        for (Genre g : genreLibrary) {
            if (g.getGenre().equalsIgnoreCase(genreName)) {
                System.out.println("❌ Esse gênero já existe!"); // Colocar View
                return;
            }
        }

        genreLibrary.add(new Genre(genreName));
        System.out.println("✅ Gênero cadastrado com sucesso!"); // Colocar View

    }
    public void initializeGenres() {
        addGenre("Ação");
        addGenre("Romance");
        addGenre("Ação");


    }


    public List<Genre> getGenres() {
        return genreLibrary;
    }

    // Create new Book
    public Book createBook(String title, List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book bookUser = new Book (title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(bookUser);
        return bookUser;
    }

    public List<Book> getBooks() {
        return bookLibrary;
    }
}