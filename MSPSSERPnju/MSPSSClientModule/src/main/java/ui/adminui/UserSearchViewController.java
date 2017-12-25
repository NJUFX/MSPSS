package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blimpl.userblimpl.User;
import blservice.userblservice.UserBLService;
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
import ui.common.Dialog;
import util.Kind_Of_Users;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:jiang_chen
 * date:2017/12/25
 */
public class UserSearchViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameLabel.setText("姓名：" + LoginController.getCurrentUser().getName());
        cateLabel.setText("身份：" + LoginController.getCategory());
        idLabel.setText("编号：" + LoginController.getCurrentUser().getID());
    }

    UserBLService userBLService = new BLFactoryImpl().getUserBLService();

    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

    Stage stage = StageSingleton.getStage();

    @FXML
    Button addUserButton;
    @FXML
    Button delUserButton;
    @FXML
    Button modUserButton, searchButton;
    @FXML
    Button BackToLogin, backButton;
    @FXML
    Label nameLabel, cateLabel, idLabel;
    @FXML
    TextField keywordField;
    @FXML
    ComboBox<String> keyTypeBox, keywordBox;

    public void keyTypeBoxAction(ActionEvent e) {
        if (keyTypeBox.getValue().equals("身份")) {
            keywordField.setVisible(false);
            keywordBox.setVisible(true);
        } else {
            keywordBox.setVisible(false);
            keywordField.setVisible(true);
        }
    }

    public void searchButtonAction(ActionEvent e) {
        try {
            if (keyTypeBox.getValue() == null || keywordField.getText() == null) {
                dialog.errorInfoDialog("Something null, please check your input.");
            } else {
                ArrayList<UserVO> arrayList = new ArrayList<>();

                if (keyTypeBox.getValue().equals("编号")) {
                    UserVO userVO = userBLService.searchUserByID(keywordField.getText().trim());
                    arrayList.add(userVO);
                    UserSearchShowViewController.keyType = "id";
                    UserSearchShowViewController.keyword = keywordField.getText().trim();
                } else if (keyTypeBox.getValue().equals("身份")) {
                    UserSearchShowViewController.keyType = "Category";
                    UserSearchShowViewController.keyword = keywordBox.getValue();

                    Kind_Of_Users kind_of_users = Kind_Of_Users.SystemManager;
                    switch (keywordBox.getValue()) {
                        case "库存管理人员":
                            kind_of_users = Kind_Of_Users.StockManager;
                            break;
                        case "进货销售人员":
                            kind_of_users = Kind_Of_Users.StockSeller;
                            break;
                        case "销售经理":
                            kind_of_users = Kind_Of_Users.StockSellerManager;
                            break;
                        case "财务人员":
                            kind_of_users = Kind_Of_Users.Financer;
                            break;
                        case "财务经理":
                            kind_of_users = Kind_Of_Users.FinancerManager;
                            break;
                        case "总经理":
                            kind_of_users = Kind_Of_Users.ChiefManager;
                            break;
                        case "系统管理员":
                            kind_of_users = Kind_Of_Users.SystemManager;
                            break;
                    }
                    arrayList = userBLService.searchUserByKind(kind_of_users);
                    UserSearchShowViewController.kind_of_users = kind_of_users;
                    UserSearchShowViewController.arrayList = arrayList;
                }
                UserSearchShowViewController controller = (UserSearchShowViewController) replaceSceneContent(
                        "/view/admin/UserSearchShowView.fxml");
            }
        } catch (
                Exception e1)

        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public void backButtonAction(ActionEvent e) {
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
            LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    public void addUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserAddViewController controller = (UserAddViewController) replaceSceneContent(
                    "/view/admin/UserAddView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    public void delUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserDelViewController controller = (UserDelViewController) replaceSceneContent(
                    "/view/admin/UserDelView.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    public void modUserButtonAction(ActionEvent e) throws IOException {
        try {
            UserModifyFirstViewController controller = (UserModifyFirstViewController) replaceSceneContent(
                    "/view/admin/UserModifyFirstView.fxml");
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
        // InputStream in =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
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

}
