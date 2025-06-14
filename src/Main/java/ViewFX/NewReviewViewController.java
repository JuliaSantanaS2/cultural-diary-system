package ViewFX;

import Control.WorkManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.scene.control.Label;

/**
 * Controller unificado para a tela "New Media".
 * Gerencia os formulários de Livro e Filme, a validação de dados
 * e a lógica para salvar as novas mídias.
 */
public class NewReviewViewController {

    // --- Instâncias de Controle ---
    private WorkManager workManager;
    private Validator bookValidator = new Validator();
    private Validator movieValidator = new Validator();
    private Validator showValidator = new Validator();

    // --- Componentes Comuns e de Troca de Tela ---
    @FXML private ToggleGroup mediaTypeToggleGroup;
    @FXML private VBox bookFormPane;
    @FXML private VBox movieFormPane;
    @FXML private VBox showFormPane;



    // --- Componentes do Formulário de LIVRO ---
    @FXML private ComboBox <String> bookNamesComboBox;
    @FXML private TextArea reviewBookTextArea;
    @FXML private Slider bookRatingSlider;
    @FXML private Label bookRatingValueLabel;

    // --- Componentes do Formulário de FILME ---
    @FXML private ComboBox <String> movieNamesComboBox;
    @FXML private TextArea reviewMovieTextArea;
    @FXML private Slider movieRatingSlider;
    @FXML private Label movieRatingValueLabel;

    // --- Componentes do Formulário de SHOW e TEMPORADA---
    @FXML private ComboBox <String> showNamesComboBox;
    @FXML private ComboBox <Integer> seasonNamesComboBox;
    @FXML private TextArea reviewShowTextArea;
    @FXML private Slider showRatingSlider;
    @FXML private Label showRatingValueLabel;


    // Construtor vazio obrigatório para o FXMLLoader
    public NewReviewViewController() {}

