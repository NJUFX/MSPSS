package ui.stockmanagerui;

import auxiliary.Breakage;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockManagerBillBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserBLService;
import exception.initclassexception.KeyColumnLostException;
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
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.ResultMessage;
import util.StockBillType;
import vo.StockBillItemVO;
import vo.StockBillVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * 库存报损单
 * author:Jiang_Chen
 * date:2017/12/12
 */
public class BreakageCreateViewController implements Initializable {
    static boolean isSaved = false;
    static StockBillVO savedStockBillVO;
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();
    StockManagerBillBLService stockManagerBillBLService = new BLFactoryImpl().getStockManagerBillBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    UserBLService userBLService = new BLFactoryImpl().getUserBLService();
    @FXML
    Button overflowCreateButton;
    @FXML
    Button alertCreateButton;
    @FXML
    Button presentationCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button cancelButton;
    @FXML
    Button sureButton, saveButton;

    @FXML
    TableView<Breakage> breakageTableView;
    @FXML
    TableColumn<Breakage, String> IdCol, NameCol, SystemNumberCol, RealNumberCol, RemarkCol;
    @FXML
    TableColumn<Breakage, CheckBox> SelectCol;// 删除一行的按钮
    @FXML
    Button addRowButton;//添加一行
    @FXML
    Button delSelectedButton;//删除选中行
    @FXML
    Button chooseCommodityButton;//选择商品
    @FXML
    TextField nameField, idField;

    @FXML
    Label systemStockLabel;
    @FXML
    TextField realStockField;
    @FXML
    TextField remarkField;

    Label priceLabel = new Label();

    public boolean isNumber(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void showTableView() {
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        SystemNumberCol.setCellValueFactory(new PropertyValueFactory<>("SystemNumber"));
        RealNumberCol.setCellValueFactory(new PropertyValueFactory<>("RealNumber"));
        SelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
    }

    @FXML
    public void saveButtonAction(ActionEvent e) {
        ArrayList<StockBillItemVO> list = new ArrayList<>();
        ObservableList<Breakage> data = breakageTableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            list.add(new StockBillItemVO(commodityInfoService.getCommodity(data.get(i).getId()), Integer.parseInt(data.get(i).getRealNumber())));
        }
        StockBillVO vo = new StockBillVO(StockBillType.Less, list, null, userBLService.searchUserByID(LoginController.getCurrentUser().getID()));
        vo.setItemVOS(list);
        try {
            ResultMessage resultMessage = stockManagerBillBLService.saveStockBill(vo);
            if (ResultMessage.SUCCESS == resultMessage) {
                dialog.infoDialog("Save bill successfully.");
                try {
                    BillCreateViewController controller = (BillCreateViewController) replaceSceneContent("/view/stockmanager/BillCreate.fxml");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } catch (KeyColumnLostException E) {
            System.out.print(E.getMessage());
        }

    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        ArrayList<StockBillItemVO> list = new ArrayList<>();
        String remark = "";
        ObservableList<Breakage> data = breakageTableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            list.add(new StockBillItemVO(commodityInfoService.getCommodity(data.get(i).getId()), Integer.parseInt(data.get(i).getRealNumber())));
            remark += data.get(i).getRemark() + '\n';
        }

        StockBillVO vo = new StockBillVO(StockBillType.Less, list, null, userBLService.searchUserByID(LoginController.getCurrentUser().getID()));
        vo.setCommentByManager(remark);
        vo.setItemVOS(list);
        try {
            ResultMessage re1 = stockManagerBillBLService.saveStockBill(vo);
            ResultMessage resultMessage = stockManagerBillBLService.commitStockBill(vo);
            if (ResultMessage.SUCCESS == resultMessage && ResultMessage.SUCCESS == re1) {
                dialog.infoDialog("Commit bill successfully.");
                try {
                    BillCreateViewController controller = (BillCreateViewController) replaceSceneContent("/view/stockmanager/BillCreate.fxml");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } catch (KeyColumnLostException E) {
            System.out.print(E.getMessage());
        }
    }

    /**
     * 删除选中行
     *
     * @param e
     */
    @FXML
    public void dealSelectedButtonAction(ActionEvent e) {
        ObservableList<Breakage> data = breakageTableView.getItems();
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
     * 添加一条信息
     *
     * @param e
     */
    @FXML
    public void addRowButtonAction(ActionEvent e) {
        ObservableList<Breakage> data = breakageTableView.getItems();
        if (nameField.getText() != null && idField.getText() != null && systemStockLabel.getText() != null) {
            if (isNumber(systemStockLabel.getText()) == false || isNumber(realStockField.getText()) == false) {
                dialog.errorInfoDialog("You input wrong number");
                return;
            }
            if (remarkField.getText() == null) {
                remarkField.setText("");
            }
            data.add(new Breakage(idField.getText(), nameField.getText(), systemStockLabel.getText(), realStockField.getText(),
                    remarkField.getText()));
            nameField.setText("");
            idField.setText("");
            systemStockLabel.setText("");
            realStockField.setText("");
            remarkField.setText("");
        } else {
            dialog.errorInfoDialog("Something null! Please check your input.");
        }
    }

    @FXML
    public void chooseCommodityButtonAction(ActionEvent e) {
        try {
            SelectClassOrCommodityViewController controller = (SelectClassOrCommodityViewController) replaceAnotherSceneContent(
                    "/view/stockmanager/SelectClassOrCommodity.fxml", 491, 376);
            controller.isSelectClass = false;
            controller.isStockBill = true;
            controller.commodityPriceLabel = priceLabel;
            controller.commodityNameField = nameField;
            controller.commodityIdField = idField;
            controller.systemStockLabel = systemStockLabel;
            //    systemStockLabel.setText(String.valueOf(commodityInfoService.getCommodity(idField.getText()).getNumberInStock()));

        } catch (Exception e1) {
            e1.printStackTrace();
        }
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
     * 库存赠送单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void presentationCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            PresentationCreateViewController controller = (PresentationCreateViewController) replaceSceneContent(
                    "/view/stockmanager/PresentationCreate.fxml");
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
        newStage.setTitle("选择");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

    public void init() {
        showTableView();
        if (isSaved == true) {
            ObservableList<Breakage> data = breakageTableView.getItems();
            ArrayList<StockBillItemVO> vos = savedStockBillVO.itemVOS;
            for (int i = 0; i < vos.size(); i++) {
                StockBillItemVO s = vos.get(i);
                Breakage breakage = new Breakage(s.commodityVO.getID(), s.commodityVO.getName(), String.valueOf(s.commodityVO.getNumberInStock()), String.valueOf(s.number), "");
                data.add(breakage);
            }
        }
    }

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        init();
    }

}
