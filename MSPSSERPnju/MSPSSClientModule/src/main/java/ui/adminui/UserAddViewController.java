package ui.adminui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;

import java.util.Optional;


public class UserAddViewController {
    Dialog dialog = new Dialog();
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


}
