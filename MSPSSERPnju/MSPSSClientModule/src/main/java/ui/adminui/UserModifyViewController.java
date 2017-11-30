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

public class UserModifyViewController implements Initializable {
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
        dialog.confirmDialog("Do you confirm to modify this user?");
        System.out.println("Success.");
        dialog.infoDialog("Modify the user successfully.");
    }

    @FXML
    public void UserCategoryAction(ActionEvent e) {

    }
    @FXML
    static Button addUserButton;

    @FXML
    public void addUserButtonAction(ActionEvent e) {
        application.toAddUserInfer();
    }

    @FXML
    static Button delUserButton;

    @FXML
    public void delUserButtonAction(ActionEvent e) {
        application.toDelUserInfer();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
