package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.userblservice.UserBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.common.Dialog;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfoModifyViewController implements Initializable {
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    Dialog dialog = new Dialog();
    //static UserVO userVO;

    @FXML
    Label idLabel, nameLabel, powerBoxLabel, categoryBox;
    @FXML
    TextField emailField;
    @FXML
    ComboBox<String> powerBox;
    @FXML
    Button sureButton;
    @FXML
    Button cancelButton;

    @FXML
    public void categoryBoxAction(ActionEvent e) {
        ObservableList<String> options = FXCollections.observableArrayList();
        powerBox.setItems(options);
        if (categoryBox.getText().equals("进货销售人员")) {
            powerBoxLabel.setVisible(true);
            powerBox.setVisible(true);
            powerBox.getItems().add("普通职员");
            powerBox.getItems().add("销售经理");
        } else if (categoryBox.getText().equals("财务人员")) {
            powerBoxLabel.setVisible(true);
            powerBox.setVisible(true);
            powerBox.getItems().add("普通职员");
            powerBox.getItems().add("财务经理");
        } else {
            powerBox.setVisible(false);
            powerBoxLabel.setVisible(false);
        }
        //powerBox.getItems().add("");
    }

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        cancelButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        boolean isSure = dialog.confirmDialog("Do you confirm to modify this user?");
        if (isSure == true) {
            if (emailField.getText() == null || emailField.getText().trim().equals("")) {
                dialog.errorInfoDialog("You haven't input the email address");
                return;
            }
            Kind_Of_Users kind_of_users = Kind_Of_Users.SystemManager;
            switch (categoryBox.getText()) {
                case "库存管理人员":
                    kind_of_users = Kind_Of_Users.StockManager;
                    break;
                case "进货销售人员":
                    if (powerBox.getValue() == null) {
                        dialog.errorInfoDialog("Something null, please check your input.");
                    } else if (powerBox.getValue().equals("普通职员")) {
                        kind_of_users = Kind_Of_Users.StockSeller;
                    } else {
                        kind_of_users = Kind_Of_Users.StockSellerManager;
                    }
                    break;
                case "财务人员":
                    if (powerBox.getValue() == null) {
                        dialog.errorInfoDialog("Something null, please check your input.");
                    } else if (powerBox.getValue().equals("普通职员")) {
                        kind_of_users = Kind_Of_Users.Financer;
                    } else {
                        kind_of_users = Kind_Of_Users.FinancerManager;
                    }
                    break;
                case "总经理":
                    kind_of_users = Kind_Of_Users.ChiefManager;
                    break;
                case "系统管理员":
                    kind_of_users = Kind_Of_Users.SystemManager;
                    break;
            }
            UserVO userVO = userBLService.searchUserByID(idLabel.getText());
            UserVO userVo = new UserVO(userVO.getID(), userVO.getName(), kind_of_users, userVO.getPassword());
            userVo.setMail(emailField.getText().trim());
            ResultMessage resultMessage = userBLService.updateUser(userVo);
            if (resultMessage == ResultMessage.SUCCESS) {
                dialog.infoDialog("Modify the user successfully.");
            }
        }

        sureButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
