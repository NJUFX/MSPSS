package ui.stockmanagerui;

import auxiliary.CommodityTable;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.mainblservice.MainBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.ResultMessage;
import vo.CommodityVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityInfoShowViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    Dialog dialog = new Dialog();
    Stage newStage = new Stage();
    String id_to_modify;
    private CommodityTable commodityTable;

    public void setCommodityTable(CommodityTable commodityTable) {
        this.commodityTable = commodityTable;
    }

    @FXML
    Button BackToLogin;
    @FXML
    Button commodityAddButton;
    @FXML
    Button commodityDelButton;
    @FXML
    Button commodityModButton;
    @FXML
    Button commoditySearchButton;
    @FXML
    Button backButton;
    @FXML
    Button delButton;
    @FXML
    Button modButton;

    @FXML
    Label name, id, type, category, purchasingPrice, sellingPrice, stockNumber, stockAlertNumber, recentPurchasingPrice,
            recentSellingPrice;
    // 名称，编号，型号，分类，进价，售价，库存数量，库存警戒值


    /**
     * 删除当前的商品，返回商品列表
     *
     * @param e
     */
    @FXML
    public void delButtonAction(ActionEvent e) {
        try {

            ResultMessage resultMessage = commodityBLService.deleteCommodity(id_to_modify);
            if (resultMessage == ResultMessage.SUCCESS) {
                CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
                        "/view/stockmanager/CommoditySearchShow.fxml");
                controller.refreshButtonAction();
                dialog.infoDialog("Delete the commodity successfully.");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 修改商品按钮跳转
     *
     * @param e
     */
    @FXML
    public void modButtonAction(ActionEvent e) {
        try {
            CommodityInfoModifyViewController controller = (CommodityInfoModifyViewController) replaceAnotherSceneContent(
                    "/view/stockmanager/CommodityInfoModify.fxml", 415, 421);

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
            CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
                    "/view/stockmanager/commoditySearchShow.fxml");
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
     * 修改商品
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
     * 查找商品
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commoditySearchButtonAction(ActionEvent e) throws IOException {
        try {
            CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
                    "/view/stockmanager/commoditySearchShow.fxml");
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
        return (Initializable) loader.getController();
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

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());

        CommodityVO commodityVO = commodityInfoService.getCommodity(id_to_modify);
        id.setText(commodityVO.getID());
        name.setText(commodityVO.getName());
        type.setText(commodityVO.getType());
        category.setText(commodityVO.getClassificationName());
        purchasingPrice.setText(String.valueOf(commodityVO.getImportCost()));
        sellingPrice.setText(String.valueOf(commodityVO.getExportCost()));
        stockAlertNumber.setText(String.valueOf(commodityVO.getAlertNumber()));
        stockNumber.setText(String.valueOf(commodityVO.getNumberInStock()));
        recentPurchasingPrice.setText(String.valueOf(commodityVO.getLatestImportCost()));
        recentSellingPrice.setText(String.valueOf(commodityVO.getLatestExportCost()));
    }

}
