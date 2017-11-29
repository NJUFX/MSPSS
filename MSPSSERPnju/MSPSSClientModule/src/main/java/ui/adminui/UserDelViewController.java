package ui.adminui;

import ui.common.Dialog;
import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDelViewController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }


    @FXML
    static Button sureDeleteButton;
    @FXML
    static Button cancelDelteButton;
    @FXML
    static TextField id_to_del;

    @FXML
    public void sureDeleteButtonAction(ActionEvent e) {
        dialog.confirmDialog("Do you confirm to delete this user?");
        System.out.println("Success.");
        dialog.infoDialog("Delete the user successfully.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    static Button addUserButton;

    @FXML
    public void addUserButtonAction(ActionEvent e) {
        application.toAddUserInfer();
    }

    @FXML
    static Button modUserButton;

    @FXML
    public void modUserButtonAction(ActionEvent e) {
        application.toModUserInfer();
    }
}
