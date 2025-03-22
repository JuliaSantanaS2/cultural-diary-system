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
//import Module.Show;
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
        System.out.println("📚 Livro (Titulo)): " + booksUser.getTitle());
        System.out.println("📚 Livro (Ator)): " + booksUser.getAuthor());
        System.out.println("📚 Livro (Ator)): " + booksUser.getPublisher());
        System.out.println("📚 Livro (ISBN)): " + booksUser.getIsbn());
        System.out.println("📚 Livro (Exemplar)): " + booksUser.getCopy());
    }


    public static void main(String[] args) {
        WorkManager manager = new WorkManager();
        manager.addBooks("Dom Quixote", "Romance", 1605, "Miguel de Cervantes", "Editora Clássica", "123456789", true);
        manager.addBooks("Fernanda Biografia", "Romance", 1605, "Fernanda", "Editora Clássica", "123456789", false);
    }

}