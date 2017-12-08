package ui.adminui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import main.StageSingleton;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class UserAddViewController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

    Stage stage = StageSingleton.getStage();
    /**
     * 确定按钮
     */
    @FXML
    static Button sureButton;
    /**
     * 身份的下拉框
     */
    @FXML
    public ComboBox<String> userCategory;


    /**
     * 用户id
     */
    @FXML
    public Label userId;
    /**
     * 用户权限下拉框
     */
    @FXML
    public ComboBox<String> userPower;

    /**
     * @param e
     */
    @FXML
    public void sureButtonAction(ActionEvent e) {

        dialog.confirmDialog("Do you confirm to add this user?");
        System.out.println("Success.");
        dialog.infoDialog("Add the user successfully.");
    }

    @FXML
    Button delUserButton;

    @FXML
    Button modUserButton;


    public void delUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserDelViewController controller = (UserDelViewController) replaceSceneContent("/view/admin/UserDelView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void modUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserModifyViewController controller = (UserModifyViewController) replaceSceneContent("/view/admin/UserModifyView.fxml");
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
        //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
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
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
