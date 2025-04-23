package Module;

/**
 * Representa uma avaliação (review) feita por um usuário para uma mídia ou temporada.
 * Contém o comentário textual, a nota (estrelas) e a data da avaliação.
 * Esta classe é imutável após a criação, garantindo que uma review não possa ser
 * alterada depois de registrada.
 */
public class Review {
    public final String comment ;
    public final float stars;
    public final String reviewDate;

    /**
     * Construtor para criar uma instância de Review.
     * Valida os parâmetros de entrada para garantir a integridade dos dados.
     *
     * @param comment    O texto da avaliação. Não pode ser nulo ou consistir apenas de espaços.
     * @param stars      A nota atribuída (deve estar estritamente dentro do intervalo [1.0, 5.0]).
     * @param reviewDate A data em que a avaliação foi feita (representada como String). Não pode ser nula.
     * @throws IllegalArgumentException se `comment` for inválido, `stars` estiver fora do intervalo permitido,
     *                                  ou `reviewDate` for nulo.
     */
    public Review(String comment, float stars, String reviewDate){
        this.comment = comment;
        this.stars = stars;
        this.reviewDate = reviewDate;
    }

    /**
     * Retorna a nota (estrelas) atribuída na avaliação.
     *
     * @return A nota como um valor `float` (entre 1.0 e 5.0).
     */
    public float getStars(){
        return stars;
    }

    /**
     * Retorna uma representação em string da review, formatada para exibição clara.
     * Exemplo: `"Ótimo livro!" (4.5⭐) - 25/12/2023`
     *
     * @return Uma string formatada representando a review.
     */
    @Override
    public String toString() {
        return String.format("%s (%.1f⭐): %s", comment, stars, reviewDate);
    }

}
