package Module;

import java.util.ArrayList;
import java.util.List;

public class Media {

    private String title;
    private int yearRelease;
    private boolean seen;
    private List<Genre> listGenres;
    private List<Review> listReviews;

    public Media(boolean seen, String title, List<Genre> genres, int yearRelease) {
        this.title = title;
        this.yearRelease = yearRelease;
        this.seen = seen;
        this.listGenres = new ArrayList<>(genres);
        this.listReviews = new ArrayList<>();


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public boolean isSeen() {
        return seen;
    }

    public void isSeen(boolean seen) {
        this.seen = seen;
    }


    // About Genres
    public List<Genre> getGenres() {
        return listGenres;
    }

    void addGenre(Genre genre) {
        if (!listGenres.contains(genre)) {  // Evita gêneros duplicados
            listGenres.add(genre);
        }
    }

    @Override
    public String toString() {
        return "Título: " + title + "\n" +
                "Ano de Lançamento: " + yearRelease + "\n" +
                "Gêneros: " + listGenres + "\n" +
                "Review" + listReviews;
    }


    public void addReview(Review review) {
        listReviews.add(review);
    }

    public List<Review> getReviews() {
        return listReviews;
    }
}