    /**
     * Método executado automaticamente quando o FXML é carregado.
     * É o ponto de partida para configurar a tela.
     */
    @FXML
    public void initialize() {
        this.workManager = new WorkManager();

        populateAllComboBoxes();
        setupFormSwitching();
        setupAllValidations();
        setupAllSliderListeners();

        seasonNamesComboBox.setDisable(true);

        showNamesComboBox.valueProperty().addListener((obs, oldShow, newShow) -> {
            if (newShow != null) {
                // Se uma nova série for selecionada, popula as temporadas
                populateSeasonComboBox(newShow);
                seasonNamesComboBox.setDisable(false); // E habilita a ComboBox de temporadas
            } else {
                // Se nenhuma série for selecionada, limpa e desabilita a ComboBox de temporadas
                seasonNamesComboBox.getItems().clear();
                seasonNamesComboBox.setDisable(true);
            }
        });
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

            if (newToggle != null) {
                String selectedType = ((ToggleButton) newToggle).getText();
                if ("Book".equals(selectedType)) {
                    bookFormPane.setVisible(true);
                } else if ("Movie".equals(selectedType)) {
                    movieFormPane.setVisible(true);
                } else if ("Show/Season".equals(selectedType)) {
                    showFormPane.setVisible(true);
                }
            }
        });
    }

    private String dateNow() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private void setupAllValidations() {
        // Validação para Livro
        bookValidator.createCheck().dependsOn("value", bookNamesComboBox.valueProperty()).withMethod(c -> { if (c.get("value") == null) c.error("Selecione um livro."); }).decorates(bookNamesComboBox);
        bookValidator.createCheck().dependsOn("text", reviewBookTextArea.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("A review não pode ser vazia."); }).decorates(reviewBookTextArea);
        // Validação para Filme
        movieValidator.createCheck().dependsOn("value", movieNamesComboBox.valueProperty()).withMethod(c -> { if (c.get("value") == null) c.error("Selecione um filme."); }).decorates(movieNamesComboBox);
        movieValidator.createCheck().dependsOn("text", reviewMovieTextArea.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("A review não pode ser vazia."); }).decorates(reviewMovieTextArea);
        // Validação para Show/Temporada
        showValidator.createCheck().dependsOn("value", showNamesComboBox.valueProperty()).withMethod(c -> { if (c.get("value") == null) c.error("Selecione uma série."); }).decorates(showNamesComboBox);
        showValidator.createCheck().dependsOn("value", seasonNamesComboBox.valueProperty()).withMethod(c -> { if (c.get("value") == null) c.error("Selecione uma temporada."); }).decorates(seasonNamesComboBox);
        showValidator.createCheck().dependsOn("text", reviewShowTextArea.textProperty()).withMethod(c -> { if (((String) c.get("text")).trim().isEmpty()) c.error("A review não pode ser vazia."); }).decorates(reviewShowTextArea);
    }

    private void setupAllSliderListeners() {
        // Listener para o slider de Livro
        bookRatingSlider.valueProperty().addListener((obs, oldVal, newVal) -> bookRatingValueLabel.setText(String.format("%.0f", newVal)));
        // Listener para o slider de Filme
        movieRatingSlider.valueProperty().addListener((obs, oldVal, newVal) -> movieRatingValueLabel.setText(String.format("%.0f", newVal)));
        // Listener para o slider de Show
        showRatingSlider.valueProperty().addListener((obs, oldVal, newVal) -> showRatingValueLabel.setText(String.format("%.0f", newVal)));
    }

    private void populateAllComboBoxes() {
        bookNamesComboBox.getItems().setAll(workManager.getBooksName());
        movieNamesComboBox.getItems().setAll(workManager.getFilmName());
        showNamesComboBox.getItems().setAll(workManager.getShowName());
    }

    private void populateSeasonComboBox(String showName) {
        List<Integer> seasonNumbers = workManager.getSeasonsByShowName(showName);
        seasonNamesComboBox.getItems().setAll(seasonNumbers);
    }

    /**
     * Método único chamado pelo botão "Salvar Mídia".
     * Ele decide qual validador usar e qual método de salvamento chamar.
     */
    @FXML
    void saveReview() {
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
        }

        if (isFormValid) {
            switch (selectedType) {
                case "Book":
                    saveBookReview();
                    break;
                case "Movie":
                    saveMovieReview();
                    break;
                case "Show":
                    saveShowReview();
                    break;
            }
        } else {
            // Se QUALQUER validação falhar, mostra UM ÚNICO alerta genérico
            showAlert("Erro de Validação", "Por favor, corrija os campos marcados em vermelho.");
        }
    }

    // --- Métodos de Lógica Específicos para Salvar ---

    private void saveBookReview() {
        try {
            workManager.createReviewBook(
                    bookNamesComboBox.getValue(),
                    reviewBookTextArea.getText(),
                    (int) bookRatingSlider.getValue(), // CORRIGIDO: usa o slider de livro
                    dateNow()
            );
            showAlert("Sucesso", "Review para o livro '" + bookNamesComboBox.getValue() + "' salva!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar a review do livro.");
            e.printStackTrace();
        }
    }

    private void saveMovieReview() {
        try {
            workManager.createReviewFilm(
                    movieNamesComboBox.getValue(),
                    reviewMovieTextArea.getText(),
                    (int) movieRatingSlider.getValue(), // CORRIGIDO: usa o slider de filme
                    dateNow()
            );
            showAlert("Sucesso", "Review para o filme '" + movieNamesComboBox.getValue() + "' salva!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar a review do filme.");
            e.printStackTrace();
        }
    }

    private void saveShowReview() {
        try {
            workManager.createReviewShow(
                    showNamesComboBox.getValue(),
                    seasonNamesComboBox.getValue(), // Pega o número da temporada selecionado
                    reviewShowTextArea.getText(),
                    (int) showRatingSlider.getValue(),
                    dateNow()
            );
            showAlert("Sucesso", "Review para a temporada " + seasonNamesComboBox.getValue() + " de '" + showNamesComboBox.getValue() + "' salva!");
            clearAllForms();
        } catch (Exception e) {
            showAlert("Erro", "Ocorreu um erro ao salvar a review da série.");
            e.printStackTrace();
        }
    }


    // --- Métodos Auxiliares e de Ação para Listas ---

    private void clearAllForms() {
        // Limpa campos de Livro
        reviewBookTextArea.clear();
        reviewMovieTextArea.clear();
        reviewShowTextArea.clear();
    }
 private void showAlert(String title, String message) { Alert alert = new Alert(Alert.AlertType.INFORMATION); alert.setTitle(title); alert.setHeaderText(null); alert.setContentText(message); alert.showAndWait(); }
}