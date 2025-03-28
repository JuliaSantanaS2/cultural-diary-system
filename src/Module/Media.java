package Module;

import java.util.ArrayList;
import java.util.List;


public class Media {

    private String title;
    private int yearRelease;
    private List<Genre> listGenres ;
    private List<Review> listReviews;

    public Media(String title, int yearRelease){
        this.title = title;
        this.yearRelease = yearRelease;
        this.genres = new ArrayList<>();
        this.reviews = new ArrayList<>();

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getYearRelease(){
        return yearRelease;
    }
    public void setYearRelease(int yearRelease){
        this.yearRelease = yearRelease;
    }

    // About Genres
    public List<Genre> getGenres () {return new ArrayList<>(genres);}

    public void addGender(Genre gender) {
        if (gender != null) {
            genres.add(gender);
        }
    }

    public void removeGenre(Genre gender) {genres.remove(gender);}
    public void clearGenre() {genres.clear();}

    // About Rewiew

    public List<Review> getReviews() {return new ArrayList<>(reviews);}

    public void addGender(Genre gender) {
        if (gender != null) {
            genres.add(gender);
        }
    }

    public void removeGenre(Genre gender) {genres.remove(gender);}
    public void clearGenre() {genres.clear();}



}