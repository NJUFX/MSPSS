package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.userblservice.UserBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import ui.common.Dialog;
import util.ResultMessage;
import vo.UserVO;

import java.net.URL;
import java.nio.channels.AcceptPendingException;
import java.util.ResourceBundle;

public class ModifyPasswordViewController implements Initializable {
    Dialog dialog = new Dialog();
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    @FXML
    TextField idField;
    @FXML
    PasswordField oldPasswordField, newPasswordField;
    @FXML
    Button modButton;

    @FXML
    public void modButtonAction(ActionEvent e) {
        if (idField.getText() != null && !idField.getText().trim().equals("") &&
                oldPasswordField.getText() != null && !oldPasswordField.getText().trim().equals("") &&
                newPasswordField.getText() != null && !newPasswordField.getText().trim().equals("")) {
            if (userBLService.searchUserByID(idField.getText().trim()) != null) {
                UserVO userVO = userBLService.searchUserByID(idField.getText().trim());
                if (userVO.getPassword().equals(oldPasswordField.getText().trim())) {
                    userVO.setPassword(newPasswordField.getText().trim());
                    ResultMessage resultMessage = userBLService.updateUser(userVO);
                    if (resultMessage == ResultMessage.SUCCESS) {
                        dialog.infoDialog("Modify password successfully.");
                        modButton.getScene().getWindow().hide();
                    }
                } else {
                    dialog.errorInfoDialog("Old password is wrong.");
                }
            } else {
                dialog.errorInfoDialog("Id not exist!");
            }
        } else {
            dialog.errorInfoDialog("Something null, please check your input.");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
