package Module;

import java.util.ArrayList;
import java.util.List;

public class Films extends AudioVisualMedia {
    private String direction;
    private int runningtime;
    private String screenplay;

    public Films(String originalTitle, String gender, int yearRelease, int yearConclusion, int seasonYear, int seasonEpisode, List<String> whereWatch, String direction, int runningtime, String screenplay) {
        super(originalTitle, gender, yearRelease, yearConclusion, seasonYear, seasonEpisode, originalTitle, whereWatch);
        this.direction = direction;
        this.runningtime = runningtime;
        this.screenplay = screenplay;
    }


    public String  getDirection(){
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    public int getRunningtime(){
        return runningtime;
    }
    public void setRunningtime(int runningtime){
        this.runningtime = runningtime;
    }

    public String  getScreenplay(){
        return screenplay;
    }
    public void setScreenplay(String screenplay){
        this.screenplay = screenplay;
    }

}