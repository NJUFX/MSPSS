package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.userblservice.UserBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import main.StageSingleton;
import ui.common.Dialog;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class UserModifyViewController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();

    static String id_to_modify;
    static UserVO user_to_modify;

    public void setApp(MainApp application) {
        this.application = application;
    }

    Stage stage = StageSingleton.getStage();

    /**
     * 确定按钮
     */
    @FXML
    Button sureButton;
    /**
     * 身份的下拉框
     */
    @FXML
    public ComboBox<String> userCategory, userLevel;

    @FXML
    Label nameLabel, cateLabel, idLabel;

    /**
     * 用户id
     */
    @FXML
    public Label userId, userName;

    @FXML
    public void userCategoryAction(ActionEvent e) {
        ObservableList<String> options = FXCollections.observableArrayList();
        userLevel.setItems(options);
        if (userCategory.getValue().equals("进货销售人员")) {
            userLevel.getItems().add("普通职员");
            userLevel.getItems().add("销售经理");
        } else if (userCategory.getValue().equals("财务人员")) {
            userLevel.getItems().add("普通职员");
            userLevel.getItems().add("财务经理");
        } else {
            userLevel.setVisible(false);
        }
        //userLevel.getItems().add("");
    }

    /**
     * @param e
     */
    @FXML
    public void sureButtonAction(ActionEvent e) {
        if (userCategory.getValue() == null) {
            dialog.errorInfoDialog("Something null, please check your input.");
        } else {
            boolean isSure = dialog.confirmDialog("Do you confirm to add this user?");
            if (isSure == true) {
                Kind_Of_Users kind_of_users = Kind_Of_Users.SystemManager;
                switch (userCategory.getValue()) {
                    case "库存管理人员":
                        kind_of_users = Kind_Of_Users.StockManager;
                        break;
                    case "进货销售人员":
                        if (userLevel.getValue() == null) {
                            dialog.errorInfoDialog("Something null, please check your input.");
                        } else if (userLevel.getValue().equals("普通职员")) {
                            kind_of_users = Kind_Of_Users.StockSeller;
                        } else {
                            kind_of_users = Kind_Of_Users.StockSellerManager;
                        }
                        break;
                    case "财务人员":
                        if (userLevel.getValue() == null) {
                            dialog.errorInfoDialog("Something null, please check your input.");
                        } else if (userLevel.getValue().equals("普通职员")) {
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

                UserVO userVo = new UserVO(user_to_modify.getID(), user_to_modify.getName(), kind_of_users, user_to_modify.getPassword());
                userBLService.updateUser(userVo);
                ResultMessage resultMessage = userBLService.addUser(userVo);
                if (resultMessage == ResultMessage.SUCCESS) {
                    dialog.infoDialog("Add the user successfully.");
                }
            }
        }
    }

    @FXML
    Button delUserButton;
    @FXML
    Button addUserButton;
    @FXML
    Button BackToLogin, cancelButton, beforeOperationButton;

    public void cancelButtonAction(ActionEvent e) {
        try {
            AdminMainViewController controller = (AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void beforeOperationButtonAction(ActionEvent e) {
        try {
            UserModifyFirstViewController controller = (UserModifyFirstViewController) replaceSceneContent("/view/admin/UserModifyFirstView.fxml");
            controller.idField.setText(id_to_modify);
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

        user_to_modify = userBLService.searchUserByID(id_to_modify);
        userId.setText(user_to_modify.getID());
        userName.setText(user_to_modify.getName());
        // userCategory.setValue();
    }
}
