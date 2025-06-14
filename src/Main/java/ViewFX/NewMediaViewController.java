package ViewFX;

import Control.WorkManager;
import Module.Genre;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;
import org.controlsfx.control.CheckComboBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller unificado para a tela "New Media".
 * Gerencia os formulários de Livro e Filme, a validação de dados
 * e a lógica para salvar as novas mídias.
 */
public class NewMediaViewController {

    // --- Instâncias de Controle ---
    private WorkManager workManager;
    private Validator bookValidator = new Validator();
    private Validator movieValidator = new Validator();
    private Validator showValidator = new Validator();
    private Validator seasonValidator = new Validator();

    // --- Componentes Comuns e de Troca de Tela ---
    @FXML private ToggleGroup mediaTypeToggleGroup;
    @FXML private VBox bookFormPane;
    @FXML private VBox movieFormPane;
    @FXML private VBox showFormPane;
    @FXML private VBox seasonFormPane;


    // --- Componentes do Formulário de LIVRO ---
    @FXML private TextField bookTitleField;
    @FXML private TextField bookOriginalTitleField;
    @FXML private TextField bookAuthorField;
    @FXML private TextField bookPublisherField;
    @FXML private TextField bookIsbnField;
    @FXML private TextField bookReleaseYearField;
    @FXML private CheckComboBox<String> bookGenreCheckComboBox;
    @FXML private CheckBox bookSeenCheckBox;
    @FXML private CheckBox bookPhysicalCopyCheckBox;

    // --- Componentes do Formulário de FILME ---
    @FXML private TextField movieTitleField;
    @FXML private TextField movieOriginalTitleField;
    @FXML private TextField movieDirectionField;
    @FXML private TextField movieScreenplayField;
    @FXML private TextField movieRunningtimeField;
    @FXML private TextField movieCastInputField;
    @FXML private ListView<String> movieCastListView;
    @FXML private TextField moviePlatformInputField;
    @FXML private ListView<String> moviePlatformListView;
    @FXML private TextField movieReleaseYearField;
    @FXML private CheckComboBox<String> movieGenreCheckComboBox;
    @FXML private CheckBox movieSeenCheckBox;

    // --- Componentes do Formulário de SHOW ---
    @FXML private TextField showTitleField;
    @FXML private TextField showOriginalTitleField;
    @FXML private TextField showCastInputField;
    @FXML private ListView<String> showCastListView;
    @FXML private TextField showPlatformInputField;
    @FXML private ListView<String> showPlatformListView;
    @FXML private TextField showReleaseYearField;
    @FXML private CheckComboBox<String> showGenreCheckComboBox;
    @FXML private CheckBox showSeenCheckBox;
    @FXML private TextField showYearEndField;

    // --- Componentes do Formulário de TEMPORADA ---
    @FXML private TextField seasonSeasonNumberTitleField;
    @FXML private TextField seasonEpisodeCountTitleField;
    @FXML private DatePicker seasonReleaseDatePicker;
    @FXML private ComboBox<String> seasonShowComboBox;



    // Construtor vazio obrigatório para o FXMLLoader
    public NewMediaViewController() {}

    /**
     * Método executado automaticamente quando o FXML é carregado.
     * É o ponto de partida para configurar a tela.
     */
    @FXML
    public void initialize() {
        this.workManager = new WorkManager();
        populateGenreCheckComboBoxes();
        populateShowCheckComboBoxesForSeason();
        setupFormSwitching();
        setupBookValidation();
        setupMovieValidation();
        setupShowValidation();
        setupSeasonValidation();
    }

