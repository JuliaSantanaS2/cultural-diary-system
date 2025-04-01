package Module;

import java.util.ArrayList;
import java.util.List;

public class Media {

    private String title;
    private int yearRelease;
    private List<Genre> listGenres ;

    public Media(String title,List<Genre> genres, int yearRelease) {
        this.title = title;
        this.yearRelease = yearRelease;
        this.listGenres = new ArrayList<>(genres);

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
                "Gêneros: " + listGenres;
    }



}
/*


    //public void removeGenre(Genre gender) {genres.remove(gender);}
    //public void clearGenre() {genres.clear();}

    // About Rewiew

    public List<Review> getReviews() {return new ArrayList<>(listReviews);}

    public void addReview(Review review) {
        if (listReviews != null) {
            listReviews.add(review);
        }
    }

}

*/