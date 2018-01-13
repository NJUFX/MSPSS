package ui.stockmanagerui;

import auxiliary.ClassificationCell;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.mainblservice.MainBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityClassifyViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();

    ImageView classImageView = new ImageView(
            new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));

    @FXML
    Button BackToLogin;
    @FXML
    Button billCreateButton;
    @FXML
    Button commodityManageButton;
    @FXML
    Button stockInventoryButton;
    @FXML
    Button stockCheckButton, modCommodityButton, delCommodityButton, modClassificationButton, delClassificationButton;
    @FXML
    TreeView<ClassificationCell> commodityClassification;// 商品分类
    @FXML
    TextField classNameField, nameField, stockField, alertField, inPriceField, outPriceField, typeField;
    @FXML
    Label idLabel, classIdLabel, classParentLabel;
    @FXML
    Pane classPane, commodityPane;


    public void showTreeView() {
        classImageView.setFitHeight(15);
        classImageView.setFitWidth(15);
        Node rootIcon = classImageView;

        ClassificationCell commodityCell = new ClassificationCell("Root", "Root", "001", true);
        TreeItem<ClassificationCell> root = new TreeItem<>(commodityCell, rootIcon);//根分类

        if (commodityBLService.getRootClassifications() != null && commodityBLService.getRootClassifications().size() != 0) {
            addChildren(commodityBLService.getRootClassifications(), root);
        }
        commodityClassification.setRoot(root);
        commodityClassification.setEditable(true);
        commodityClassification.setCellFactory((TreeView<ClassificationCell> p) -> new TextFieldTreeCellImpl());
    }

    public void addChildren(ArrayList<ClassificationVO> list, TreeItem<ClassificationCell> treeItem) {
        for (int i = 0; i < list.size(); i++) {
            ClassificationVO childrenVO = list.get(i);
            ImageView commodityImageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            commodityImageView.setFitHeight(15);
            commodityImageView.setFitWidth(15);
            treeItem.getChildren().add(new TreeItem<>(new ClassificationCell(childrenVO.getName(), treeItem.getValue().getName(), childrenVO.getID(), true), commodityImageView));
            for (int j = 0; j < treeItem.getChildren().size(); j++) {
                if (treeItem.getChildren().get(j).getValue().getName().trim().equals(childrenVO.getName())) {
                    TreeItem<ClassificationCell> childrenItem = treeItem.getChildren().get(j);
                    if (commodityBLService.getChildrenClassification(childrenVO) != null && commodityBLService.getChildrenClassification(childrenVO).size() != 0) {
                        addChildren(commodityBLService.getChildrenClassification(childrenVO), childrenItem);
                    }
                    if (commodityBLService.getChildrenCommodity(childrenVO) != null && commodityBLService.getChildrenCommodity(childrenVO).size() != 0) {
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
            treeItem.getChildren().add(new TreeItem<>(new ClassificationCell(commodityVO.getName(), treeItem.getValue().getName(), commodityVO.getID().trim(), false), commodityImageView));
        }
    }

    /**
     * 处理单据
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void billCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 商品管理
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityManageButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityManageViewController controller = (CommodityManageViewController) replaceSceneContent(
                    "/view/stockmanager/CommodityManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存查看
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void stockCheckButtonAction(ActionEvent e) throws IOException {
        try {
            StockCheckShowViewController controller = (StockCheckShowViewController) replaceSceneContent(
                    "/view/stockmanager/StockCheckShow.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存盘点
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void stockInventoryButtonAction(ActionEvent e) throws IOException {
        try {
            StockInventoryViewController controller = (StockInventoryViewController) replaceSceneContent(
                    "/view/stockmanager/StockInventory.fxml");
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
        Scene scene = new Scene(page, 900.0, 560);
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
        Scene scene = new Scene(page, width + 0.0, height);
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
        showTreeView();
    }


    private final class TextFieldTreeCellImpl extends TreeCell<ClassificationCell> {

        private TextField textField;
        private final ContextMenu Menu = new ContextMenu();

        MenuItem addMenuItem = new MenuItem("增加分类");
        MenuItem modMenuItem = new MenuItem("修改分类");
        MenuItem delMenuItem = new MenuItem("删除分类");
        MenuItem addComMenuItem = new MenuItem("增加商品");
        MenuItem delComMenuItem = new MenuItem("删除商品");
        MenuItem detailMenuItem = new MenuItem("查看详情");

        public void menuEdit(TreeItem<ClassificationCell> item) {
            //TreeItem<ClassificationCell> item = getTreeView().getSelectionModel().getSelectedItem();
            detailMenuItem.setVisible(true);
            if (item.getValue().getName().equals("Root")) {
                modMenuItem.setVisible(false);
                delMenuItem.setVisible(false);
                addComMenuItem.setVisible(false);
                delComMenuItem.setVisible(false);
                detailMenuItem.setVisible(false);
            } else {
                if (item.getValue().getIsClass() == false) {//该节点是商品
                    addMenuItem.setVisible(false);
                    modMenuItem.setVisible(false);
                    delMenuItem.setVisible(false);
                    addComMenuItem.setVisible(false);
                    delComMenuItem.setVisible(true);
                } else {//该节点是分类
                    addMenuItem.setVisible(false);
                    modMenuItem.setVisible(false);
                    delMenuItem.setVisible(false);
                    addComMenuItem.setVisible(false);
                    delComMenuItem.setVisible(false);
                    if (item.getChildren() == null || item.getChildren().size() == 0) {//该目录下为空，可以添加商品或者添加分类
                        addMenuItem.setVisible(true);
                        modMenuItem.setVisible(true);
                        delMenuItem.setVisible(true);
                        addComMenuItem.setVisible(true);
                    } else if (item.getChildren().get(0).getValue().getIsClass() == false) {//该目录下有商品
                        modMenuItem.setVisible(true);
                        delMenuItem.setVisible(true);
                        addComMenuItem.setVisible(true);
                    } else {//该目录下有分类
                        addMenuItem.setVisible(true);
                        modMenuItem.setVisible(true);
                        delMenuItem.setVisible(true);
                    }
                }
            }
        }

        public TextFieldTreeCellImpl() {
            Menu.getItems().add(addMenuItem);
            Menu.getItems().add(modMenuItem);
            Menu.getItems().add(delMenuItem);
            Menu.getItems().add(addComMenuItem);
            Menu.getItems().add(delComMenuItem);
            Menu.getItems().add(detailMenuItem);


            detailMenuItem.setOnAction((ActionEvent t) -> {
                TreeItem<ClassificationCell> item = getTreeView().getSelectionModel().getSelectedItem();
                if (item.getValue().getIsClass() == true) {
                    classPane.setVisible(true);
                    classNameField.setText(item.getValue().getName());
                    classIdLabel.setText(item.getValue().getId());
                    classParentLabel.setText(item.getValue().getParent());
                    commodityPane.setVisible(false);

                    /**
                     * 删除分类
                     */
                    delClassificationButton.setOnAction((ActionEvent at) -> {
                        boolean b = dialog.confirmDialog("Confirm to delete the classification?");
                        if (b == true) {
                            item.getParent().getChildren().remove(item);
                            if (commodityBLService.getChildrenCommodity(commodityBLService.getClassification(item.getValue().getId())).size() > 0
                                    || commodityBLService.getChildrenClassification(commodityBLService.getClassification(item.getValue().getId())).size() > 0) {
                                dialog.errorInfoDialog("Unable to delete this classification.");
                            } else {
                                ResultMessage resultMessage = commodityBLService.deleteClassification(item.getValue().getId());
                                if (resultMessage == ResultMessage.SUCCESS) {
                                    dialog.infoDialog("Delete the classification successfully.");
                                } else {
                                    dialog.errorInfoDialog("Fail to delete the classification.");
                                }
                            }
                        }
                    });

                    /**
                     * 修改分类
                     */
                    modClassificationButton.setOnAction((ActionEvent ev) -> {
                        boolean b = dialog.confirmDialog("Confirm to modify the classification?");
                        if (b == true) {
                            ClassificationCell cell = item.getValue();
                            ClassificationVO classificationVO = commodityBLService.getClassification(item.getValue().getId());
                            classificationVO.setName(classNameField.getText().trim());
                            if (!getTreeView().getSelectionModel().getSelectedItem().getValue().getParent().equals("Root")) {
                                classificationVO.setParent(commodityBLService.getClassification(item.getParent().getValue().getId()));
                            }
                            ResultMessage resultMessage = commodityBLService.updateClassification(classificationVO);
                            if (resultMessage == ResultMessage.SUCCESS) {
                                item.getValue().setName(classNameField.getText().trim());
                                dialog.infoDialog("Modify the classification successfully.");
                            } else {
                                dialog.errorInfoDialog("Fail to modify the classification.");
                            }
                        }
                    });

                } else {
                    commodityPane.setVisible(true);
                    classPane.setVisible(false);
                    idLabel.setText(item.getValue().getId());
                    CommodityVO commodityVO = commodityInfoService.getCommodity(idLabel.getText());
                    nameField.setText(item.getValue().getName());
                    stockField.setText(String.valueOf(commodityVO.getNumberInStock()));
                    typeField.setText(commodityVO.getType());
                    alertField.setText(String.valueOf(commodityVO.getAlertNumber()));
                    inPriceField.setText(String.valueOf(commodityVO.importCost));
                    outPriceField.setText(String.valueOf(commodityVO.exportCost));

                    /**
                     * 删除商品
                     */
                    delCommodityButton.setOnAction((ActionEvent at) -> {
                        boolean b = dialog.confirmDialog("Confirm to delete the commodity?");
                        if (b == true) {
                            int stock = commodityInfoService.getCommodity(item.getValue().getId()).getNumberInStock();
                            if (stock > 0) {
                                dialog.errorInfoDialog("该商品库存为" + stock + ", 你不能删除该商品");
                            } else {
                                ResultMessage resultMessage = commodityBLService.deleteCommodity(item.getValue().getId());
                                if (resultMessage == ResultMessage.SUCCESS) {
                                    item.getParent().getChildren().remove(item);
                                    dialog.infoDialog("Delete the commodity successfully.");
                                } else {
                                    dialog.errorInfoDialog("Fail to delete the commodity.");
                                }
                            }
                        }
                    });

                    /**
                     * 修改商品
                     */
                    modCommodityButton.setOnAction((ActionEvent ev) -> {
                        boolean b = dialog.confirmDialog("Confirm to modify the commodity?");
                        if (b == true) {
                            item.getValue().setName(nameField.getText().trim());
                            ClassificationCell cell = item.getValue();
                            //ResultMessage resultMessage = ResultMessage.SUCCESS;
                            //TODO

                            CommodityVO newCommodityVO = commodityInfoService.getCommodity(item.getValue().getId());
                            newCommodityVO.setName(nameField.getText().trim());
                            newCommodityVO.setAlertNumber(Integer.parseInt(alertField.getText().trim()));
                            newCommodityVO.setNumberInStock(Integer.parseInt(stockField.getText().trim()));
                            newCommodityVO.setLatestExportCost(Double.parseDouble(outPriceField.getText().trim()));
                            newCommodityVO.setLatestImportCost(Double.parseDouble(inPriceField.getText().trim()));
                            newCommodityVO.setClassificationName(item.getParent().getValue().getName());
                            System.out.println(newCommodityVO.getClassificationName());
                            newCommodityVO.setType(typeField.getText());
                            ResultMessage resultMessage = commodityBLService.updateCommodity(commodityVO);

                            if (resultMessage == ResultMessage.SUCCESS) {
                                dialog.infoDialog("Modify the commodity successfully.");
                            } else {
                                dialog.errorInfoDialog("Fail to modify the commodity.");
                            }
                        }
                    });
                }

            });

            addMenuItem.setOnAction((ActionEvent t) -> {
                ImageView imageView = new ImageView(
                        new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
                imageView.setFitWidth(15);
                imageView.setFitHeight(15);
                TreeItem<ClassificationCell> item = getTreeView().getSelectionModel().getSelectedItem();
                if (item.getValue().getIsClass() == true) {
                    try {
                        AddClassificationViewController controller = (AddClassificationViewController) replaceAnotherSceneContent(
                                "/view/stockmanager/AddClassification.fxml", 247, 124);
                        controller.treeItem = getTreeItem();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    dialog.errorInfoDialog("This isn't a classification.");
                }
            });

            modMenuItem.setOnAction((ActionEvent t) -> {
                TreeItem<ClassificationCell> item = getTreeView().getSelectionModel().getSelectedItem();
                if (item.getValue().getIsClass() != true) {
                    dialog.errorInfoDialog("This isn't a classification.");
                } else {
                    startEdit();
                }
            });

            delMenuItem.setOnAction(e -> {
                boolean b = dialog.confirmDialog("Confirm to delete the classification?");
                if (b == true) {
                    TreeItem<ClassificationCell> selectItem = getTreeView().getSelectionModel().getSelectedItem();
                    if (commodityBLService.getChildrenCommodity(commodityBLService.getClassification(selectItem.getValue().getId())).size() > 0
                            || commodityBLService.getChildrenClassification(commodityBLService.getClassification(selectItem.getValue().getId())).size() > 0) {
                        dialog.errorInfoDialog("Unable to delete this classification.");
                    } else {
                        if (commodityBLService.deleteClassification(selectItem.getValue().getId()) == ResultMessage.SUCCESS) {
                            selectItem.getParent().getChildren().remove(selectItem);
                            dialog.infoDialog("Delete a classification successfully.");
                        }
                    }
                }
            });

            addComMenuItem.setOnAction((ActionEvent t) -> {
                ImageView imageView = new ImageView(
                        new Image(getClass().getResourceAsStream("/image/stockmanager/lamp.png")));
                imageView.setFitWidth(15);
                imageView.setFitHeight(15);
                TreeItem<ClassificationCell> item = getTreeView().getSelectionModel().getSelectedItem();
                if (item.getValue().getIsClass() == true) {
                    try {
                        AddCommodityViewController.name_Of_class = getTreeItem().getValue().getName();
                        AddCommodityViewController controller = (AddCommodityViewController) replaceAnotherSceneContent(
                                "/view/stockmanager/AddCommodity.fxml", 266, 375);
                        controller.treeItem = getTreeItem();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    dialog.errorInfoDialog("This isn't a classification.");
                }
            });

            delComMenuItem.setOnAction(e -> {
                boolean b = dialog.confirmDialog("Confirm to delete the commodity?");
                if (b == true) {
                    TreeItem<ClassificationCell> selectItem = getTreeView().getSelectionModel().getSelectedItem();
                    int stock = commodityInfoService.getCommodity(selectItem.getValue().getId()).getNumberInStock();
                    if (stock > 0) {
                        dialog.errorInfoDialog("该商品库存为" + stock + ", 你不能删除该商品");
                    } else {
                        ResultMessage resultMessage = commodityBLService.deleteCommodity(selectItem.getValue().getId());
                        if (resultMessage == ResultMessage.SUCCESS) {
                            selectItem.getParent().getChildren().remove(selectItem);
                            dialog.infoDialog("Delete a commodity successfully.");
                        }
                    }
                }
            });
        }

        //@Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        //@Override
        public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem().getName());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(ClassificationCell item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                    setContextMenu(Menu);
                    menuEdit(getTreeItem());
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased((javafx.scene.input.KeyEvent t) -> {
                if (t.getCode() == KeyCode.ENTER) {
                    ClassificationVO classificationVO = commodityBLService.getClassification(getTreeView().getSelectionModel().getSelectedItem().getValue().getId());
                    classificationVO.setName(textField.getText().trim());
                    if (!getTreeView().getSelectionModel().getSelectedItem().getValue().getParent().equals("Root")) {
                        classificationVO.setParent(commodityBLService.getClassification(getTreeView().getSelectionModel().getSelectedItem().getParent().getValue().getId()) == null
                                ? null : commodityBLService.getClassification(getTreeView().getSelectionModel().getSelectedItem().getParent().getValue().getId()));
                    }
                    ResultMessage resultMessage = commodityBLService.updateClassification(classificationVO);
                    if (resultMessage == ResultMessage.SUCCESS) {
                        dialog.infoDialog("Modify classification successfully.");
                        commitEdit(new ClassificationCell(textField.getText().trim(), getItem().getParent(), classificationVO.getID(), true));
                    }
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            });

        }

        private String getString() {
            return getItem() == null ? "" : getItem().getName();
        }
    }
}
