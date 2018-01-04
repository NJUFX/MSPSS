package ui.stockmanagerui;

import auxiliary.ClassificationCell;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.common.Dialog;
import util.ResultMessage;
import vo.CommodityVO;

import java.net.Inet4Address;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCommodityViewController implements Initializable {
    Dialog dialog = new Dialog();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
    static String name_of_commodity;
    TreeItem<ClassificationCell> treeItem;
    @FXML
    Button returnButton, sureButton;
    @FXML
    TextField name, type, stockNumber, alertNumber, outPrice, inPrice, recentInPrice, recentOutPrice;
    @FXML
    Label errorLabel, category;

    @FXML
    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        if (name.getText() != null && !name.getText().trim().equals("") &&
                type.getText() != null && !type.getText().trim().equals("") &&
                stockNumber.getText() != null && !stockNumber.getText().trim().equals("") &&
                alertNumber.getText() != null && !alertNumber.getText().trim().equals("") &&
                inPrice.getText() != null && !inPrice.getText().trim().equals("") &&
                outPrice.getText() != null && !outPrice.getText().trim().equals("") &&
                recentInPrice.getText() != null && !recentInPrice.getText().trim().equals("") &&
                recentOutPrice.getText() != null && !recentOutPrice.getText().trim().equals("")) {

            ImageView imageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/lamp.png")));
            imageView.setFitWidth(15);
            imageView.setFitHeight(15);

            name_of_commodity = name.getText().trim();
            String str = treeItem.getValue().getName();
            CommodityVO commodityVO = new CommodityVO(name.getText().trim(), null, type.getText().trim(), Double.parseDouble(inPrice.getText().trim()), Double.parseDouble(outPrice.getText().trim()), Integer.parseInt(stockNumber.getText().trim()));
            commodityVO.setLatestImportCost(Double.parseDouble(recentInPrice.getText().trim()));
            commodityVO.setLatestExportCost(Double.parseDouble(recentOutPrice.getText().trim()));
            commodityVO.setAlertNumber(Integer.parseInt(alertNumber.getText().trim()));
            commodityVO.setClassificationName(treeItem.getValue().getId());
            ResultMessage resultMessage = commodityBLService.addCommodity(commodityVO);
            System.out.println(commodityVO.getID());
            if (resultMessage == ResultMessage.SUCCESS) {
                TreeItem<ClassificationCell> newItem = new TreeItem<>(new ClassificationCell(name_of_commodity, str, commodityVO.getID(), false), imageView);
                treeItem.getChildren().add(newItem);
                dialog.infoDialog("Add a commodity successfully.");

            }
            sureButton.getScene().getWindow().hide();
        } else {
            errorLabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setVisible(false);
    }
}
