package ViewFX;

import Control.WorkManager;
import Module.Genre;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;
import org.controlsfx.control.CheckComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenreController {

    private WorkManager workManager;

    @FXML private TextField genreTitleField;
    @FXML private ListView<String> genreListView;

    @FXML
    public void initialize(){
        this.workManager = new WorkManager();
        populateGenre();
    }

    private void clearAllForms(){
        genreTitleField.clear();
    }


    @FXML
    void addGenre() {
        String newGenreName = genreTitleField.getText();
        if (newGenreName == null || newGenreName.trim().isEmpty()) {
            showAlert("Erro", "O nome do gênero não pode ser vazio.");
            return;
        }

        workManager.addGenre(newGenreName);
        populateGenre();
        clearAllForms();
        showAlert("Sucesso", "Gênero '" + newGenreName + "' adicionado!");

    }


    private void populateGenre(){
        List<String> genreNames = workManager.getGenres().stream()
                .map(Genre::getGenre)
                .collect(Collectors.toList());

        if (genreListView != null) {
            genreListView.getItems().setAll(genreNames);
        }
    }


    private void showAlert(String title, String message) { Alert alert = new Alert(Alert.AlertType.INFORMATION); alert.setTitle(title); alert.setHeaderText(null); alert.setContentText(message); alert.showAndWait(); }










}
