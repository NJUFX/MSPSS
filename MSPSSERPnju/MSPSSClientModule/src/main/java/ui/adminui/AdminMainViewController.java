package ui.adminui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MainApp;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainViewController implements Initializable {
    @FXML
    public void modUserButtonAction(ActionEvent e) {
        application.toModUserInfer();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

}
