package Module;

import java.util.ArrayList;
import java.util.List;

public class Gender {
    private final List<String> genres;

    public Gender() {
        this.genres = new ArrayList<>();
    }

    public Gender(List<String> names) {
        this.genres = new ArrayList<>(names);
    }

    public List<String> getNames() {
        return new ArrayList<>(genres);
    }

    public void addName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            genres.add(name);
        }
    }

    public void removeName(String name) {
        genres.remove(name);
    }

    public void clearNames() {
        genres.clear();
    }
}
