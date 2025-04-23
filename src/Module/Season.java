package Module;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private final int seasonNumber;
    private final int episodeCount;
    private final String releaseDate;
    private final List<Review> listReviews;

    public Season(int seasonNumber, int episodeCount, String releaseDate) {
        this.seasonNumber = seasonNumber;
        this.episodeCount = episodeCount;
        this.releaseDate = releaseDate;
        this.listReviews = new ArrayList<>();
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void addReview(Review review) {
        this.listReviews.add(review);
    }

    public List<Review> getReviews() {
        return listReviews;
    }

}

