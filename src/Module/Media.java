package Module;

import java.util.ArrayList;
import java.util.List;

public class Media {

    private final String title;
    private final int yearRelease;
    private final boolean seen;
    private final List<Genre> listGenres;
    private final List<Review> listReviews;

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


    public int getYearRelease() {
        return yearRelease;
    }


    public boolean isSeen() {
        return seen;
    }



    public List<Genre> getGenres() {
        return listGenres;
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