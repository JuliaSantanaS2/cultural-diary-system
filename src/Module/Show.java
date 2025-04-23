package Module;

import java.util.ArrayList;
import java.util.List;

public class Show extends AudioVisualMedia {

    private List<Season> seasons = new ArrayList<>();
    private final int yearEnd;

    public Show(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, int yearEnd){
        super(cast,seen,title,genres,yearRelease,originalTitle,whereWatch);
        this.yearEnd = yearEnd;
        this.seasons = new ArrayList<>();
    }

    public int getYearEnd(){return yearEnd;}

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public List<Season> getSeasons() {
        return seasons;
    }

}


