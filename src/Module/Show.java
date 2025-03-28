package Module;

import java.util.List;

public class Show extends AudioVisualMedia {
    private String yearConclusion ;
    private int yearEnd;

    public Show(String originalTitle, String gender, int yearRelease, int seasonYear, int seasonEpisode, List<String> whereWatch,String yearConclusion, int yearEnd){
        super(originalTitle, gender, yearRelease, seasonYear, seasonEpisode, originalTitle, whereWatch);
        this.yearConclusion = yearConclusion;
        this.yearEnd = yearEnd;
    }

    public String getStatus(){return yearConclusion;}
    public void setStatus(String yearConclusion){
        this.yearConclusion = yearConclusion;
    }

    public int getStars(){
        return yearEnd;
    }
    public void setStars(int yearEnd){
        this.yearEnd = yearEnd;
    }

}