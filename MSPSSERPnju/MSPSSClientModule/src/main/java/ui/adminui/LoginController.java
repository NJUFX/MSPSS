package ui.adminui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
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
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.chiefmanagerui.ChiefManagerMainViewController;
import ui.common.Dialog;
import ui.financemanagerui.FinanceManagerMainViewController;
import ui.stockmanagerui.StockManagerMainViewController;
import ui.stocksellerui.StockSellerMainViewController;
import util.Kind_Of_Users;
import vo.UserVO;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class LoginController implements Initializable {
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
    static UserVO currentUser = new UserVO("001", "test", Kind_Of_Users.ChiefManager, "123456");
    @FXML
    public Button loginButton, modPasswordButton;
    @FXML
    public TextField idText;
    @FXML
    public PasswordField passwordField;

    public void modPasswordButtonAction(ActionEvent e) {
        try {
            ModifyPasswordViewController controller = (ModifyPasswordViewController) replaceAnotherSceneContent("/view/admin/ModifyPassword.fxml", 296, 332, "修改密码");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static String getCategory() {
        if (currentUser.getCategory() == Kind_Of_Users.ChiefManager) {
            return "总经理";
        } else if (currentUser.getCategory() == Kind_Of_Users.Financer) {
            return "财务人员";
        } else if (currentUser.getCategory() == Kind_Of_Users.FinancerManager) {
            return "财务经理";
        } else if (currentUser.getCategory() == Kind_Of_Users.StockManager) {
            return "库存管理";
        } else if (currentUser.getCategory() == Kind_Of_Users.StockSeller) {
            return "进货销售";
        } else if (currentUser.getCategory() == Kind_Of_Users.StockSellerManager) {
            return "销售经理";
        } else if (currentUser.getCategory() == Kind_Of_Users.SystemManager) {
            return "系统管理";
        }
        return "";
    }

    public static UserVO getCurrentUser() {
        return currentUser;
    }

    @FXML
    public void loginButtonAction(ActionEvent e) {
        if (idText.getText() != null && !idText.getText().trim().equals("") && passwordField.getText() != null && !passwordField.getText().trim().equals("")) {
            String id = idText.getText();
            String password = passwordField.getText();
            //currentUser = userBLService.searchUserByID(id);
            //toStockSellerMain();
            userLogin(id, password);
        } else {
            dialog.errorInfoDialog("Something null, please check your input.");
        }

    }

    /**
     * 登陆
     *
     * @param id
     * @param password
     */
    public void userLogin(String id, String password) {

        Log_In_Out_Status log_in_out_status = mainBLService.login(id, password);
        if (log_in_out_status == Log_In_Out_Status.Login_Success_Admin) {
            currentUser = userBLService.searchUserByID(id);
            toAdminMain();
            dialog.infoDialog("Login Successfully.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_Success_Salesman) {
            currentUser = userBLService.searchUserByID(id);
            toStockSellerMain();
            dialog.infoDialog("Login Successfully.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_Success_StockManager) {
            currentUser = userBLService.searchUserByID(id);
            toStockManagerMain();
            dialog.infoDialog("Login Successfully.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_Success_Financer) {
            currentUser = userBLService.searchUserByID(id);
            toFinanceManagerMain();
            dialog.infoDialog("Login Successfully.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_Success_CheifManager) {
            currentUser = userBLService.searchUserByID(id);
            toChiefManagerMain();
            dialog.infoDialog("Login Successfully.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_IdNotExist) {
            dialog.errorInfoDialog("Id not exist, please check your input.");
        } else if (log_in_out_status == Log_In_Out_Status.Login_PasswordWrong) {
            dialog.errorInfoDialog("Password wrong, please input again.");
        }
    }

    /**
     * 跳转SY系统管理员主界面
     */
    public void toAdminMain() {
        try {
            AdminMainViewController main = (AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
            /// main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转SS进货销售主界面
     */
    public void toStockSellerMain() {
        try {
            StockSellerMainViewController main = (StockSellerMainViewController) replaceSceneContent(
                    "/view/stockseller/Main.fxml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转SM库存管理人员主界面
     */
    public void toStockManagerMain() {
        try {
            StockManagerMainViewController main = (StockManagerMainViewController) replaceSceneContent(
                    "/view/stockmanager/Main.fxml");
            // main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转FM库存管理人员主界面
     */
    public void toFinanceManagerMain() {
        try {
            FinanceManagerMainViewController main = (FinanceManagerMainViewController) replaceSceneContent(
                    "/view/financemanager/FinanceManagerMainView.fxml");
            // main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转CM总经理主界面
     */
    public void toChiefManagerMain() {
        try {
            ChiefManagerMainViewController main = (ChiefManagerMainViewController) replaceSceneContent(
                    "/view/chiefmanager/ChiefManagerMainView.fxml");
            // main.setApp(this);

        } catch (Exception e) {
            e.printStackTrace();
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

    private Initializable replaceAnotherSceneContent(String fxml, double width, double height, String title) throws Exception {
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
        newStage.setScene(scene);
        newStage.setTitle(title);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
}
