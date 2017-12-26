package ui.stockmanagerui;

import auxiliary.Presentation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/11
 */
public class PresentationCreateViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    @FXML
    Button overflowCreateButton;
    @FXML
    Button breakageCreateButton;
    @FXML
    Button alertCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button cancelButton;
    @FXML
    TableView<Presentation> presentationTable;
    @FXML
    TableColumn<Presentation, String> NameCol, IdCol, PriceCol, NumberCol, TotalCol, RemarkCol;
    @FXML
    TableColumn<Presentation, CheckBox> IsSelectCol;
    @FXML
    TextField nameField;// 商品名称
    @FXML
    Button chooseCommodityButton;// 选择商品的按钮
    @FXML
    Button addPresentationButton;// 添加一行的按钮
    @FXML
    Button delPresentationButton;// 删除一行的按钮
    @FXML
    Label idLabel;// 商品编号
    @FXML
    Label priceLabel;// 单价
    @FXML
    TextField numberField;// 数量
    @FXML
    Label totalLabel;// 总价
    @FXML
    TextField remarkField;// 备注

    public void showTableView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
        IsSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
    }

    @FXML
    public void chooseCommodityButton(ActionEvent e) {
        nameField.setText("Hot-dog");
        idLabel.setText("17-12-11-40");
        priceLabel.setText("21");
    }

    @FXML
    public void totalLabelAction(ActionEvent e) {
        if (priceLabel.getText() != null && numberField.getText() != null) {
            double t = Double.parseDouble(priceLabel.getText()) * Integer.parseInt(numberField.getText());
            totalLabel.setText(String.valueOf(t));
        }
        // totalLabel.setText("100");
    }

    /**
     * 向库存赠送单列表添加一条信息
     *
     * @param e
     */
    @FXML
    public void addPresentationButtonAction(ActionEvent e) {
        ObservableList<Presentation> data = presentationTable.getItems();
        if (nameField.getText() != null && idLabel.getText() != null && priceLabel.getText() != null
                && (numberField.getText() != null && !numberField.equals("0")) && totalLabel.getText() != null) {
            data.add(new Presentation(nameField.getText(), idLabel.getText(), priceLabel.getText(),
                    numberField.getText(), totalLabel.getText(), remarkField.getText()));
            nameField.setText("");
            idLabel.setText("");
            priceLabel.setText("");
            numberField.setText("");
            totalLabel.setText("");
            remarkField.setText("");
        } else {
            dialog.errorInfoDialog("Something null! Please check your input.");
        }
    }

    /**
     * 删除选中行元素
     *
     * @param e
     */
    @FXML
    public void delPresentationButtonAction(ActionEvent e) {
        ObservableList<Presentation> data = presentationTable.getItems();
        // System.out.println("test");
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIsSelected().isSelected()) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getIsSelected().isSelected()) {
                    data.remove(j);
                }
            }
        }
        dialog.infoDialog("Delete all selected successfully!");
    }

    /**
     * 返回上一界面（处理单据界面）
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void cancelButtonAction(ActionEvent e) throws IOException {
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存报溢单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void overflowCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            OverflowCreateViewController controller = (OverflowCreateViewController) replaceSceneContent(
                    "/view/stockmanager/OverflowCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存报损单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void breakageCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            BreakageCreateViewController controller = (BreakageCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BreakageCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存报警单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void alertCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            AlertCreateViewController controller = (AlertCreateViewController) replaceSceneContent(
                    "/view/stockmanager/AlertCreate.fxml");
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

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        showTableView();
    }

}
