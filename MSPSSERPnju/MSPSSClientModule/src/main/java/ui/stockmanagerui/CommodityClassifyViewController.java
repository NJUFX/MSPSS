package ui.stockmanagerui;

import auxiliary.ClassificationCell;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityClassifyViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
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
        ClassificationCell rootCell = new ClassificationCell("Root", "");
        ClassificationCell commodityCell = new ClassificationCell("Commodity", "");
        TreeItem<String> root = new TreeItem<>(commodityCell.getName(), rootIcon);
        //root.getChildren().add(new TreeItem<>(commodityCell.getName(), rootIcon));
        for (int i = 1; i <= 5; i++) {
            ImageView iconView = new ImageView(
                    new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
            iconView.setFitHeight(15);
            iconView.setFitWidth(15);
            ClassificationCell cell = new ClassificationCell("Commodity" + i, rootCell.getName());
            //root.getChildren().get(0).getChildren().add(new TreeItem<>(cell.getName(), iconView));
            root.getChildren().add(new TreeItem<>(cell.getName(), iconView));
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                ImageView commodityImageView = new ImageView(
                        new Image(getClass().getResourceAsStream("/image/stockmanager/商品分类root.png")));
                commodityImageView.setFitWidth(15);
                commodityImageView.setFitHeight(15);
                ClassificationCell cell = new ClassificationCell("Commodity" + i + "." + j,
                        root.getChildren().get(i - 1).getValue());
                TreeItem<String> treeItem = root.getChildren().get(i - 1);
                //root.getChildren().get(0).getChildren().get(i - 1).getChildren().add(new TreeItem<>(cell.getName(), commodityImageView));
                treeItem.getChildren().add(new TreeItem<>(cell.getName(), commodityImageView));
            }
        }
        commodityClassification.setRoot(root);
        commodityClassification.setEditable(true);
        commodityClassification.setCellFactory((TreeView<String> p) -> new TextFieldTreeCellImpl());
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.showTreeView();
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
            });
            modMenuItem.setOnAction((ActionEvent t) -> {
                startEdit();
            });
            delMenuItem.setOnAction(e -> {
                TreeItem selectItem = getTreeView().getSelectionModel().getSelectedItem();
                selectItem.getParent().getChildren().remove(selectItem);
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
