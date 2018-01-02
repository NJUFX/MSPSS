package ui.adminui;

import auxiliary.UserTable;
import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.common.Dialog;
import util.Kind_Of_Users;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import com.sun.beans.util.Cache;

/**
 * author:jiang_chen
 * date:2017/12/25
 */
public class UserSearchShowViewController implements Initializable {
    static ArrayList<UserVO> arrayList = new ArrayList<>();
    static String keyType, keyword;
    static Kind_Of_Users kind_of_users;
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();

    @FXML
    Label nameLabel, cateLabel, idLabel;
    @FXML
    Button addUserButton;
    @FXML
    Button delUserButton;
    @FXML
    Button modUserButton, refreshButton;
    @FXML
    Button BackToLogin, backButton, delInTableButton, modInTableButton;
    @FXML
    TableView<UserTable> userTableTableView;
    @FXML
    TableColumn<UserTable, String> IdCol, NameCol, CategoryCol, PowerCol;
    @FXML
    TableColumn<UserTable, RadioButton> OperationCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameLabel.setText("姓名：" + LoginController.getCurrentUser().getName());
        cateLabel.setText("身份：" + LoginController.getCategory());
        idLabel.setText("编号：" + LoginController.getCurrentUser().getID());
        showTableView();
    }

    public void showTableView() {
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CategoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        PowerCol.setCellValueFactory(new PropertyValueFactory<>("Power"));
        OperationCol.setCellValueFactory(new PropertyValueFactory<>("Operation"));

        ObservableList<UserTable> data = userTableTableView.getItems();
        for (int i = 0; i < arrayList.size(); i++) {
            UserVO userVO = arrayList.get(i);
            String str = "";
            String power = "/";

            if (userVO.getCategory() == Kind_Of_Users.SystemManager) {
                str = "系统管理员";
            } else if (userVO.getCategory() == Kind_Of_Users.StockManager) {
                str = "库存管理人员";
            } else if (userVO.getCategory() == Kind_Of_Users.ChiefManager) {
                str = "总经理";
            } else if (userVO.getCategory() == Kind_Of_Users.StockSellerManager) {
                str = "进货销售人员";
                power = "销售经理";
            } else if (userVO.getCategory() == Kind_Of_Users.StockSeller) {
                str = "进货销售人员";
                power = "普通职员";
            } else if (userVO.getCategory() == Kind_Of_Users.FinancerManager) {
                power = "财务经理";
                str = "财务人员";
            } else if (userVO.getCategory() == Kind_Of_Users.Financer) {
                str = "财务人员";
                power = "普通职员";
            }

            UserTable userTable = new UserTable(userVO.getID(), userVO.getName(), str, power);
            data.add(userTable);
        }
    }

    @FXML
    public void refreshButtonAction(ActionEvent e) {
        if (keyType.equals("id")) {
            UserVO userVO = userBLService.searchUserByID(keyword);
            if (userVO != null) {
                arrayList.add(userVO);
            }
        } else {
            arrayList = userBLService.searchUserByKind(kind_of_users);
        }
        showTableView();
    }

    @FXML
    public void delInTableButtonAction(ActionEvent e) {
        ObservableList<UserTable> data = userTableTableView.getItems();
        boolean b = false;
        if (data.size() != 0) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getRadioButton().isSelected()) {
                    boolean b2 = dialog.infoDialog("Do you want to delete this user?");
                    if (b2 == true) {
                        data.remove(i);
                        b = true;
                        dialog.infoDialog("Delete user successfully.");
                    }
                }
            }
            if (b == false) {
                dialog.errorInfoDialog("You haven't choose an user.");
            }
        } else {
            dialog.errorInfoDialog("Nothing in the table.");
        }
    }

    @FXML
    public void modInTableButtonAction(ActionEvent e) {
        ObservableList<UserTable> data = userTableTableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRadioButton().isSelected()) {
                try {
                    UserInfoModifyViewController controller = (UserInfoModifyViewController) replaceAnotherSceneContent("/view/admin/UserInfoModifyView.fxml", 310, 355);
                    controller.idLabel.setText(data.get(i).getId());
                    controller.nameLabel.setText(data.get(i).getName());
                    controller.categoryBox.setText(getCategory(userBLService.searchUserByID(data.get(i).getId())));
                    controller.emailField.setText(userBLService.searchUserByID(data.get(i).getId()).getMail());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
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

    public String getCategory(UserVO currentUser) {
        if (currentUser.getCategory() == Kind_Of_Users.ChiefManager) {
            return "总经理";
        } else if (currentUser.getCategory() == Kind_Of_Users.Financer || currentUser.getCategory() == Kind_Of_Users.FinancerManager) {
            return "财务人员";
        } else if (currentUser.getCategory() == Kind_Of_Users.StockManager) {
            return "库存管理人员";
        } else if (currentUser.getCategory() == Kind_Of_Users.StockSeller || currentUser.getCategory() == Kind_Of_Users.StockSellerManager) {
            return "进货销售人员";
        } else if (currentUser.getCategory() == Kind_Of_Users.SystemManager) {
            return "系统管理员";
        }
        return "";
    }

    /**
     * @param fxml
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    private Initializable replaceAnotherSceneContent(String fxml, double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        newStage.setTitle("MSPSS");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }


}
