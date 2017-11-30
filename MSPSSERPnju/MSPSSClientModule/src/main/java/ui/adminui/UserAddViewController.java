package ui.adminui;

import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ui.common.Dialog;
import java.net.URL;
import java.util.ResourceBundle;


public class UserAddViewController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }


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
    public void UserCategoryAction(ActionEvent e) {

    }

    @FXML
    static Button delUserButton;

    @FXML
    public void delUserButtonAction(ActionEvent e) {
        application.toDelUserInfer();
    }

    @FXML
    static Button modUserButton;

    @FXML
    public void modUserButtonAction(ActionEvent e) {
        application.toModUserInfer();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
