package ui.stocksellerui;

import auxiliary.PurchaseBill;
import auxiliary.SalesInBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.SalesmanBillBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.userblservice.UserInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.common.Dialog;
import util.BillStatus;
import util.SalesInBillType;
import util.SalesOutBillType;
import vo.SalesInBillVO;
import vo.SalesItemVO;
import vo.SalesOutBillVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillDetailsShowViewController implements Initializable {

    static boolean isSalesIn = true;
    static SalesInBillVO salesInBillVO;
    static SalesOutBillVO salesOutBillVO;

    SalesmanBillBLService salesmanBillBLService = new BLFactoryImpl().getSalesmanBillBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();

    @FXML
    Button returnButton;
    @FXML
    Pane salesPane;
    @FXML
    Label billIdLabel, supplierLabel, DAELabel, stockLabel, chiefName, chiefTime, commitTime, billName, billStatus, billTotalMoney, billTotalMoney1, billTotalMoney11, billTotalMoney111;
    @FXML
    TextArea chiefRemarkArea, billRemarkArea;
    @FXML
    TableView<PurchaseBill> purchaseBillTableView;
    @FXML
    TableColumn<PurchaseBill, String> IdCol, NameCol, TypeCol, PriceCol, NumberCol, RemarkCol, TotalCol;
    @FXML
    Label totalLabelLabel;

    @FXML
    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    public void showTableView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));

        ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();

        if (isSalesIn == true) {
            salesPane.setVisible(false);
            ArrayList<SalesItemVO> vos = salesInBillVO.getItemVOS();
            for (int i = 0; i < vos.size(); i++) {
                SalesItemVO salesItemVO = vos.get(i);
                PurchaseBill purchaseBill = new PurchaseBill(salesItemVO.getName(), salesItemVO.getId(), salesItemVO.getType(), String.valueOf(salesItemVO.getPrice()), String.valueOf(salesItemVO.getNumber()), String.valueOf(salesItemVO.getTotal()), "");
                data.add(purchaseBill);
            }
            if (salesInBillVO.getType() == SalesInBillType.IN) {
                billName.setText("进货单");
            } else {
                billName.setText("进货退货单");
            }
            if (salesInBillVO.getStatus() == BillStatus.rejected) {
                billStatus.setText("审批未通过");
                billStatus.setTextFill(Color.rgb(230, 18, 6));
            } else if (salesInBillVO.getStatus() == BillStatus.approval) {
                billStatus.setText("审批通过");
                billStatus.setTextFill(Color.rgb(51, 200, 51));
            } else if (salesInBillVO.getStatus() == BillStatus.commit) {
                billStatus.setText("已提交");
                billStatus.setTextFill(Color.rgb(0, 153, 204));
            }
            billIdLabel.setText(salesInBillVO.getID());
            supplierLabel.setText(salesInBillVO.getProvider());
            DAELabel.setText(salesInBillVO.getDAE());
            stockLabel.setText(salesInBillVO.getStorage());
            billTotalMoney.setText(String.valueOf(salesInBillVO.getSumMoney()));
            billRemarkArea.setText(salesInBillVO.getPs());
            billRemarkArea.setEditable(false);
            if (salesInBillVO.getCommentByManager() != null) {
                chiefRemarkArea.setText(salesInBillVO.getCommentByManager());
            }
            chiefRemarkArea.setEditable(false);
            if (salesInBillVO.getApproval_time() != null) {
                chiefTime.setText(salesInBillVO.getApproval_time().toString());
            } else {
                chiefName.setText("null");
            }
            commitTime.setText(salesInBillVO.getCommit_time().toString());
            if (salesInBillVO.getManager() != null) {
                chiefName.setText(salesInBillVO.getManager().getName());
            } else {
                chiefName.setText("null");
            }
        } else {
            ArrayList<SalesItemVO> vos = salesOutBillVO.getItemVOS();
            for (int i = 0; i < vos.size(); i++) {
                SalesItemVO salesItemVO = vos.get(i);
                PurchaseBill purchaseBill = new PurchaseBill(salesItemVO.getName(), salesItemVO.getId(), salesItemVO.getType(), String.valueOf(salesItemVO.getPrice()), String.valueOf(salesItemVO.getNumber()), String.valueOf(salesItemVO.getTotal()), "");
                data.add(purchaseBill);
            }

            if (salesOutBillVO.getType() == SalesOutBillType.OUT) {
                billName.setText("销售单");
            } else {
                billName.setText("销售退货单");
            }
            if (salesOutBillVO.getType() == SalesOutBillType.OUT) {
                salesPane.setVisible(true);
                billTotalMoney.setVisible(false);
                totalLabelLabel.setVisible(false);
                billTotalMoney1.setText(String.valueOf(salesOutBillVO.getSumBeforeDiscount()));
                System.out.println("before"+salesOutBillVO.getSumBeforeDiscount());
                billTotalMoney11.setText(String.valueOf(salesOutBillVO.getSumAfterDiscount() - salesOutBillVO.getSumBeforeDiscount()));
                billTotalMoney111.setText(String.valueOf(salesOutBillVO.getSumAfterDiscount()));
            } else {
                totalLabelLabel.setVisible(true);
                salesPane.setVisible(false);
            }
            if (salesOutBillVO.getStatus() == BillStatus.rejected) {
                billStatus.setText("审批未通过");
                billStatus.setTextFill(Color.rgb(230, 18, 6));
            } else if (salesOutBillVO.getStatus() == BillStatus.commit) {
                billStatus.setText("已提交");
                billStatus.setTextFill(Color.rgb(0, 153, 204));
            } else if (salesOutBillVO.getStatus() == BillStatus.approval) {
                billStatus.setText("审批通过");
                billStatus.setTextFill(Color.rgb(51, 200, 51));
            }
            stockLabel.setText(salesOutBillVO.getStorage());
            billIdLabel.setText(salesOutBillVO.getID());
            supplierLabel.setText(salesOutBillVO.getCustomerVO().getName());
            DAELabel.setText(salesOutBillVO.getDAE());
            System.out.println("DAE"+salesOutBillVO.getDAE());
            billTotalMoney.setText(String.valueOf(salesOutBillVO.getSumAfterDiscount()));
            billRemarkArea.setText(salesOutBillVO.getPs());
            billRemarkArea.setEditable(false);
            if (salesOutBillVO.getPs() != null) {
                chiefRemarkArea.setText(salesOutBillVO.getPs());
            }
            chiefRemarkArea.setEditable(false);
            if (salesOutBillVO.getApproval_time() != null) {
                chiefTime.setText(salesOutBillVO.getApproval_time().toString());
            } else {
                chiefTime.setText("null");
            }
            commitTime.setText(salesOutBillVO.getCommit_time().toString());
            if (salesOutBillVO.getManager() != null) {
                chiefName.setText(salesOutBillVO.getManager().getName());
            } else {
                chiefName.setText("null");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTableView();
    }
}
