package ui.stockmanagerui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javax.xml.soap.Node;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.common.Dialog;
import util.ResultMessage;
import vo.CommodityVO;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityInfoModifyViewController implements Initializable {
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    String id_to_modify;
    @FXML
    Button sureButton;
    @FXML
    Button cancelButton;
    @FXML
    Label id;
    @FXML
    TextField name, type, purchasingPrice, sellingPrice, stockNumber, stockAlertNumber, recentPurchasingPrice,
            recentSellingPrice;
    @FXML
    ComboBox<String> category;

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        cancelButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        CommodityVO commodityVO = new CommodityVO(name.getText().trim(), category.getValue(), type.getText().trim(), id.getText(),
                Double.parseDouble(purchasingPrice.getText().trim()), Double.parseDouble(sellingPrice.getText().trim()), Double.parseDouble(recentPurchasingPrice.getText().trim()),
                Double.parseDouble(recentSellingPrice.getText().trim()), Integer.parseInt(stockNumber.getText().trim()), Integer.parseInt(stockAlertNumber.getText().trim()));
        commodityBLService.deleteCommodity(id_to_modify);
        ResultMessage resultMessage = commodityBLService.addCommodity(commodityVO);
        if (resultMessage == ResultMessage.SUCCESS) {
            dialog.infoDialog("Modify the commodity successfully.");
            sureButton.getScene().getWindow().hide();
            try {
                CommodityInfoShowViewController controller = (CommodityInfoShowViewController) replaceSceneContent(
                        "/view/stockmanager/CommodityInfoShow.fxml");
                controller.id_to_modify = id_to_modify;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CommodityVO commodityVO = commodityInfoService.getCommodity(id_to_modify);
        id.setText(commodityVO.getID());
        name.setText(commodityVO.getName());
        type.setText(commodityVO.getType());
        category.setValue(commodityVO.getClassificationName());
        purchasingPrice.setText(String.valueOf(commodityVO.getImportCost()));
        sellingPrice.setText(String.valueOf(commodityVO.getExportCost()));
        stockAlertNumber.setText(String.valueOf(commodityVO.getAlertNumber()));
        stockNumber.setText(String.valueOf(commodityVO.getNumberInStock()));
        recentPurchasingPrice.setText(String.valueOf(commodityVO.getLatestImportCost()));
        recentSellingPrice.setText(String.valueOf(commodityVO.getLatestExportCost()));
    }
}
