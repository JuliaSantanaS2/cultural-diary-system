import java.util.ArrayList;
import java.util.List;

public class WorkManager {

    private final List<AudioVisualMedia> mediaLibrary; // Lista para armazenar objetos de mídia (ex: Filmes)
    private final List<Review> reviews; // Lista de avaliações (reviews)

    // Construtor
    public WorkManager() {
        this.mediaLibrary = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    // Adiciona um item de mídia à biblioteca
    public void addMedia(AudioVisualMedia media) {
     mediaLibrary.add(media);
        System.out.println("📚 Mídia adicionada: " + media.getOriginalTitle());
    }

    // Lista todas as mídias armazenadas
    public void listMediaLibrary() {
        if (mediaLibrary.isEmpty()) {
            System.out.println("A biblioteca de mídia está vazia.");
            return;
        }
        System.out.println("📋 Mídias disponíveis na biblioteca:");
        for (AudioVisualMedia media : mediaLibrary) {
            System.out.println("-> " + media.getOriginalTitle());
        }
    }

    // Adiciona uma avaliação (Review) à lista, verificando restrições
    public void addReview(String comment, boolean status, float stars, String reviewDate) {
        try {
            Review review = new Review(comment, status, stars, reviewDate);
            reviews.add(review);
            System.out.println("📝 Review adicionada: " + review.getComment());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Não foi possível adicionar a review: " + e.getMessage());
        }
    }

    // Lista todas as avaliações disponíveis
    public void listReviews() {
        if (reviews.isEmpty()) {
            System.out.println("Nenhuma review disponível ainda.");
            return;
        }
        System.out.println("📋 Reviews realizadas:");
        for (Review review : reviews) {
            System.out.println("-> " + review.toString());
        }
    }

    // Associa uma Review a uma mídia específica
    public void addReviewToMedia(String mediaTitle, Review review) {
        for (AudioVisualMedia media : mediaLibrary) {
            if (media.getOriginalTitle().equals(mediaTitle)) {
                System.out.println("📌 Associando review ao título: " + mediaTitle);
                // Aqui você pode implementar um mecanismo na classe AudioVisualMedia para armazenar as avaliações
                System.out.println("Review adicionada: " + review);
                return;
            }
        }
        System.out.println("❌ Mídia não encontrada: " + mediaTitle);
    }

    // Busca uma mídia por título
    public AudioVisualMedia findMediaByTitle(String title) {
        for (AudioVisualMedia media : mediaLibrary) {
            if (media.getOriginalTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

}