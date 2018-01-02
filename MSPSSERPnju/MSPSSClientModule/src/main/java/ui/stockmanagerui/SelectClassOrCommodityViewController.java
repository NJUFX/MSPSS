package ui.stockmanagerui;

import auxiliary.ClassificationCell;
import auxiliary.Presentation;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import ui.common.Dialog;
import vo.ClassificationVO;
import vo.CommodityVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * date:2018.1.1
 * author:Jiang_Chen
 * function:选择商品或分类
 */
public class SelectClassOrCommodityViewController implements Initializable {
    Dialog dialog = new Dialog();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();

    static String commodityId, commodityName, commodityPrice, classificationName, classificationId;
    static CommodityVO commodityVO;
    public ClassificationVO classificationVO;
    public TextField commodityNameField, classificationNameField, commodityIdField, commodityTypeField;
    public Label commodityPriceLabel;
    public boolean isSelectClass, useType = false;

    @FXML
    Button returnButton, sureButton;
    @FXML
    TreeView<ClassificationCell> commodityClassification;// 商品分类
    @FXML
    Label nameLabel, typeLabel;

    @FXML
    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        if (commodityClassification.getSelectionModel().getSelectedItem() != null) {
            TreeItem<ClassificationCell> selectItem = commodityClassification.getSelectionModel().getSelectedItem();
            if (isSelectClass == true) {
                if (selectItem.getValue().getIsClass()) {
                    dialog.errorInfoDialog("This is not a commodity.");
                } else {
                    commodityId = selectItem.getValue().getId();
                    commodityName = selectItem.getValue().getName();
                    //commodityVO = new CommodityVO(selectItem.getValue().getName(), "001", selectItem.getParent().getValue().getName(), 25, 38);
                    commodityVO = commodityInfoService.getCommodity(commodityId);
                    commodityPrice = String.valueOf(commodityVO.getExportCost());
                    commodityIdField.setText(commodityId);
                    commodityNameField.setText(commodityName);
                    commodityPriceLabel.setText(commodityPrice);
                    if (useType == true) {
                        commodityTypeField.setText(commodityVO.getType());
                    }
                    sureButton.getScene().getWindow().hide();
                }
            } else {
                if (selectItem.getValue().getIsClass() == false) {
                    dialog.errorInfoDialog("This is not a classification.");
                } else {
                    if (selectItem.getChildren() != null && selectItem.getChildren().get(0).getValue().getIsClass() == true) {
                        dialog.errorInfoDialog("Unable to add a commodity in this classification.");
                    } else {
                        classificationName = selectItem.getValue().getName();
                        classificationNameField.setText(classificationName);
                        classificationId = selectItem.getValue().getId();
                        //classificationVO = commodityBLService.getClassification(classificationId);
                        sureButton.getScene().getWindow().hide();
                    }
                }
            }
        } else {
            dialog.errorInfoDialog("Nothing selected.");
        }
    }


    public void showTreeView() {
        ImageView classImageView = new ImageView(
                new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
        classImageView.setFitHeight(15);
        classImageView.setFitWidth(15);
        Node rootIcon = classImageView;

        ClassificationCell commodityCell = new ClassificationCell("Root", "Root", "001", true);
        TreeItem<ClassificationCell> root = new TreeItem<>(commodityCell, rootIcon);//根分类

/*
        if (commodityBLService.getRootClassifications() != null && commodityBLService.getRootClassifications().size() != 0) {
            addChildren(commodityBLService.getRootClassifications(), root);
        }*/

        /**
         * 测试用
         */
        for (int i = 0; i < 5; i++) {
            ImageView commodityImageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            commodityImageView.setFitWidth(15);
            commodityImageView.setFitHeight(15);
            ClassificationCell cell = new ClassificationCell("class" + (i + 1), root.getValue().getName(), "001" + (i + 1), true);
            root.getChildren().add(new TreeItem<>(cell, commodityImageView));
            TreeItem<ClassificationCell> child = root.getChildren().get(i);
            for (int j = 0; j < 5; j++) {
                ClassificationCell commodity = new ClassificationCell("Commodity" + (i + 1) + "." + (j + 1), child.getValue().getName(), "001" + (i + 1) + (j + 1), false);
                ImageView imageView = new ImageView(
                        new Image(getClass().getResourceAsStream("/image/stockmanager/lamp.png")));
                imageView.setFitWidth(15);
                imageView.setFitHeight(15);
                child.getChildren().add(new TreeItem<>(commodity, imageView));
            }
        }

        commodityClassification.setRoot(root);
        commodityClassification.setEditable(true);
        commodityClassification.setCellFactory((TreeView<ClassificationCell> p) -> {
            TreeCell<ClassificationCell> cell = new TreeCell<ClassificationCell>() {
                @Override
                public void updateItem(ClassificationCell item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.getName());
                        setGraphic(getTreeItem().getGraphic());
                    }
                }

                @Override
                public void startEdit() {
                    super.startEdit();
                    if (getItem() != null) {
                        nameLabel.setText(getItem().getName());
                    }
                    if (getItem().getIsClass()) {
                        typeLabel.setText("分类");
                    } else {
                        typeLabel.setText("商品");
                    }
                }

            };
            return cell;
        });

        //commodityClassification.setCellFactory((TreeView<ClassificationCell> p) -> new CommodityClassifyViewController.TextFieldTreeCellImpl());
    }

    public void addChildren(ArrayList<ClassificationVO> list, TreeItem<ClassificationCell> treeItem) {
        for (int i = 0; i < list.size(); i++) {
            ClassificationVO childrenVO = list.get(i);
            ImageView commodityImageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            commodityImageView.setFitWidth(15);
            commodityImageView.setFitHeight(15);

            treeItem.getChildren().add(new TreeItem<>(new ClassificationCell(childrenVO.getName(), treeItem.getValue().getName(), childrenVO.getID(), true), commodityImageView));
            for (int z = 0; z < treeItem.getChildren().size(); z++) {
                if (treeItem.getChildren().get(z).getValue().getName().equals(childrenVO.getName())) {
                    TreeItem<ClassificationCell> childrenItem = treeItem.getChildren().get(z);
                    if (commodityBLService.getChildrenClassification(childrenVO) != null) {
                        addChildren(commodityBLService.getChildrenClassification(childrenVO), childrenItem);
                    } else if (commodityBLService.getChildrenCommodity(childrenVO) != null) {
                        addCommodity(commodityBLService.getChildrenCommodity(childrenVO), childrenItem);
                    }
                }
            }
        }
    }

    public void addCommodity(ArrayList<CommodityVO> list, TreeItem<ClassificationCell> treeItem) {
        for (int i = 0; i < list.size(); i++) {
            CommodityVO commodityVO = list.get(i);
            ImageView commodityImageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/lamp.png")));
            commodityImageView.setFitWidth(15);
            commodityImageView.setFitHeight(15);
            treeItem.getChildren().add(new TreeItem<>(new ClassificationCell(commodityVO.getName(), treeItem.getValue().getName(), commodityVO.getID(), false), commodityImageView));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTreeView();
    }
}
