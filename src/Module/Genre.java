package Module;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesma referência de memória
        if (o == null || getClass() != o.getClass()) return false; // Null ou classe diferente
        Genre otherGenre = (Genre) o; // Cast seguro após verificação de classe
        // Compara o conteúdo (String genre), ignorando case
        return this.genre.equalsIgnoreCase(otherGenre.genre);
    }

    @Override
    public int hashCode() {
        // Usa a mesma lógica de equals (ignorar case) para gerar o hash
        return Objects.hash(this.genre.toLowerCase());
    }
}
