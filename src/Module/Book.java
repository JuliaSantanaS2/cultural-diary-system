package Module;

import java.util.List;

public class Book extends Media {
    private String author;
    private String publisher;
    private String isbn;
    private boolean copy;

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
    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublisher(){
        return publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public boolean getCopy(){
        return copy;
    }
    public void setCopy(boolean copy){
        this.copy = copy;
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