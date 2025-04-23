package Control;

import java.util.*;
import java.util.stream.Collectors;

import Module.*;

/**
 * Classe controladora principal (Controller no padrão MVC) para a aplicação Diário Cultural.
 * Responsável por gerenciar as coleções de dados em memória (Livros, Filmes, Séries,
 * Gêneros, Reviews) e por implementar a lógica de negócios da aplicação.
 *
 * <p>Atua como intermediário entre a camada de Visualização (View), que interage com o usuário,
 * e a camada de Modelo (Model), que representa os dados. Fornece métodos públicos para
 * criar, buscar, listar, avaliar e gerenciar as mídias culturais e gêneros.</p>
 *
 * <p><b>Importante:</b> Na versão atual, todos os dados são armazenados em listas na memória
 * RAM e são perdidos quando a aplicação é encerrada (dados voláteis). Não há persistência
 * implementada.</p>
 *
 *
 * @see View.Screen
 * @see View.Create
 * @see View.CreateReview
 * @see View.Search
 *
 * @author Julia Santana de Oliveira e Davi Figuerêdo
 */
public class WorkManager {

    /** Lista para armazenar todos os objetos {@link Genre} cadastrados. Mantida ordenada alfabeticamente. */
    private final List<Genre> genreLibrary;
    /** Lista geral que armazena todos os objetos {@link Review} criados (de livros, filmes e temporadas de séries). */
    private final List<Review> reviewLibrary;
    /** Lista para armazenar especificamente os objetos {@link Book} cadastrados. */
    private final List<Book> bookLibrary;
    /** Lista para armazenar especificamente os objetos {@link Films} cadastrados. */
    private final List<Films> filmLibrary;
    /** Lista para armazenar especificamente os objetos {@link Show} cadastrados. */
    private final List<Show> showLibrary;
    /** Lista agregada contendo referências a todos os objetos {@link Media} (Book, Films, Show)
     * para facilitar buscas e listagens gerais que abrangem todos os tipos de mídia. */
    private final List<Media> media;




    /**
     * Construtor padrão do WorkManager.
     * Inicializa todas as listas de dados (`genreLibrary`, `reviewLibrary`, `bookLibrary`,
     * `filmLibrary`, `showLibrary`, `media`) como {@link ArrayList}s vazias.
     */
    public WorkManager() {

        this.genreLibrary = new ArrayList<>();
        this.reviewLibrary = new ArrayList<>();
        this.bookLibrary = new ArrayList<>();
        this.filmLibrary = new ArrayList<>();
        this.showLibrary = new ArrayList<>();
        this.media = new ArrayList<>();

        initializeExampleData();

    }



