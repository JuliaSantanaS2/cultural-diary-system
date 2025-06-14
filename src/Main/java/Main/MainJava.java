package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// 1. A classe agora estende javafx.application.Application
public class MainJava extends Application {

    // 2. O método start é o ponto de entrada da interface gráfica
    @Override
    public void start(Stage stage) throws IOException {
        // Carrega apenas o container principal na inicialização
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("/Menu.fxml")); // <<< Mude para Menu.fxml
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Cultural Diary System");
        stage.setScene(scene);
        stage.show();
    }

    // 3. O método main agora só chama launch(), que inicia o JavaFX
    public static void main(String[] args) {
        launch();
    }
}