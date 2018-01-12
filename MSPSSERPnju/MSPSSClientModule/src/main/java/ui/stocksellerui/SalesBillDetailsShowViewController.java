package ui.stocksellerui;

import auxiliary.PurchaseBill;
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

public class SalesBillDetailsShowViewController implements Initializable {
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
    Label billIdLabel, supplierLabel, DAELabel, stockLabel, chiefName, chiefTime, commitTime, billName, billStatus, beforeTotalMoney, afterTotalMoney, discountMoney;
    @FXML
    TextArea chiefRemarkArea, billRemarkArea;
    @FXML
    TableView<PurchaseBill> purchaseBillTableView;
    @FXML
    TableColumn<PurchaseBill, String> IdCol, NameCol, TypeCol, PriceCol, NumberCol, RemarkCol, TotalCol;

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
        ArrayList<SalesItemVO> vos = salesOutBillVO.getItemVOS();
        for (int i = 0; i < vos.size(); i++) {
            SalesItemVO salesItemVO = vos.get(i);
            PurchaseBill purchaseBill = new PurchaseBill(salesItemVO.getName(), salesItemVO.getId(), salesItemVO.getType(), String.valueOf(salesItemVO.getPrice()), String.valueOf(salesItemVO.getNumber()), String.valueOf(salesItemVO.getTotal()), "");
            data.add(purchaseBill);
        }

        billName.setText("销售单");

        if (salesOutBillVO.getStatus() == BillStatus.approval) {
            billStatus.setText("审批通过");
            billStatus.setTextFill(Color.rgb(51, 200, 51));
        } else if (salesOutBillVO.getStatus() == BillStatus.rejected) {
            billStatus.setText("审批未通过");
            billStatus.setTextFill(Color.rgb(230, 18, 6));
        } else if (salesOutBillVO.getStatus() == BillStatus.commit) {
            billStatus.setText("已提交");
            billStatus.setTextFill(Color.rgb(0, 153, 204));
        }
        billIdLabel.setText(salesOutBillVO.getID());
        supplierLabel.setText(salesOutBillVO.getCustomerVO().getName());
        DAELabel.setText(salesOutBillVO.getDAE());
        beforeTotalMoney.setText(String.valueOf(salesOutBillVO.getSumBeforeDiscount()));
        discountMoney.setText(String.valueOf(salesOutBillVO.getSumAfterDiscount() - salesOutBillVO.getSumBeforeDiscount()));
        afterTotalMoney.setText(String.valueOf(salesOutBillVO.getSumAfterDiscount()));
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTableView();
    }
}

