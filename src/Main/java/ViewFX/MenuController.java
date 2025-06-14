package ViewFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;

/**
 * Esta classe é a "Torre de Controle" da sua aplicação.
 * Ela gerencia o menu lateral e é responsável por carregar
 * as diferentes telas de conteúdo no centro da janela.
 */
public class MenuController {

    // A conexão com o BorderPane principal do seu Menu.fxml
    @FXML
    private BorderPane mainContainer;

    /**
     * Método chamado pelo botão "New Media".
     * A única responsabilidade dele é chamar o loadView com o nome do arquivo FXML unificado.
     */
    @FXML
    void showNewMediaView() {
        System.out.println("Botão New Media clicado! Carregando a tela unificada...");
        loadView("NewMediaView.fxml");
    }

    /**
     * Método chamado pelo botão "Genres".
     * (Atualmente um placeholder, carregará a tela de gêneros no futuro)
     */
    @FXML
    void showGenresView() {
        System.out.println("Botão Genres clicado!");
        loadView("Genre.fxml");
    }

    /**
     * Método chamado pelo botão "Review".
     * (Atualmente um placeholder)
     */
    @FXML
    void showReviewView() {
        System.out.println("Botão Review clicado!");
        loadView("NewReviewView.fxml");
    }

    /**
     * Método chamado pelo botão "Search / List".
     * (Atualmente um placeholder)
     */
    @FXML
    void showSearchView() {
        System.out.println("Botão Search / List clicado!");
        // loadView("SearchView.fxml");
    }

    /**
     * Método auxiliar genérico para carregar qualquer arquivo FXML no centro do BorderPane.
     * @param fxmlFileName O nome do arquivo FXML a ser carregado (ex: "NewMediaView.fxml")
     */
    private void loadView(String fxmlFileName) {
        try {
            // Constrói o caminho completo a partir da raiz da pasta 'resources'
            String path = "/" + fxmlFileName;
            URL resourceUrl = getClass().getResource(path);

            // Verifica se o arquivo foi realmente encontrado antes de tentar carregar
            if (resourceUrl == null) {
                System.err.println("ERRO: Arquivo FXML não encontrado no caminho: " + path);
                showAlert("Erro Crítico", "O arquivo de interface '" + fxmlFileName + "' não foi encontrado.");
                return;
            }

            // Carrega o FXML e o coloca no centro da tela
            Parent view = FXMLLoader.load(resourceUrl);
            mainContainer.setCenter(view);

        } catch (IOException e) {
            // Pega outros erros que podem acontecer durante o carregamento (ex: erro de sintaxe no FXML)
            System.err.println("Falha ao carregar a view: " + fxmlFileName);
            e.printStackTrace();
            showAlert("Erro ao Carregar", "Ocorreu um erro ao processar a tela. Verifique o console para detalhes.");
        }
    }

    // Método auxiliar para mostrar alertas de erro
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}