    /**
     * Adiciona um listener ao grupo de botões (Book, Movie) para
     * mostrar/esconder o formulário correto.
     */
    private void setupFormSwitching() {
        mediaTypeToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            // Garante que a troca só aconteça se um novo botão for selecionado
            if (newToggle == null && oldToggle != null) {
                oldToggle.setSelected(true); // Impede que nenhum botão fique selecionado
                return;
            }

            bookFormPane.setVisible(false);
            movieFormPane.setVisible(false);
            showFormPane.setVisible(false);
            seasonFormPane.setVisible(false);

            if (newToggle != null) {
                String selectedType = ((ToggleButton) newToggle).getText();
                if ("Book".equals(selectedType)) {
                    bookFormPane.setVisible(true);
                } else if ("Movie".equals(selectedType)) {
                    movieFormPane.setVisible(true);
                } else if ("Show".equals(selectedType)) {
                    showFormPane.setVisible(true);
                } else if ("Season".equals(selectedType)) {
                    seasonFormPane.setVisible(true);
                }
            }
        });
    }

    /**
     * Configura as regras de validação para o formulário de Livro.
     */
    private void setupBookValidation() {
        bookValidator.createCheck().dependsOn("text", bookTitleField.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("Título é obrigatório."); }).decorates(bookTitleField);
        bookValidator.createCheck().dependsOn("text", bookAuthorField.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("Autor é obrigatório."); }).decorates(bookAuthorField);
        bookValidator.createCheck().dependsOn("text", bookReleaseYearField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d{4}")) c.error("Ano deve ter 4 números."); }).decorates(bookReleaseYearField);
        bookValidator.createCheck().dependsOn("size", Bindings.size(bookGenreCheckComboBox.getCheckModel().getCheckedItems())).withMethod(c -> { if (c.get("size").equals(0)) c.error("Selecione um gênero."); }).decorates(bookGenreCheckComboBox);
    }

    /**
     * Configura as regras de validação para o formulário de Filme.
     */
    private void setupMovieValidation() {
        movieValidator.createCheck().dependsOn("text", movieTitleField.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("Título é obrigatório."); }).decorates(movieTitleField);
        movieValidator.createCheck().dependsOn("text", movieReleaseYearField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d{4}")) c.error("Ano deve ter 4 números."); }).decorates(movieReleaseYearField);
        movieValidator.createCheck().dependsOn("size", Bindings.size(movieCastListView.getItems())).withMethod(c -> { if (c.get("size").equals(0)) c.error("Adicione pelo menos um ator."); }).decorates(movieCastListView);
        movieValidator.createCheck().dependsOn("size", Bindings.size(movieGenreCheckComboBox.getCheckModel().getCheckedItems())).withMethod(c -> { if (c.get("size").equals(0)) c.error("Selecione um gênero."); }).decorates(movieGenreCheckComboBox);
    }

    private void setupShowValidation() {
        showValidator.createCheck().dependsOn("text", showTitleField.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("Título é obrigatório."); }).decorates(showTitleField);
        showValidator.createCheck().dependsOn("text", showReleaseYearField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d{4}")) c.error("Ano deve ter 4 números."); }).decorates(showReleaseYearField);
        showValidator.createCheck().dependsOn("text", showYearEndField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d{4}")) c.error("Ano deve ter 4 números."); }).decorates(showYearEndField);
        showValidator.createCheck().dependsOn("size", Bindings.size(showCastListView.getItems())).withMethod(c -> { if (c.get("size").equals(0)) c.error("Adicione pelo menos um ator."); }).decorates(showCastListView);
        showValidator.createCheck().dependsOn("size", Bindings.size(showGenreCheckComboBox.getCheckModel().getCheckedItems())).withMethod(c -> { if (c.get("size").equals(0)) c.error("Selecione um gênero."); }).decorates(showGenreCheckComboBox);
    }

    private void setupSeasonValidation() {
        seasonValidator.createCheck().dependsOn("text", seasonSeasonNumberTitleField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d+")) c.error("Temporada deve ter numero"); }).decorates(seasonSeasonNumberTitleField);
        seasonValidator.createCheck().dependsOn("text", seasonEpisodeCountTitleField.textProperty()).withMethod(c -> { if (!((String) c.get("text")).matches("\\d+")) c.error("Tem que ser numeros."); }).decorates(seasonEpisodeCountTitleField);
    }

    /**
     * Popula ambas as caixas de seleção de gênero com os dados do WorkManager.
     */
    private void populateGenreCheckComboBoxes() {
        List<String> genreNames = workManager.getGenres().stream().map(Genre::getGenre).collect(Collectors.toList());
        bookGenreCheckComboBox.getItems().setAll(genreNames);
        movieGenreCheckComboBox.getItems().setAll(genreNames);
        showGenreCheckComboBox.getItems().setAll(genreNames);
    }

    private void populateShowCheckComboBoxesForSeason() {
        List<String> showNames = workManager.getShowName();
        seasonShowComboBox.getItems().setAll(showNames);
    }

    /**
     * Método único chamado pelo botão "Salvar Mídia".
     * Ele decide qual validador usar e qual método de salvamento chamar.
     */
    @FXML
    void saveMedia() {
        ToggleButton selectedButton = (ToggleButton) mediaTypeToggleGroup.getSelectedToggle();
        String selectedType = selectedButton.getText();
        boolean isFormValid = false;

        switch (selectedType) {
            case "Book":
                isFormValid = bookValidator.validate();
                break;
            case "Movie":
                isFormValid = movieValidator.validate();
                break;
            case "Show":
                isFormValid = showValidator.validate();
                break;
            case "Season":
                isFormValid = seasonValidator.validate();
                break;
        }

        if (isFormValid) {
            switch (selectedType) {
                case "Book":
                    saveBook();
                    break;
                case "Movie":
                    saveMovie();
                    break;
                case "Show":
                    saveShow();
                    break;
                case "Season":
                    saveSeason();
                    break;
            }
        } else {
            // Se QUALQUER validação falhar, mostra UM ÚNICO alerta genérico
            showAlert("Erro de Validação", "Por favor, corrija os campos marcados em vermelho.");
        }
    }

    // --- Métodos de Lógica Específicos para Salvar ---

    private void saveBook() {
        try {
            List<String> selectedGenreNames = bookGenreCheckComboBox.getCheckModel().getCheckedItems();
            List<Genre> genresToSave = workManager.getGenres().stream().filter(g -> selectedGenreNames.contains(g.getGenre())).collect(Collectors.toList());

            workManager.createBook(
                    bookSeenCheckBox.isSelected(),
                    bookTitleField.getText(),
                    genresToSave,
                    Integer.parseInt(bookReleaseYearField.getText()),
                    bookAuthorField.getText(),
                    bookPublisherField.getText(),
                    bookIsbnField.getText(),
                    bookPhysicalCopyCheckBox.isSelected()
            );
            showAlert("Sucesso", "Livro '" + bookTitleField.getText() + "' salvo com sucesso!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar o livro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveMovie() {
        try {
            List<String> castToSave = new ArrayList<>(movieCastListView.getItems());
            List<String> platformsToSave = new ArrayList<>(moviePlatformListView.getItems());
            List<String> selectedGenreNames = movieGenreCheckComboBox.getCheckModel().getCheckedItems();
            List<Genre> genresToSave = workManager.getGenres().stream().filter(g -> selectedGenreNames.contains(g.getGenre())).collect(Collectors.toList());

            // Lembre-se: workManager.createFilm precisa aceitar List<String> para cast e platforms
            workManager.createFilm(
                    castToSave,
                    movieSeenCheckBox.isSelected(),
                    movieTitleField.getText(),
                    genresToSave,
                    Integer.parseInt(movieReleaseYearField.getText()),
                    movieOriginalTitleField.getText(),
                    platformsToSave,
                    movieDirectionField.getText(),
                    Integer.parseInt(movieRunningtimeField.getText()),
                    movieScreenplayField.getText()
            );
            showAlert("Sucesso", "Filme '" + movieTitleField.getText() + "' salvo com sucesso!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar o filme: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveShow() {
        try {
            List<String> showCastToSave = new ArrayList<>(showCastListView.getItems());
            List<String> showPlatformsToSave = new ArrayList<>(showPlatformListView.getItems());
            List<String> selectedGenreNames = showGenreCheckComboBox.getCheckModel().getCheckedItems();
            List<Genre> genresToSave = workManager.getGenres().stream().filter(g -> selectedGenreNames.contains(g.getGenre())).collect(Collectors.toList());

            workManager.createShow(
                    showCastToSave,
                    showSeenCheckBox.isSelected(),
                    showTitleField.getText(),
                    genresToSave,
                    Integer.parseInt(showReleaseYearField.getText()),
                    showOriginalTitleField.getText(),
                    showPlatformsToSave,
                    Integer.parseInt(showYearEndField.getText())
            );
            showAlert("Sucesso", "Show '" + showTitleField.getText() + "' salvo com sucesso!");
            populateShowCheckComboBoxesForSeason();
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar o show: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveSeason() {
        try {
            String selectedShowName = seasonShowComboBox.getValue();
            LocalDate dataSelecionada = seasonReleaseDatePicker.getValue();

            if (dataSelecionada == null) {
                showAlert("Erro", "Por favor, selecione uma data de lançamento.");
                return; // Para a execução se a data estiver vazia
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = dataSelecionada.format(formatter);

            workManager.createSeason(
                    selectedShowName,
                    Integer.parseInt(seasonSeasonNumberTitleField.getText()),
                    Integer.parseInt(seasonEpisodeCountTitleField.getText()),
                    dataFormatada
            );
            showAlert("Sucesso", "Temporada salva com sucesso!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar a temporada: " + e.getMessage());
            e.printStackTrace();
        }
    }



    // --- Métodos Auxiliares e de Ação para Listas ---

    private void clearAllForms() {
        // Limpa campos de Livro
        bookTitleField.clear(); bookOriginalTitleField.clear(); bookAuthorField.clear();
        bookPublisherField.clear(); bookIsbnField.clear(); bookReleaseYearField.clear();
        bookSeenCheckBox.setSelected(false); bookPhysicalCopyCheckBox.setSelected(false);
        bookGenreCheckComboBox.getCheckModel().clearChecks();

        // Limpa campos de Filme
        movieTitleField.clear(); movieOriginalTitleField.clear(); movieDirectionField.clear();
        movieScreenplayField.clear(); movieReleaseYearField.clear(); movieRunningtimeField.clear();
        movieSeenCheckBox.setSelected(false); movieGenreCheckComboBox.getCheckModel().clearChecks();
        movieCastInputField.clear(); movieCastListView.getItems().clear();
        moviePlatformInputField.clear(); moviePlatformListView.getItems().clear();

        // Limpa campos de Show
        showTitleField.clear(); showOriginalTitleField.clear(); showReleaseYearField.clear();
        showYearEndField.clear(); showSeenCheckBox.setSelected(false);
        showGenreCheckComboBox.getCheckModel().clearChecks();
        showCastInputField.clear(); showCastListView.getItems().clear();
        showPlatformInputField.clear(); showPlatformListView.getItems().clear();


        // Limpa campos de Temporada
        seasonSeasonNumberTitleField.clear(); seasonEpisodeCountTitleField.clear();
        //dataFormatada.clear(); seasonShowComboBox.getSelectionModel().clearSelection();
    }

    @FXML private void movieAddCastMember() { String name = movieCastInputField.getText().trim(); if (!name.isEmpty()) { movieCastListView.getItems().add(name); movieCastInputField.clear(); } }
    @FXML private void movieRemoveCastMember() { movieCastListView.getItems().remove(movieCastListView.getSelectionModel().getSelectedItem()); }
    @FXML private void movieAddPlatform() { String name = moviePlatformInputField.getText().trim(); if (!name.isEmpty()) { moviePlatformListView.getItems().add(name); moviePlatformInputField.clear(); } }
    @FXML private void movieRemovePlatform() { moviePlatformListView.getItems().remove(moviePlatformListView.getSelectionModel().getSelectedItem()); }

    @FXML private void showAddCastMember() { String name = showCastInputField.getText().trim(); if (!name.isEmpty()) { showCastListView.getItems().add(name); showCastInputField.clear(); } }
    @FXML private void showRemoveCastMember() { showCastListView.getItems().remove(showCastListView.getSelectionModel().getSelectedItem()); }
    @FXML private void showAddPlatform() { String name = showPlatformInputField.getText().trim(); if (!name.isEmpty()) { showPlatformListView.getItems().add(name); showPlatformInputField.clear(); } }
    @FXML private void showRemovePlatform() { showPlatformListView.getItems().remove(showPlatformListView.getSelectionModel().getSelectedItem()); }

    private void showAlert(String title, String message) { Alert alert = new Alert(Alert.AlertType.INFORMATION); alert.setTitle(title); alert.setHeaderText(null); alert.setContentText(message); alert.showAndWait(); }
}