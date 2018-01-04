package ui.stocksellerui;

import blimpl.blfactory.BLFactoryImpl;
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
import util.Kind_Of_Customers;
import vo.CustomerVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerInfoShowViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    Stage newStage = new Stage();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
     //fixme
    static String id_to_show;
    static CustomerVO customerVO;
    @FXML
    Button CustomerAddButton;
    @FXML
    Button CustomerDelButton;
    @FXML
    Button CustomerModButton;
    @FXML
    Button CustomerSearchButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button delButton;
    @FXML
    Button modButton, backButton;
    @FXML
    Label nameLabel, phoneLabel, addressLabel, postcodeLabel, emailLabel, inValueLabel,
            incomemoneyLabel, paymoneyLabel, categoryLabel, levelLabel, idLabel, workerLabel;

    /**
     * 删除当前的商品，返回商品列表
     *
     * @param e
     */
    @FXML
    public void delButtonAction(ActionEvent e) {
        try {
            CustomerSearchShowViewController controller = (CustomerSearchShowViewController) replaceSceneContent(
                    "/view/stockseller/CustomerSearchShow.fxml");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        dialog.infoDialog("Delete the customer successfully.");
    }

    /**
     * 修改商品按钮跳转
     *
     * @param e
     */
    @FXML
    public void modButtonAction(ActionEvent e) {
        try {
            System.out.println("test");
            CustomerInfoModifyViewController controller = (CustomerInfoModifyViewController) replaceAnotherSceneContent(
                    "/view/stockseller/CustomerInfoModify.fxml", 415, 421);
            controller.customerVO = customerVO;
        } catch (Exception e1) {
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
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerSearchShowViewController controller = (CustomerSearchShowViewController) replaceSceneContent(
                    "/view/stockseller/customerSearchShow.fxml");
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
        Scene scene = new Scene(page, 900.00, 560);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

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
        Scene scene = new Scene(page, width, height + 0);
        newStage.setTitle("MSPSS");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份" + LoginController.getCategory());
        if (id_to_show != null && !id_to_show.trim().equals("")) {

            idLabel.setText(customerVO.getID());
            nameLabel.setText(customerVO.getName());
            phoneLabel.setText(customerVO.getPhonenumber());
            addressLabel.setText(customerVO.getAddress());
            postcodeLabel.setText(customerVO.getPostcode());
            emailLabel.setText(customerVO.getEmail());
            inValueLabel.setText(String.valueOf(customerVO.getInvalue()));
            incomemoneyLabel.setText(String.valueOf(customerVO.getIncomemoney()));
            paymoneyLabel.setText(String.valueOf(customerVO.getPaymoney()));
            String category = "进货商";
            if (customerVO.getCategory() == Kind_Of_Customers.SALER) {
                category = "销售商";
            }
            categoryLabel.setText(category);
            levelLabel.setText(String.valueOf(customerVO.getLevel()));
            workerLabel.setText(customerVO.getDAE());
        }
    }
}