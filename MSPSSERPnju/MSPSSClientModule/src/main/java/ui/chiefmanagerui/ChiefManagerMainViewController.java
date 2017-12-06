package ui.chiefmanagerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MainApp;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

public class ChiefManagerMainViewController implements Initializable {
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
