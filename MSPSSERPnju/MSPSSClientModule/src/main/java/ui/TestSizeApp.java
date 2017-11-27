import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestSizeApp extends Application {
	
	public void start(Stage primaryStage) {
		 try {
	            // 这里的root从FXML文件中加载进行初始化，这里FXMLLoader类用于加载FXML文件
	            Pane root = (Pane)FXMLLoader.load(getClass().getResource("TestSize.fxml"));
	            Scene scene = new Scene(root, 900, 560);
	            primaryStage.setScene(scene);
	            
	            scene.getStylesheets().add(getClass().getResource("NewFile.css").toExternalForm()); 
	            primaryStage.setTitle("Test Size");
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
