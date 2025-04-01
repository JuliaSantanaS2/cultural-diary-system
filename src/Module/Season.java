package Module;

//REVER A FUNÇÃO
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.HashMap;
//import java.util.Map;
public class Season {
    private int seasonNumber;
    private int episodeCount;
    private String releaseDate;

    public Season(String title, int seasonNumber, int episodeCount, String releaseDate, String overview) {
        this.seasonNumber = seasonNumber;
        this.episodeCount = episodeCount;
        this.releaseDate = releaseDate;
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
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


}

