package Module;

public class AudioVisualMedia extends Media {

    private int yearConclusion;
    private int seasonYear;
    private int seasonEpisode;

    public AudioVisualMedia (String title, String gender, int yearRelease, int yearConclusion, int seasonYear, int seasonEpisode){
        super(title, gender, yearRelease);
        this.yearConclusion = yearConclusion;
        this.seasonYear = seasonYear;
        this.seasonEpisode = seasonEpisode;

    }

    public int getYearConclusion() {
        return yearConclusion;
    }
    public int getSeasonYear(){
        return seasonYear;
    }
    public int getSeasonEpisode(){
        return seasonEpisode;
    }
}
