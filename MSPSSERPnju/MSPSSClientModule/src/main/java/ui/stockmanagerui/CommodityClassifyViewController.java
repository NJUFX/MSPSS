package ui.stockmanagerui;

import auxiliary.ClassificationCell;
import blimpl.blfactory.BLFactoryImpl;
import blimpl.commodityblimpl.Classification;
import blservice.commodityblservice.CommodityBLService;
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
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.ResultMessage;
import vo.ClassificationVO;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityClassifyViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
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
    Button stockCheckButton;
    @FXML
    TreeView<String> commodityClassification;// 商品分类

    public void showTreeView() {
        classImageView.setFitHeight(15);
        classImageView.setFitWidth(15);
        Node rootIcon = classImageView;

        ClassificationCell commodityCell = new ClassificationCell("Commodity", "");
        TreeItem<String> root = new TreeItem<>(commodityCell.getName(), rootIcon);//根分类

        /*
        if (commodityBLService.getRootClassifications() != null && commodityBLService.getRootClassifications().size() != 0) {
            addChildren(commodityBLService.getRootClassifications(), root);
        }*/

        commodityClassification.setRoot(root);
        commodityClassification.setEditable(true);
        commodityClassification.setCellFactory((TreeView<String> p) -> new TextFieldTreeCellImpl());
    }

    public void addChildren(ArrayList<ClassificationVO> list, TreeItem<String> treeItem) {
        for (int i = 0; i < list.size(); i++) {
            ClassificationVO childrenVO = list.get(i);
            ImageView commodityImageView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            commodityImageView.setFitWidth(15);
            commodityImageView.setFitHeight(15);
            treeItem.getChildren().add(new TreeItem<>(childrenVO.getName(), commodityImageView));
            for (int z = 0; z < treeItem.getChildren().size(); z++) {
                if (treeItem.getChildren().get(z).getValue().equals(childrenVO.getName())) {
                    TreeItem<String> childrenItem = treeItem.getChildren().get(z);
                    addChildren(commodityBLService.getChildrenClassification(childrenVO), childrenItem);
                }
            }
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
                    "/view/stockmanager/commodityManage.fxml");
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
            StockCheckViewController controller = (StockCheckViewController) replaceSceneContent(
                    "/view/stockmanager/StockCheck.fxml");
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
            LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
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

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        showTreeView();
    }


    private final class TextFieldTreeCellImpl extends TreeCell<String> {

        private TextField textField;
        private final ContextMenu Menu = new ContextMenu();

        public TextFieldTreeCellImpl() {
            MenuItem addMenuItem = new MenuItem("增加分类");
            MenuItem modMenuItem = new MenuItem("修改分类");
            MenuItem delMenuItem = new MenuItem("删除分类");
            Menu.getItems().add(addMenuItem);
            Menu.getItems().add(modMenuItem);
            Menu.getItems().add(delMenuItem);
            addMenuItem.setOnAction((ActionEvent t) -> {
                ImageView imageView = new ImageView(
                        new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
                imageView.setFitWidth(15);
                imageView.setFitHeight(15);
                TreeItem newItem = new TreeItem<>("New Class", imageView);
                getTreeItem().getChildren().add(newItem);
                ClassificationVO father = new ClassificationVO(getTreeItem().getValue().toString());
                ClassificationVO classificationVO = new ClassificationVO(newItem.getValue().toString(), father);
                ResultMessage resultMessage = commodityBLService.addClassification(classificationVO);
                if (resultMessage == ResultMessage.SUCCESS) {
                    dialog.infoDialog("Add a classification successfully.");
                }

            });
            modMenuItem.setOnAction((ActionEvent t) -> {
                String id = getTreeItem().getValue();
                String fatherID = getTreeItem().getParent().getValue();
                ClassificationVO fatherVo = new ClassificationVO(fatherID);
                startEdit();
                commodityBLService.deleteClassification(id);
                ClassificationVO children = new ClassificationVO(getTreeItem().getValue().toString(), fatherVo);
                ResultMessage resultMessage = commodityBLService.addClassification(children);
                if (ResultMessage.SUCCESS == resultMessage) {
                    dialog.infoDialog("Modify a classification successfully.");
                }
            });
            delMenuItem.setOnAction(e -> {
                TreeItem selectItem = getTreeView().getSelectionModel().getSelectedItem();
                selectItem.getParent().getChildren().remove(selectItem);
                if (commodityBLService.deleteClassification(selectItem.getValue().toString()) == ResultMessage.SUCCESS) {
                    dialog.infoDialog("Delete a classification successfully.");
                }
            });

        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item, boolean empty) {
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
                    if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
                        setContextMenu(Menu);
                    }
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased((javafx.scene.input.KeyEvent t) -> {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            });

        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}
