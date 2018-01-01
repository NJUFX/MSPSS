package ui.stockmanagerui;

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
import ui.adminui.LoginController;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen
 * date:2017/12/9
 */
public class CommoditySearchViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    @FXML
    Button BackToLogin;
    @FXML
    Button commodityDelButton;
    @FXML
    Button commodityAddButton;
    @FXML
    Button commodityModButton;
    @FXML
    Button backButton;
    @FXML
    ComboBox<String> keyTypeComboBox, classificationBox;
    @FXML
    TextField keywordField;
    @FXML
    Button searchButton;

    public void keyTypeComboBoxAction(ActionEvent e) {
        if (keyTypeComboBox.getValue().equals("商品分类")) {
            classificationBox.setVisible(true);
        } else {
            classificationBox.setVisible(false);
        }
    }

    /**
     * 查找
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commoditySearchButtonAction(ActionEvent e) throws IOException {
        try {
            String key_word = "", key_type = "";
            boolean b = true;
            if (keyTypeComboBox.getValue() != null && !keyTypeComboBox.getValue().trim().equals("")) {
                if (keyTypeComboBox.getValue().equals("分类")) {
                    if (classificationBox.getValue() != null && !classificationBox.getValue().trim().equals("")) {
                        key_word = classificationBox.getValue().trim();
                    } else if (keywordField.getText() != null && !keywordField.getText().trim().equals("")) {
                        key_word = keywordField.getText().trim();
                    } else {
                        dialog.errorInfoDialog("Please input keyword.");
                        b = false;
                    }
                } else {
                    if (keywordField.getText() != null && !keywordField.getText().trim().equals("")) {
                        key_word = (keywordField.getText().trim());
                    } else {
                        dialog.errorInfoDialog("Please input keyword.");
                        b = false;
                    }
                }
                key_type = (keyTypeComboBox.getTypeSelector());
            } else {
                dialog.errorInfoDialog("Please choose key type.");
                b = false;
            }
            if (b == true) {
                CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
                        "/view/stockmanager/commoditySearchShow.fxml");
                controller.setKeyword(key_word);
                controller.setKeyType(key_type);
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 返回商品管理界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityManageViewController controller = (CommodityManageViewController) replaceSceneContent(
                    "/view/stockmanager/commodityManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 删除商品
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityDelButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityDelViewController controller = (CommodityDelViewController) replaceSceneContent(
                    "/view/stockmanager/commodityDel.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 增加商品
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityAddButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityAddViewController controller = (CommodityAddViewController) replaceSceneContent(
                    "/view/stockmanager/commodityAdd.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 修改属性
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityModButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityModifyFirstViewController controller = (CommodityModifyFirstViewController) replaceSceneContent(
                    "/view/stockmanager/commodityModifyFirst.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 下一步
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void nextOperationButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityModitySecondViewController controller = (CommodityModitySecondViewController) replaceSceneContent(
                    "/view/stockmanager/commodityModifySecond.fxml");
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
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        classificationBox.setVisible(false);
    }

}
