package ui.stocksellerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class StockSellerMainViewController implements Initializable {

    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

    @FXML
    Button customerManageButton;

    /**
     * 客户管理
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerManageButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent("/view/stockseller/CustomerManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 用来打开fxml文件
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // InputStream in =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
