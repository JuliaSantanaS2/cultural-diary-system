package Module;

import java.util.ArrayList;
import java.util.List;

public class AudioVisualMedia extends Media {

    private final String originalTitle;
    private final List<String> whereWatch;
    private final List<String> cast;

    public AudioVisualMedia(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch) {
        super( seen, title, genres, yearRelease);
        this.originalTitle = originalTitle;
        this.whereWatch = whereWatch;

        if (cast != null) {
            this.cast = new ArrayList<>(cast);
        } else {
            this.cast = new ArrayList<>();
        }

    }

    public String getOriginalTitle() {
        return originalTitle;
    }


    public List<String> getWhereWatch() {
        return whereWatch;
    }


    public List<String> getCast() {return cast;}
}

