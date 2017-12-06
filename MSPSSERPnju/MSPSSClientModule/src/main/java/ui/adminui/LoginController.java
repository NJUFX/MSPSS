package ui.adminui;

import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

    @FXML
    public Button loginButton;

    @FXML
    public TextField idText;
    @FXML
    public PasswordField passwordField;


    @FXML
    public void loginButtonAction(ActionEvent e) {
        String id = idText.getText();
        String password = passwordField.getText();
        application.userLogin(id, password);
        dialog.infoDialog("Login Successfully.");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
