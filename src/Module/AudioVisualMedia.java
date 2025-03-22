package Module;

import java.util.ArrayList;
import java.util.List;

public class AudioVisualMedia extends Media {

    private String originalTitle;
    private List<String> whereWatch;

    public AudioVisualMedia (String title, String gender, int yearRelease, int yearConclusion, int seasonYear, int seasonEpisode){
        super(title, gender, yearRelease);
        this.originalTitle = originalTitle;
        this.whereWatch = new ArrayList<>();

    }

    public String getOriginalTitle(){
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public List<String> getWhereWatch(){
        return whereWatch;
    }
    public void setWhereWatch(List<String> whereWatch){
        this.whereWatch = whereWatch;
    }
}
