package ui.stocksellerui;

import blimpl.blfactory.BLFactoryImpl;
import blimpl.customerblimpl.Customer;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
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
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.CustomerVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerModifySecondViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    Dialog dialog = new Dialog();
    static String id_to_modify;
    @FXML
    Button CustomerAddButton;
    @FXML
    Button CustomerDelButton;
    @FXML
    Button sureButton;
    @FXML
    Button CustomerSearchButton;
    @FXML
    Button backToBeforeButton;
    @FXML
    Button cancelButtonl;
    @FXML
    Button BackToLogin;

    @FXML
    TextField nameField, phoneField, addressField, postcodeField, emailField, inValueField;
    @FXML
    ComboBox<String> categoryBox, levelBox;
    @FXML
    Label idLabel, workerField, paymoneyField, incomemoneyField;

    /**
     * 确认修改
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void sureButtonAction(ActionEvent e) throws IOException {
        try {

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
            MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
            boolean b = dialog.confirmDialog("Do you want to logout?");
            if (b == true) {
                LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
                Log_In_Out_Status log_in_out_status = mainBLService.logout(idOfCurrentUser.getText());
                if (Log_In_Out_Status.Logout_Sucess == log_in_out_status) {
                    dialog.infoDialog("Logout successfully");
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void cancelButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent(
                    "/view/stockseller/CustomerManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backToBeforeButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerModifyFirstViewController controller = (CustomerModifyFirstViewController) replaceSceneContent(
                    "/view/stockseller/CustomerModifyFirst.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 增加客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerAddButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerAddViewController controller = (CustomerAddViewController) replaceSceneContent(
                    "/view/stockseller/CustomerAdd.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 删除客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerDelButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerDelViewController controller = (CustomerDelViewController) replaceSceneContent(
                    "/view/stockseller/CustomerDel.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    /**
     * 查找客户
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerSearchButtonAction(ActionEvent e) throws IOException {

        try {
            CustomerSearchViewController controller = (CustomerSearchViewController) replaceSceneContent(
                    "/view/stockseller/CustomerSearch.fxml");
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

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        System.out.println(id_to_modify);
        CustomerVO customerVO = customerBLInfo.getCustomerByID(id_to_modify);
        //CustomerVO customerVO = customerBLService.getCustomerInfo(id_to_modify);
        idLabel.setText(customerVO.getID());
        workerField.setText(customerVO.getDAE());
        paymoneyField.setText(String.valueOf(customerVO.getPaymoney()));
        incomemoneyField.setText(String.valueOf(customerVO.getIncomemoney()));
    }
}