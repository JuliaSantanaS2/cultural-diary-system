package Module;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Films extends AudioVisualMedia {
    private String direction;
    private int runningtime;
    private String screenplay;

    public Films(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, String direction, int runningtime, String screenplay) {
        super(cast,seen, title, genres, yearRelease, originalTitle, whereWatch);
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


