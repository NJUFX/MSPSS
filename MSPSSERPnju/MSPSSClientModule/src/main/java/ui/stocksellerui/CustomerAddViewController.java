package ui.stocksellerui;

import blimpl.blfactory.BLFactoryImpl;
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
import util.Kind_Of_Customers;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.CustomerVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerAddViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    Dialog dialog = new Dialog();

    @FXML
    Button delCustomerButton;

    @FXML
    Button modCustomerButton;

    @FXML
    Button searchCustomerButton;
    @FXML
    Button cancelButton;
    @FXML
    Button BackToLogin, sureButton;

    @FXML
    TextField nameField, phoneField, addressField, postcodeField, emailField, inValueField;
    @FXML
    ComboBox<String> categoryBox, levelBox;

    @FXML
    Label idLabel, workerLabel,incomemoneyField, paymoneyField;

    @FXML
    public void sureButtonAction(ActionEvent e) {
        Kind_Of_Customers kind_of_customers;
        if (categoryBox.getValue() != null && !categoryBox.getValue().trim().equals("")) {
            String kind = categoryBox.getValue();
            if (kind.equals("进货商")) {
                kind_of_customers = Kind_Of_Customers.SUPPLIER;
            } else {
                kind_of_customers = Kind_Of_Customers.SALER;
            }
            if (levelBox.getValue() != null && !levelBox.getValue().trim().equals("") &&
                    nameField.getText() != null && !nameField.getText().trim().equals("") &&
                    phoneField.getText() != null && !phoneField.getText().trim().equals("") &&
                    addressField.getText() != null && !addressField.getText().trim().equals("") &&
                    postcodeField.getText() != null && !postcodeField.getText().trim().equals("") &&
                    emailField.getText() != null && !emailField.getText().trim().equals("") &&
                    inValueField.getText() != null && !inValueField.getText().trim().equals("") &&
                    incomemoneyField.getText() != null && !incomemoneyField.getText().equals("") &&
                    paymoneyField.getText() != null && !paymoneyField.getText().trim().equals("")) {
                CustomerVO customerVO = new CustomerVO("", kind_of_customers, Integer.valueOf(levelBox.getValue()), nameField.getText().trim(), phoneField.getText().trim(),
                        addressField.getText().trim(), postcodeField.getText().trim(), emailField.getText().trim(), Double.parseDouble(inValueField.getText().trim()), Double.parseDouble(incomemoneyField.getText().trim()),
                        Double.parseDouble(paymoneyField.getText().trim()), workerLabel.getText().trim());
                ResultMessage resultMessage = customerBLService.addCustomer(customerVO);
                if (resultMessage == ResultMessage.SUCCESS) {
                    dialog.infoDialog("Add a customer successfully.");
                } else {
                    dialog.infoDialog("Fail to add the customer");
                }
            } else {
                dialog.errorInfoDialog("Something null, please check your input.");
            }
        } else {
            dialog.errorInfoDialog("Please choose category.");
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
     * 修改客户属性
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerModifyButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerModifyFirstViewController controller = (CustomerModifyFirstViewController) replaceSceneContent(
                    "/view/stockseller/CustomerModifyFirst.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 查找客户的结果显示
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

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        workerLabel.setText(LoginController.getCurrentUser().getID());
    }

}
