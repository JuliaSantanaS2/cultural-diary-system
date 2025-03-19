package Module;

import java.util.ArrayList;
import java.util.List;

public class Media {
    protected String title;
    protected String gender;
    protected int yearRelease;
    private List<Review> reviews;

    public Media(String title, String gender, int yearRelease){
        this.title = title;
        this.gender = gender;
        this.yearRelease = yearRelease;
        this.review = new ArrayList<>();

    }

    public void addReview(int stars, String comment, boolean status) {
        reviews.add(new Review(stars, comment, status));

    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getTitle(){
        return title;
    }

    public String getGender(){
        return gender;
    }

    public int getYearRelease(){
        return yearRelease;
    }


}