    private void initializeExampleData() {
        System.out.println("--- Inicializando Dados de Exemplo ---");

        // --- 1. Criação de Gêneros ---
        addGenre("Ficção Científica");
        addGenre("Fantasia");
        addGenre("Drama");
        addGenre("Aventura");
        addGenre("Suspense");
        addGenre("Romance");
        addGenre("Ação");
        addGenre("Comédia");
        addGenre("Mistério");
        addGenre("Histórico");
        addGenre("Biografia");
        addGenre("Crime");

        class GenreFinder {
            static Genre find(String name, List<Genre> library) {
                for (Genre g : library) {
                    if (g.getGenre().equalsIgnoreCase(name)) {
                        return g;
                    }
                }
                System.out.println("AVISO: Gênero '" + name + "' não encontrado durante inicialização!");
                return null;
            }
        }

        // --- 3. Criação de Livros ---
        // Livro 1
        List<Genre> generosLivro1 = new ArrayList<>();
        Genre g1_1 = GenreFinder.find("Ficção Científica", genreLibrary); if (g1_1 != null) generosLivro1.add(g1_1);
        Genre g1_2 = GenreFinder.find("Aventura", genreLibrary);         if (g1_2 != null) generosLivro1.add(g1_2);
        Genre g1_3 = GenreFinder.find("Drama", genreLibrary);            if (g1_3 != null) generosLivro1.add(g1_3);
        createBook(true, "Duna", generosLivro1, 1965, "Frank Herbert", "Chilton Books", "978-0441172719", true);

        // Livro 2
        List<Genre> generosLivro2 = new ArrayList<>();
        Genre g2_1 = GenreFinder.find("Drama", genreLibrary);     if (g2_1 != null) generosLivro2.add(g2_1);
        Genre g2_2 = GenreFinder.find("Aventura", genreLibrary);  if (g2_2 != null) generosLivro2.add(g2_2);
        createBook(false, "O Conde de Monte Cristo", generosLivro2, 1844, "Alexandre Dumas", "Penguin Classics", "978-0140449266", true);

        // Livro 3
        List<Genre> generosLivro3 = new ArrayList<>();
        Genre g3_1 = GenreFinder.find("Fantasia", genreLibrary);  if (g3_1 != null) generosLivro3.add(g3_1);
        Genre g3_2 = GenreFinder.find("Aventura", genreLibrary);  if (g3_2 != null) generosLivro3.add(g3_2);
        createBook(true, "O Hobbit", generosLivro3, 1937, "J.R.R. Tolkien", "HarperCollins", "978-0547928227", false);

        // Livro 4
        List<Genre> generosLivro4 = new ArrayList<>();
        Genre g4_1 = GenreFinder.find("Suspense", genreLibrary);  if (g4_1 != null) generosLivro4.add(g4_1);
        Genre g4_2 = GenreFinder.find("Mistério", genreLibrary);  if (g4_2 != null) generosLivro4.add(g4_2);
        Genre g4_3 = GenreFinder.find("Drama", genreLibrary);     if (g4_3 != null) generosLivro4.add(g4_3);
        createBook(true, "Garota Exemplar", generosLivro4, 2012, "Gillian Flynn", "Intrínseca", "978-8580573514", true);

        // Livro 5
        List<Genre> generosLivro5 = new ArrayList<>();
        Genre g5_1 = GenreFinder.find("Ficção Científica", genreLibrary); if (g5_1 != null) generosLivro5.add(g5_1);
        Genre g5_2 = GenreFinder.find("Drama", genreLibrary);             if (g5_2 != null) generosLivro5.add(g5_2);
        Genre g5_3 = GenreFinder.find("Aventura", genreLibrary);          if (g5_3 != null) generosLivro5.add(g5_3);
        createBook(true, "Messias de Duna", generosLivro5, 1969, "Frank Herbert", "Ace Books", "978-0441523967", false);


        // --- 4. Criação de Filmes ---
        // Filme 1
        List<Genre> generosFilme1 = new ArrayList<>();
        Genre gf1_1 = GenreFinder.find("Ficção Científica", genreLibrary); if (gf1_1 != null) generosFilme1.add(gf1_1);
        Genre gf1_2 = GenreFinder.find("Drama", genreLibrary);            if (gf1_2 != null) generosFilme1.add(gf1_2);
        Genre gf1_3 = GenreFinder.find("Aventura", genreLibrary);         if (gf1_3 != null) generosFilme1.add(gf1_3);
        createFilm(List.of("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"), true, "Interestelar", generosFilme1, 2014, "Interstellar", List.of("HBO Max", "Prime Video"), "Christopher Nolan", 169, "Jonathan Nolan, Christopher Nolan");

        // Filme 2
        List<Genre> generosFilme2 = new ArrayList<>();
        Genre gf2_1 = GenreFinder.find("Ação", genreLibrary);             if (gf2_1 != null) generosFilme2.add(gf2_1);
        Genre gf2_2 = GenreFinder.find("Ficção Científica", genreLibrary); if (gf2_2 != null) generosFilme2.add(gf2_2);
        Genre gf2_3 = GenreFinder.find("Aventura", genreLibrary);         if (gf2_3 != null) generosFilme2.add(gf2_3);
        createFilm(List.of("Tom Hardy", "Charlize Theron", "Nicholas Hoult"), true, "Mad Max: Estrada da Fúria", generosFilme2, 2015, "Mad Max: Fury Road", List.of("HBO Max"), "George Miller", 120, "George Miller, Brendan McCarthy, Nico Lathouris");

        // Filme 3
        List<Genre> generosFilme3 = new ArrayList<>();
        Genre gf3_1 = GenreFinder.find("Drama", genreLibrary); if (gf3_1 != null) generosFilme3.add(gf3_1);
        createFilm(List.of("Miles Teller", "J.K. Simmons"), true, "Whiplash: Em Busca da Perfeição", generosFilme3, 2014, "Whiplash", List.of("Netflix", "Star+"), "Damien Chazelle", 106, "Damien Chazelle");

        // Filme 4
        List<Genre> generosFilme4 = new ArrayList<>();
        Genre gf4_1 = GenreFinder.find("Ação", genreLibrary);             if (gf4_1 != null) generosFilme4.add(gf4_1);
        Genre gf4_2 = GenreFinder.find("Ficção Científica", genreLibrary); if (gf4_2 != null) generosFilme4.add(gf4_2);
        Genre gf4_3 = GenreFinder.find("Suspense", genreLibrary);         if (gf4_3 != null) generosFilme4.add(gf4_3);
        createFilm(List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page", "Tom Hardy"), false, "A Origem", generosFilme4, 2010, "Inception", List.of("HBO Max", "Netflix"), "Christopher Nolan", 148, "Christopher Nolan");

        // Filme 5
        List<Genre> generosFilme5 = new ArrayList<>();
        Genre gf5_1 = GenreFinder.find("Biografia", genreLibrary); if (gf5_1 != null) generosFilme5.add(gf5_1);
        Genre gf5_2 = GenreFinder.find("Drama", genreLibrary);     if (gf5_2 != null) generosFilme5.add(gf5_2);
        Genre gf5_3 = GenreFinder.find("Histórico", genreLibrary); if (gf5_3 != null) generosFilme5.add(gf5_3);
        createFilm(List.of("Benedict Cumberbatch", "Keira Knightley", "Matthew Goode"), true, "O Jogo da Imitação", generosFilme5, 2014, "The Imitation Game", List.of("Netflix", "Prime Video"), "Morten Tyldum", 114, "Graham Moore");


        // --- 5. Criação de Séries e Temporadas ---
        // Série 1
        List<Genre> generosSerie1 = new ArrayList<>();
        Genre gs1_1 = GenreFinder.find("Comédia", genreLibrary); if (gs1_1 != null) generosSerie1.add(gs1_1);
        Genre gs1_2 = GenreFinder.find("Drama", genreLibrary);   if (gs1_2 != null) generosSerie1.add(gs1_2);
        createShow(List.of("Phoebe Waller-Bridge", "Sian Clifford", "Olivia Colman"), true, "Fleabag", generosSerie1, 2016, "Fleabag", List.of("Prime Video"), 2019);
        int s1t1 = createSeason("Fleabag", 1, 6, "21/07/2016");
        int s1t2 = createSeason("Fleabag", 2, 6, "04/03/2019");

        // Série 2
        List<Genre> generosSerie2 = new ArrayList<>();
        Genre gs2_1 = GenreFinder.find("Ficção Científica", genreLibrary); if (gs2_1 != null) generosSerie2.add(gs2_1);
        Genre gs2_2 = GenreFinder.find("Suspense", genreLibrary);         if (gs2_2 != null) generosSerie2.add(gs2_2);
        Genre gs2_3 = GenreFinder.find("Drama", genreLibrary);            if (gs2_3 != null) generosSerie2.add(gs2_3);
        Genre gs2_4 = GenreFinder.find("Mistério", genreLibrary);         if (gs2_4 != null) generosSerie2.add(gs2_4);
        createShow(List.of("Louis Hofmann", "Lisa Vicari", "Andreas Pietschmann"), true, "Dark", generosSerie2, 2017, "Dark", List.of("Netflix"), 2020);
        int s2t1 = createSeason("Dark", 1, 10, "01/12/2017");
        int s2t2 = createSeason("Dark", 2, 8, "21/06/2019");
        int s2t3 = createSeason("Dark", 3, 8, "27/06/2020");


        // --- 6. Criação de Reviews (Metade das obras, +/-) ---
        createReviewBook("Duna", "Clássico absoluto, leitura densa mas recompensadora.", 5, "10/01/2024");
        createReviewBook("Garota Exemplar", "Plot twist genial, me deixou de queixo caído.", 4, "15/02/2024");
        createReviewFilm("Interestelar", "Emocionante e visualmente espetacular. Nolan no seu melhor.", 5, "20/01/2024");
        createReviewFilm("Whiplash: Em Busca da Perfeição", "Atuações intensas, especialmente J.K. Simmons.", 5, "05/02/2024");
        createReviewFilm("O Jogo da Imitação", "História importante e performance incrível de Cumberbatch.", 4, "25/02/2024");
        if (s1t1 == 0) createReviewShow("Fleabag", 1, "Humor ácido e inteligente. Amei!", 5, "11/03/2024");
        if (s2t1 == 0) createReviewShow("Dark", 1, "Confuso no começo, mas muito intrigante.", 4, "15/03/2024");
        if (s2t3 == 0) createReviewShow("Dark", 3, "Finalizou bem a complexidade, apesar de algumas pontas.", 4, "20/03/2024");

        System.out.println("--- Dados de Exemplo Carregados ---");
    }

    /**
     * Adiciona um novo gênero à biblioteca (`genreLibrary`).
     * O nome do gênero é tratado para remover espaços extras e a adição é feita
     * apenas se o gênero (ignorando maiúsculas/minúsculas) ainda não existir.
     * A lista de gêneros é mantida ordenada alfabeticamente.
     * Imprime mensagens de feedback no console sobre o resultado da operação.
     *
     * @param genreName O nome do gênero a ser adicionado. Se for nulo, vazio ou consistir
     *                  apenas de espaços, a operação é ignorada com uma mensagem de aviso.
     */
    public void addGenre(String genreName){
        genreLibrary.add(new Genre(genreName));
        Collections.sort(genreLibrary);
    }

    /**
     * Retorna uma visão não modificável da lista completa de gêneros cadastrados
     * na `genreLibrary`. Isso impede que o código externo altere a lista diretamente.
     *
     * @return Uma {@code List<Genre>} não modificável contendo todos os gêneros cadastrados,
     *         ordenada alfabeticamente.
     */
    public List<Genre> getGenres() {
        return genreLibrary;
    }


    /**
     * Imprime no console a lista de nomes dos gêneros atualmente cadastrados.
     * Este método é destinado principalmente para fins de teste ou confirmação visual rápida
     * pela camada de Visualização (View), pois imprime diretamente no `System.out`.
     */
    public void getGenresTest() {

        for (Genre genre : genreLibrary) {
            System.out.println("- " + genre.getGenre());
        }
    }


    // METHODS RELATED TO BOOKS =====================================================================================

    /**
     * Cria uma nova instância de {@link Book} com os dados fornecidos e a adiciona
     * à biblioteca específica de livros (`bookLibrary`) e também à lista agregada
     * de todas as mídias (`media`). Trata exceções durante a criação do objeto Book.
     *
     * @param seen        Indica se o livro já foi lido pelo usuário.
     * @param title       O título do livro (não nulo/vazio).
     * @param genres      A lista de {@link Genre}s do livro (não nula).
     * @param yearRelease O ano de publicação do livro.
     * @param author      O autor do livro (não nulo/vazio).
     * @param publisher   A editora do livro (pode ser nula/vazia).
     * @param isbn        O ISBN do livro (não nulo/vazio).
     * @param copy        Indica se o usuário possui uma cópia física.
     */
    public void createBook(boolean seen, String title,List<Genre> genres, int yearRelease, String author, String publisher, String isbn, boolean copy){
        Book book = new Book (seen, title, genres, yearRelease, author, publisher, isbn, copy);
        bookLibrary.add(book);
        media.add(book);
    }

    /**
     * Cria uma nova {@link Review} para um livro específico, identificado pelo título.
     * A busca pelo livro ignora maiúsculas/minúsculas no título.
     * A review só é adicionada se o livro for encontrado e estiver marcado como lido (`isSeen() == true`).
     * A review criada é adicionada tanto à lista de reviews do próprio objeto {@link Book}
     * quanto à lista geral `reviewLibrary`.
     *
     * @param title      O título do livro a ser avaliado (case-insensitive).
     * @param comment    O texto da avaliação (não nulo/vazio).
     * @param stars      A nota atribuída (deve estar entre 1 e 5).
     * @param reviewDate A data da avaliação (String formatada, não nula).
     * @return Código de status inteiro:
     *         <ul>
     *           <li>0: Sucesso - Review criada e adicionada.</li>
     *           <li>1: Erro - Livro com o título especificado não encontrado.</li>
     *           <li>2: Erro - Livro encontrado, mas não está marcado como lido.</li>
     *           <li>99: Erro - Dados fornecidos para a review (comentário, estrelas, data) são inválidos.</li>
     *         </ul>
     */
    public int createReviewBook(String title, String comment, int stars, String reviewDate) {
        for (Book book : bookLibrary) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isSeen()) {
                    Review newReview = new Review(comment, stars, reviewDate);

                    book.addReview(newReview);
                    reviewLibrary.add(newReview);

                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    /**
     * Retorna uma lista contendo apenas os títulos de todos os livros presentes
     * na `bookLibrary`. A lista retornada é ordenada alfabeticamente (ignorando case).
     * Útil para a camada View apresentar opções de seleção de livros ao usuário.
     *
     * @return Uma {@code List<String>} com os títulos dos livros, ordenada alfabeticamente.
     *         Retorna uma lista vazia se não houver livros cadastrados.
     */
    public List<String> getBooksName() {
        List<String> bookTitles = new ArrayList<>();
        for (Book b : bookLibrary) {
            bookTitles.add(b.getTitle());
        }
        return bookTitles;
    }


    // METHODS RELATED TO FILMS =============================================================================================================================

    /**
     * Cria uma nova instância de {@link Films} com os dados fornecidos e a adiciona
     * à biblioteca específica de filmes (`filmLibrary`) e à lista agregada `media`.
     * Trata exceções durante a criação do objeto Films.
     *
     * @param cast          Lista de strings do elenco principal.
     * @param seen          Indica se o filme já foi visto.
     * @param title         O título do filme (não nulo/vazio).
     * @param genres        A lista de {@link Genre}s do filme (não nula).
     * @param yearRelease   O ano de lançamento.
     * @param originalTitle O título original (pode ser nulo).
     * @param whereWatch    Lista de strings de onde assistir.
     * @param direction     O(s) diretor(es) (pode ser nulo/vazio).
     * @param runningtime   A duração em minutos (deve ser > 0).
     * @param screenplay    O(s) roteirista(s) (pode ser nulo/vazio).
     */
    public void createFilm(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, String direction, int runningtime, String screenplay){
        Films film = new Films (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, direction, runningtime, screenplay);
        filmLibrary.add(film);
        media.add(film);
    }

    /**
     * Cria uma nova {@link Review} para um filme específico, identificado pelo título.
     * A busca pelo filme ignora maiúsculas/minúsculas no título.
     * A review só é adicionada se o filme for encontrado e estiver marcado como visto (`isSeen() == true`).
     * A review criada é adicionada à lista de reviews do objeto {@link Films} e à lista geral `reviewLibrary`.
     *
     * @param title      O título do filme a ser avaliado (case-insensitive).
     * @param comment    O texto da avaliação (não nulo/vazio).
     * @param stars      A nota atribuída (deve estar entre 1 e 5).
     * @param reviewDate A data da avaliação (String formatada, não nula).
     * @return Código de status inteiro:
     *         <ul>
     *           <li>0: Sucesso - Review criada e adicionada.</li>
     *           <li>1: Erro - Filme com o título especificado não encontrado.</li>
     *           <li>2: Erro - Filme encontrado, mas não está marcado como visto.</li>
     *           <li>99: Erro - Dados fornecidos para a review são inválidos.</li>
     *         </ul>
     */
    public int createReviewFilm(String title, String comment, int stars, String reviewDate) {
        for (Films film : filmLibrary) {
           if (film.getTitle() != null && film.getTitle().equalsIgnoreCase(title)) {
                if (film.isSeen()) {
                    Review newReview = new Review(comment, stars, reviewDate);

                    film.addReview(newReview);
                    reviewLibrary.add(newReview);

                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    // AUXILIARY METHOD OF "createReviewFilm": SELECT THE CORRESPONDING FILM IN CLASS CREATE REVIEW
    /**
     * Retorna uma lista contendo apenas os títulos de todos os filmes presentes
     * na `filmLibrary`. A lista é ordenada alfabeticamente (ignorando case).
     * Útil para a View apresentar opções de seleção de filmes.
     *
     * @return Uma {@code List<String>} com os títulos dos filmes, ordenada.
     *         Retorna lista vazia se não houver filmes.
     */
    public List<String> getFilmName() {
        List<String> filmTitles = new ArrayList<>();
        for (Films f : filmLibrary) {
            filmTitles.add(f.getTitle());
        }
        return filmTitles;
    }

    // METHODS RELATED TO SHOW/SEASON =============================================================================================================================

    /**
     * Cria uma nova instância de {@link Show} com os dados fornecidos e a adiciona
     * à biblioteca específica de séries (`showLibrary`) e à lista agregada `media`.
     * Trata exceções durante a criação do objeto Show.
     *
     * @param cast          Lista de strings do elenco principal.
     * @param seen          Indica se a série (ou parte dela) já foi vista.
     * @param title         O título da série (não nulo/vazio).
     * @param genres        A lista de {@link Genre}s da série (não nula).
     * @param yearRelease   O ano de lançamento da primeira temporada.
     * @param originalTitle O título original (pode ser nulo).
     * @param whereWatch    Lista de strings de onde assistir.
     * @param yearEnd       O ano de encerramento (0 se não aplicável, deve ser >= yearRelease se > 0).
     */
    public void createShow(List<String> cast, boolean seen, String title, List<Genre> genres, int yearRelease, String originalTitle, List<String> whereWatch, int yearEnd){
        Show show = new Show (cast, seen, title, genres, yearRelease, originalTitle, whereWatch, yearEnd);
        showLibrary.add(show);
        media.add(show);
    }



    /**
     * Cria uma nova {@link Season} para uma série existente, identificada pelo título.
     * Verifica primeiro se a série existe na `showLibrary`. Em seguida, verifica se uma
     * temporada com o `seasonNumber` fornecido já existe para essa série. Se não existir,
     * cria a nova temporada e a adiciona à lista de temporadas do objeto {@link Show} correspondente.
     *
     * @param title        O título da série à qual adicionar a temporada (case-insensitive).
     * @param seasonNumber O número da nova temporada (deve ser > 0).
     * @param episodeCount O número de episódios da nova temporada (deve ser > 0).
     * @param releaseDate  A data de lançamento da nova temporada (String formatada, não nula).
     * @return Código de status inteiro:
     *         <ul>
     *           <li>0: Sucesso - Temporada criada e adicionada à série.</li>
     *           <li>1: Erro - Série com o título especificado não encontrada.</li>
     *           <li>4: Erro - Uma temporada com este número já existe para esta série.</li>
     *           <li>98: Erro - Dados fornecidos para a temporada (número, episódios, data) são inválidos.</li>
     *         </ul>
     */
    public int createSeason(String title, int seasonNumber, int episodeCount, String releaseDate) {
        for (Show show : showLibrary) {
            if (show.getTitle() != null && show.getTitle().equalsIgnoreCase(title)) {
                if (show.isSeen()) {
                    Season newSeason = new Season(seasonNumber, episodeCount, releaseDate);
                    show.addSeason(newSeason);
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    // AUXILIARY METHOD OF "createSeason": SELECT THE CORRESPONDING SHOW IN CLASS CREATE
    /**
     * Retorna uma lista contendo apenas os títulos de todas mobilization séries presentes
     * na `showLibrary`. A lista é ordenada alfabeticamente (ignorando case).
     * Útil para a View apresentar opções de seleção de séries.
     *
     * @return Uma {@code List<String>} com os títulos das séries, ordenada.
     *         Retorna lista vazia se não houver séries.
     */
    public List<String> getShowName() {
        List<String> showTitles = new ArrayList<>();
        for (Show s : showLibrary) {
            showTitles.add(s.getTitle());
        }
        return showTitles;
    }

    /**
     * Cria uma nova {@link Review} para uma temporada específica de uma série.
     * Primeiro, localiza a série pelo `showTitle` (case-insensitive). Em seguida, localiza
     * a temporada específica dentro dessa série pelo `seasonNumber`. Se ambos forem encontrados,
     * cria a review e a adiciona à lista de reviews da temporada encontrada e à lista geral `reviewLibrary`.
     *
     * @param showTitle    O título da série (case-insensitive).
     * @param seasonNumber O número da temporada a ser avaliada.
     * @param comment      O texto da avaliação (não nulo/vazio).
     * @param stars        A nota atribuída (deve estar entre 1 e 5).
     * @param reviewDate   A data da avaliação (String formatada, não nula).
     * @return Código de status inteiro:
     *         <ul>
     *           <li>0: Sucesso - Review criada e adicionada à temporada.</li>
     *           <li>1: Erro - Série com o título especificado não encontrada.</li>
     *           <li>3: Erro - Temporada com o número especificado não encontrada para esta série.</li>
     *           <li>99: Erro - Dados fornecidos para a review são inválidos.</li>
     *           <li>97: Erro - Erro interno ao tentar localizar o objeto Season original para adicionar a review.</li>
     *         </ul>
     */
    public int createReviewShow(String showTitle, int seasonNumber, String comment, int stars, String reviewDate) {
        for (Show show : showLibrary) {
            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                for (Season season : show.getSeasons()) {
                    if (season.getSeasonNumber() == seasonNumber) {

                        Review newReview = new Review(comment, stars, reviewDate);
                        season.addReview(newReview);
                        reviewLibrary.add(newReview);
                        return 0; // Review create with sucess

                    }
                }
                return 3; // Season not found
            }
        }
        return 1; // Show not found
    }

    // AUXILIARY METHOD OF "getSeasonsByShowName": SELECT THE CORRESPONDING SEASON IN CLASS CREATE REVIEW
    /**
     * Retorna uma lista ordenada contendo os números de todas as temporadas existentes
     * para uma série específica, identificada pelo título.
     * Útil para a View permitir ao usuário selecionar uma temporada existente.
     *
     * @param showTitle O título da série (case-insensitive) cujos números de temporada são desejados.
     * @return Uma {@code List<Integer>} ordenada com os números das temporadas.
     *         Retorna uma lista vazia se a série não for encontrada ou não tiver temporadas.
     */
    public List<Integer> getSeasonsByShowName(String showTitle) {
        for (Show show : showLibrary) {
            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                List<Integer> seasonNumbers = new ArrayList<>();
                for (Season season : show.getSeasons()) {
                    seasonNumbers.add(season.getSeasonNumber());
                }
                return seasonNumbers;
            }
        }
        return Collections.emptyList();
    }

    /**
     * Imprime no console informações detalhadas sobre todas as séries cadastradas
     * na `showLibrary`, incluindo detalhes de cada uma de suas temporadas e as
     * {@link Review}s associadas a cada temporada.
     */
    public void getShow() {
        for (Show show : showLibrary) {
            System.out.println(show.toString());
            for (Season season : show.getSeasons()) {
                System.out.println("  Temporada " + season.getSeasonNumber() + ":");
                for (Review review : season.getReviews()) {
                    System.out.println("    - " + review.toString());
                }
            }
        }
    }



    // METHODS RELATED TO SEARCH =============================================================================================================================

    /**
     * Busca mídias na lista agregada `media` cujo título contenha a {@code String} fornecida,
     * ignorando diferenças de maiúsculas/minúsculas.
     *
     * @param title O termo de busca para o título. A busca é cancelada se for nulo ou vazio.
     * @return Uma {@code List<Media>} contendo todas as mídias que correspondem ao critério.
     *         Retorna uma lista vazia se nenhum item for encontrado ou se `title` for inválido.
     */
    public List<Media> searchByTitle(String title) {
        return media.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Busca mídias na lista agregada `media` cujo ano de lançamento (`yearRelease`)
     * seja exatamente igual ao ano fornecido.
     *
     * @param year O ano de lançamento inteiro a ser buscado.
     * @return Uma {@code List<Media>} contendo todas as mídias lançadas no ano especificado.
     *         Retorna uma lista vazia se nenhum item for encontrado.
     */
    public List<Media> searchByYear(int year) {
        return media.stream()
                .filter(m -> m.getYearRelease() == year)
                .collect(Collectors.toList());
    }


    /**
     * Busca mídias na lista agregada `media` que possuam pelo menos um {@link Genre}
     * cujo nome contenha a {@code String} fornecida, ignorando maiúsculas/minúsculas.
     *
     * @param genreName O nome (ou parte do nome) do gênero a ser buscado. A busca é
     *                  cancelada se for nulo ou vazio.
     * @return Uma {@code List<Media>} contendo todas as mídias que possuem um gênero
     *         correspondente. Retorna lista vazia se nada for encontrado ou se
     *         `genreName` for inválido.
     */
    public List<Media> searchByGenre(String genreName) {
        if (genreName == null || genreName.trim().isEmpty()) {
            return Collections.emptyList();
        } String searchNameLower = genreName.trim().toLowerCase();

        return this.media.stream()
                .filter(m -> {
                    List<Genre> genresDaMedia = m.getGenres();
                    if (genresDaMedia == null || genresDaMedia.isEmpty()) {
                        return false;
                    }
                    return genresDaMedia.stream()
                            .filter(Objects::nonNull)
                            .anyMatch(g -> g.getGenre() != null && g.getGenre().toLowerCase().contains(searchNameLower));
                })
                .collect(Collectors.toList());
    }

    /**
     * Busca livros na `bookLibrary` cujo nome do autor contenha a {@code String} fornecida,
     * ignorando maiúsculas/minúsculas.
     *
     * @param author O nome (ou parte do nome) do autor a ser buscado. Busca cancelada se nulo/vazio.
     * @return Uma {@code List<Book>} contendo os livros correspondentes. Lista vazia se nada encontrado.
     */
    public List<Book> searchBooksByAuthor(String author) {
        return bookLibrary.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Busca livros na `bookLibrary` cujo ISBN seja exatamente igual à {@code String} fornecida,
     * ignorando maiúsculas/minúsculas.
     *
     * @param isbn O ISBN exato a ser buscado. Busca cancelada se nulo/vazio.
     * @return Uma {@code List<Book>} contendo o livro correspondente (geralmente 0 ou 1 item).
     */
    public List<Book> searchBooksByISBN(String isbn) {
        return bookLibrary.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .collect(Collectors.toList());
    }

    /**
     * Busca filmes na `filmLibrary` cujo nome do(s) diretor(es) contenha a {@code String} fornecida,
     * ignorando maiúsculas/minúsculas.
     *
     * @param director O nome (ou parte do nome) do diretor. Busca cancelada se nulo/vazio.
     * @return Uma {@code List<Films>} contendo os filmes correspondentes.
     */
    public List<Films> searchFilmsByDirector(String director) {
        return filmLibrary.stream()
                .filter(f -> f.getDirection().toLowerCase().contains(director.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Busca filmes na `filmLibrary` cuja lista de elenco (`cast`) contenha pelo menos um nome
     * que contenha a {@code String} fornecida, ignorando maiúsculas/minúsculas.
     *
     * @param actor O nome (ou parte do nome) do ator/atriz a ser buscado no elenco.
     *              Busca cancelada se nulo/vazio.
     * @return Uma {@code List<Films>} contendo os filmes que têm a pessoa no elenco.
     */
    public List<Films> searchFilmsByCast(String actor) {
        return filmLibrary.stream()
                .filter(f -> f.getCast().stream().anyMatch(a -> a.toLowerCase().contains(actor.toLowerCase())))
                .collect(Collectors.toList());
    }


    /**
     * Busca séries na `showLibrary` cuja lista de elenco (`cast`) contenha pelo menos um nome
     * que contenha a {@code String} fornecida, ignorando maiúsculas/minúsculas.
     *
     * @param actor O nome (ou parte do nome) do ator/atriz a ser buscado no elenco.
     *              Busca cancelada se nulo/vazio.
     * @return Uma {@code List<Show>} contendo as séries que têm a pessoa no elenco.
     */
    public List<Show> searchShowsByCast(String actor) {
        return showLibrary.stream()
                .filter(s -> s.getCast().stream().anyMatch(a -> a.toLowerCase().contains(actor.toLowerCase())))
                .collect(Collectors.toList());
    }

    /**
     * Retorna a lista agregada `media` completa, ordenada alfabeticamente pelo título
     * (A-Z, ignorando maiúsculas/minúsculas). Filtra itens nulos por segurança.
     *
     * @return Uma nova {@code List<Media>} contendo todos os objetos Media cadastrados,
     *         ordenados por título.
     */
    public List<Media> listMediaAlphabetically() {
        return media.stream()
                .sorted(Comparator.comparing(Media::getTitle))
                .collect(Collectors.toList());
    }

    /**
     * Calcula a avaliação "representativa" de uma mídia para fins de ordenação e exibição.
     * <p>
     * - Para {@link Book} e {@link Films}: Retorna a nota da <b>última</b> review adicionada (ou 0.0f se não houver reviews).
     * - Para {@link Show}: Retorna a <b>média</b> das notas de todas as reviews de todas as suas temporadas (ou 0.0f se não houver reviews/temporadas).
     * - Para outros tipos ou {@code null}: Retorna 0.0f.
     * </p>
     * Este método é estático pois seu cálculo depende apenas do objeto {@link Media} passado como argumento.
     *
     * @param m O objeto {@link Media} cuja avaliação deve ser calculada.
     * @return A nota representativa (última ou média) como float, ou 0.0f.
     */
    public static float calculateAverage(Media m) {
        if (m == null) {
            return 0f;
        }

        if (m instanceof Book || m instanceof Films) {
            List<Review> reviews = m.getReviews();
            if (reviews == null || reviews.isEmpty()) {
                return 0f;
            }
            Review lastReview = reviews.get(reviews.size() - 1);
            return (lastReview != null) ? lastReview.getStars() : 0f;
        }

        else if (m instanceof Show) {
            Show show = (Show) m;
            List<Season> seasons = show.getSeasons();
            if (seasons == null || seasons.isEmpty()) {
                return 0f;
            }

            float totalStarsSum = 0;
            int totalReviewCount = 0;

            for (Season season : seasons) {
                if (season != null) {
                    List<Review> seasonReviews = season.getReviews();
                    if (seasonReviews != null && !seasonReviews.isEmpty()) {
                        for (Review review : seasonReviews) {
                            if (review != null) {
                                totalStarsSum += review.getStars();
                                totalReviewCount++;
                            }
                        }
                    }
                }
            }

            if (totalReviewCount == 0) {
                return 0f;
            }
            return totalStarsSum / totalReviewCount;
        }

        else {
            return 0f;
        }
    }

    /**
     * Filtra a lista agregada de mídias ({@code media}) com base em um ano e/ou gênero opcional,
     * e então ordena a lista resultante de acordo com a opção de ordenação fornecida.
     *
     * @param filterYear  O ano para filtrar (ou {@code null} para não filtrar por ano).
     * @param filterGenre O {@link Genre} para filtrar (ou {@code null} para não filtrar por gênero).
     * @param sortOption  O critério de ordenação:
     *                    <ul>
     *                      <li>1: Avaliação Decrescente (maior para menor)</li>
     *                      <li>2: Avaliação Crescente (menor para maior)</li>
     *                      <li>3 ou outro: Alfabético por Título (A-Z, case-insensitive)</li>
     *                    </ul>
     * @return Uma nova {@code List<Media>} contendo as mídias filtradas e ordenadas.
     */
    public List<Media> getFilteredAndSortedMedia(Integer filterYear, Genre filterGenre, int sortOption) {
        List<Media> filteredList = this.media.stream()

                .filter(media -> filterYear == null || media.getYearRelease() == filterYear)
                .filter(media -> filterGenre == null || media.getGenres().contains(filterGenre))
                .collect(Collectors.toList());

        switch (sortOption) {
            case 1:
                filteredList.sort((m1, m2) -> {
                    float avg1 = WorkManager.calculateAverage(m1);
                    float avg2 = WorkManager.calculateAverage(m2);
                    return Float.compare(avg2, avg1);
                });
                break;
            case 2:
                filteredList.sort((m1, m2) -> {
                    float avg1 = WorkManager.calculateAverage(m1);
                    float avg2 = WorkManager.calculateAverage(m2);
                    return Float.compare(avg1, avg2);
                });
                break;
            case 3:
            default:
                filteredList.sort(Comparator.comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER));
                break;
        }

        return filteredList;
    }

}