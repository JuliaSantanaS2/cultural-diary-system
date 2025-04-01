package Module;

public class Review {
    private String comment ;
    private float stars;
    private String reviewDate;

    public Review(String comment, float stars, String reviewDate){
        this.comment = comment;
        this.stars = stars;
        this.reviewDate = reviewDate;
    }

    public String getComment(){return comment;}
    public void setComment(String Comment){
        this.comment = comment;
    }

    public float getStars(){
        return stars;
    }
    public void setStars(Float stars){this.stars = stars;}

    public String reviewDate(){
        return reviewDate;
    }
    public void setReviewDate(String reviewDate){
        this.reviewDate = reviewDate;
     }

    @Override
    public String toString() {
        return reviewer + " (" + rating + "⭐): " + comment;
    }

}
