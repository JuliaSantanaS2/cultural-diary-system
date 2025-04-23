package Module;

import java.util.List;

public class Book extends Media {
    private final String author;
    private final String publisher;
    private final String isbn;
    private final boolean copy;

    public Book(boolean seen, String title, List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy) {
        super(seen, title, genres, yearRelease);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.copy = copy;
    }

    public String getAuthor (){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getIsbn(){
        return isbn;
    }

    public boolean getCopy(){
        return copy;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Autor: " + author + "\n" +
                "Editora: " + publisher + "\n" +
                "ISBN: " + isbn + "\n" +
                "Cópia: " + (copy ? "Sim" : "Não");

    }
}