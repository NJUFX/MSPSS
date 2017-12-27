package ui.stockmanagerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityInfoModifyViewController implements Initializable {
    Dialog dialog = new Dialog();
    @FXML
    Button sureButton;
    @FXML
    Button cancelButton;

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        cancelButton.getScene().getWindow().hide();
        //((Node) (e.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        dialog.infoDialog("Modify the commodity successfully.");
        sureButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
