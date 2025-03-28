package Module;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private final List<String> genres;

    public Genre() {
        this.genres = new ArrayList<>();
    }

    public Genre(List<String> names) {
        this.genres = new ArrayList<>(names);
    }

    public List<String> getGenres() {
        return new ArrayList<>(genres);
    }


    public void addGenres(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            genres.add(genre);
        }
    }

    public void removeGenres(String genre) {
        genres.remove(genre);
    }

    public void clearGenres() {
        genres.clear();
    }
}
