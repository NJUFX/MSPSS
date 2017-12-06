package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class StageSingleton {
    private static Stage stage;

    public static synchronized Stage getStage() {
        return stage;
    }

    public static synchronized void setStage(Stage s) {
        stage = s;
    }
}
