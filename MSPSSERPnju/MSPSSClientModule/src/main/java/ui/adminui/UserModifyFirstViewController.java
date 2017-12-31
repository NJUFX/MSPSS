package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class UserModifyFirstViewController implements Initializable {
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
    static String id_to_modify = "";
    /**
     *
     */
    @FXML
    Button nextOperationButton, cancelButton;

    @FXML
    TextField idField;
    @FXML
    Button searchUserButton;

    @FXML
    public void searchddUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserSearchViewController controller = (UserSearchViewController) replaceSceneContent(
                    "/view/admin/UserSearchView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * @param e
     */
    @FXML
    public void nextOperationButtonAction(ActionEvent e) {
        try {
            if (idField.getText() == null || idField.getText().trim().equals("")) {
                dialog.errorInfoDialog("Please input the id of user your want to modify.");
            } else {
                id_to_modify = idField.getText().trim();
                UserModifyViewController.id_to_modify = id_to_modify;
                UserModifyViewController controller = (UserModifyViewController) replaceSceneContent("/view/admin/UserModifyView.fxml");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        try {
            AdminMainViewController controller = (AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    Button delUserButton;
    @FXML
    Button addUserButton;
    @FXML
    Button BackToLogin;
    @FXML
    Label nameLabel, cateLabel, idLabel;


    /**
     * 返回登录界面
     *
     * @param e
     * @throws IOException
     */
    public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
        try {
            boolean b = dialog.confirmDialog("Do you want to logout?");
            if (b == true) {
                LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
                Log_In_Out_Status log_in_out_status = mainBLService.logout(idLabel.getText());
                if (Log_In_Out_Status.Logout_Sucess == log_in_out_status) {
                    dialog.infoDialog("Logout successfully");
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    public void addUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserAddViewController controller = (UserAddViewController) replaceSceneContent("/view/admin/UserAddView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void delUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserDelViewController controller = (UserDelViewController) replaceSceneContent("/view/admin/UserDelView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    /**
     * 用来打开fxml文件
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        nameLabel.setText("姓名：" + LoginController.getCurrentUser().getName());
        cateLabel.setText("身份：" + LoginController.getCategory());
        idLabel.setText("编号：" + LoginController.getCurrentUser().getID());
    }
}
