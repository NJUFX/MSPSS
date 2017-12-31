package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserBLService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.common.Dialog;
import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.ResultMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class UserDelViewController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    MainBLService mainBLService = new BLFactoryImpl().getMainBLService();

    public void setApp(MainApp application) {
        this.application = application;
    }

    Stage stage = StageSingleton.getStage();

    @FXML
    Label nameLabel, cateLabel, idLabel;
    @FXML
    Button sureDeleteButton;
    @FXML
    Button cancelButton;
    @FXML
    TextField id_to_del;
    @FXML
    Button BackToLogin;
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

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        try {
            AdminMainViewController controller = (AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

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
    public void sureDeleteButtonAction(ActionEvent e) {
        if (id_to_del.getText() == null || id_to_del.getText().trim().equals("")) {
            dialog.errorInfoDialog("Please input the id of user you want to delete.");
        } else {
            boolean b = dialog.confirmDialog("Do you confirm to delete this user?");
            if (b == true) {
                ResultMessage resultMessage = userBLService.deleteUser(id_to_del.getText().trim());
                if (resultMessage == ResultMessage.SUCCESS) {
                    dialog.infoDialog("Delete the user successfully.");
                } else if (resultMessage == ResultMessage.NOT_EXIST) {
                    dialog.errorInfoDialog("User not exist!");
                }
            }
        }
    }

    @FXML
    Button addUserButton;

    @FXML
    Button modUserButton;


    @FXML
    public void addUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserAddViewController controller = (UserAddViewController) replaceSceneContent("/view/admin/UserAddView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void modUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserModifyFirstViewController controller = (UserModifyFirstViewController) replaceSceneContent("/view/admin/UserModifyFirstView.fxml");
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
