package Control;

import java.util.ArrayList;
import java.util.List;
import Module.AudioVisualMedia;
import Module.Books;
import Module.Cast;
import Module.Films;
import Module.Media;
import Module.Review;
import Module.Season;
import Module.Show;
import View.Screen;





public class WorkManager {

    private final List<Books> booksLibrary;
    private final List<Review> reviewLibrary;
    //private final List<Media> mediaLibrary;

    public WorkManager() {
        this.reviewLibrary = new ArrayList<>();
        this.booksLibrary = new ArrayList<>();
    }


    public void addBooks(String title, String gender, int yearRelease, String author, String publisher, String isbn, boolean copy) {

        Books booksUser = new Books(title, gender, yearRelease, author, publisher, isbn, copy);
        booksLibrary.add(booksUser);
        System.out.println("📚 Mídia adicionada: " + booksLibrary.getAuthor());
    }

}