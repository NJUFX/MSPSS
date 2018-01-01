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
import javafx.stage.Stage;
import main.StageSingleton;
import ui.common.Dialog;
import util.ResultMessage;
import vo.ClassificationVO;

import java.net.URL;
import java.util.ResourceBundle;

public class AddClassificationViewController implements Initializable {
    Dialog dialog = new Dialog();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
    Stage stage = StageSingleton.getStage();
    static String name_of_class;
    TreeItem<ClassificationCell> treeItem;
    @FXML
    Button returnButton, sureButton;
    @FXML
    TextField nameOfClass;
    @FXML
    Label errorLabel;

    @FXML
    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        if (nameOfClass.getText() != null && !nameOfClass.getText().trim().equals("")) {
            ImageView imageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            imageView.setFitWidth(15);
            imageView.setFitHeight(15);
            name_of_class = nameOfClass.getText().trim();
            String str;
            if (treeItem.getValue().getName().equals("Root")) {
                str = "Root";
            } else {
                str = treeItem.getValue().getName();
            }
            TreeItem<ClassificationCell> newItem = new TreeItem<>(new ClassificationCell(name_of_class, str, "aghogddggag", true), imageView);
            treeItem.getChildren().add(newItem);
            /*
            ClassificationVO father = new ClassificationVO(treeItem.getValue().toString());
            ClassificationVO classificationVO = new ClassificationVO(newItem.getValue().toString(), father);
            ResultMessage resultMessage = commodityBLService.addClassification(classificationVO);
            if (resultMessage == ResultMessage.SUCCESS) {
                dialog.infoDialog("Add a classification successfully.");
            }
            */
            dialog.infoDialog("Add a classification successfully.");
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
