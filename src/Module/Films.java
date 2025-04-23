package Module;

import java.util.List;

public class Films extends AudioVisualMedia {
    private final String direction;
    private final int runningtime;
    private final String screenplay;

    public Films(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, String direction, int runningtime, String screenplay) {
        super(cast,seen, title, genres, yearRelease, originalTitle, whereWatch);
        this.direction = direction;
        this.runningtime = runningtime;
        this.screenplay = screenplay;
    }


    public String  getDirection(){
        return direction;
    }

    public int getRunningtime(){
        return runningtime;
    }

    public String  getScreenplay(){
        return screenplay;
    }

}


