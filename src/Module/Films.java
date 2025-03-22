package Module;

import java.util.ArrayList;

public class Films extends AudioVisualMedia{

    private String direction;
    private int runningtime;
    private String screenplay;


    public Films (String originalTitlle, List<whereWatch> whereWatchs, int seasonEpisode, String direction, int runningtime, String screenplay) {

        super(originalTitlle,whereWatchs,seasonEpisode);
        this.runningtime = runningtime;
        this.screenplay = screenplay;
        this.direction = direction;

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