package Module;

import java.util.ArrayList;
import java.util.List;

public class Media {
    private String title;
    private int yearRelease;

    public Media(String title, String gender, int yearRelease){
        this.title = title;
        this.gender = gender;
        this.yearRelease = yearRelease;
        this.review = new ArrayList<>(); // Ver se é isso mesmo ;)

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getYearRelease(){
        return yearRelease;
    }
    public void setYearRelease(int yearRelease){
        this.yearRelease = yearRelease;
    }


}
