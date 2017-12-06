package ui.stocksellerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MainApp;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

public class StockSellerMainViewController implements Initializable {
<<<<<<< HEAD

=======

    @FXML
    public void modUserButtonAction(ActionEvent e) {
        //application.toModUserInfer();
    }


>>>>>>> 40b8407d034bde1ae2d21de94afb31474a9558cc
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
