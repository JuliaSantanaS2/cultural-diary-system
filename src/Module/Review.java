package Module;

public class Review {
    private String comment ;
    private boolean status;
    private float stars;
    private String reviewDate;

    public Review(String comment, boolean status, float stars, String reviewDate){
        this.comment = comment;
        this.status = status;
        this.stars = stars;
        this.reviewDate = reviewDate;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String Comment){
        this.comment = comment;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public float getStars(){
        return stars;
    }
    public void setStars(Float stars){
        this.stars = stars;
    }

    public String reviewDate(){
        return reviewDate;
    }
     public void setReviewDate(String reviewDate){
        this.reviewDate = reviewDate;
     }

}
