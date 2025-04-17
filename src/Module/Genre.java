package Module;

public class Genre implements Comparable<Genre> {
    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return genre;
    }

    @Override
    public int compareTo(Genre other) {
        return this.genre.compareToIgnoreCase(other.genre);
    }
}
