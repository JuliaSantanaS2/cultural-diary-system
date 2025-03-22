package Module;

import java.util.ArrayList;
import java.util.List;

public class Cast {
    private List<String> name;

    public Cast(List<String> name){
        this.name = name;
    }

    public List<String> getName(){
        return name;
    }
    public void setName(List<String> name){
        this.name = name;
    }

}