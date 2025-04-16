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

    public void printLibraryTable() {
        // Definir cabeçalho da tabela
        System.out.printf("%-60s | %-60s | %-10s%n", "Title", "Author", "Year");
        System.out.println("--------------------------------------------");

        // Iterar sobre os livros e imprimir formatado
        for (Book book : bookLibrary) {
            System.out.printf("%-20s | %-15s | %-4d%n", book.getTitle(), book.getAuthor(), book.getYearRelease());
        }
    }

    // Create new Film
    //public Film createFilm(String title, List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        //Book bookUser = new Book (title, genres, yearRelease, author, publisher, isbn, copy);
        //bookLibrary.add(bookUser);
        //return bookUser;
    //}

}