package Module;

public class Review {
    public final String comment ;
    public final float stars;
    public final String reviewDate;

    public Review(String comment, float stars, String reviewDate){
        this.comment = comment;
        this.stars = stars;
        this.reviewDate = reviewDate;
    }

    public float getStars(){
        return stars;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f⭐): %s", comment, stars, reviewDate);
    }

}
