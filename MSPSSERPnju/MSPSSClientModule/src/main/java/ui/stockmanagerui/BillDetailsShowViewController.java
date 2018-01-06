package ui.stockmanagerui;

import auxiliary.Breakage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import ui.adminui.LoginController;
import util.BillStatus;
import util.StockBillType;
import vo.StockBillItemVO;
import vo.StockBillVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillDetailsShowViewController implements Initializable {
    static StockBillVO stockBillVO;
    @FXML
    Button returnButton;
    @FXML
    Label billName, billStatus, chiefName, time, commitTime;
    @FXML
    TextArea remarkArea;
    @FXML
    TableView<Breakage> breakageTableView;
    @FXML
    TableColumn<Breakage, String> IdCol, NameCol, SystemNumberCol, RealNumberCol, RemarkCol;


    @FXML
    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    public void showTableView() {
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        SystemNumberCol.setCellValueFactory(new PropertyValueFactory<>("SystemNumber"));
        RealNumberCol.setCellValueFactory(new PropertyValueFactory<>("RealNumber"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));

        ObservableList<Breakage> data = breakageTableView.getItems();

        ArrayList<StockBillItemVO> vos = stockBillVO.itemVOS;
        for (int i = 0; i < vos.size(); i++) {
            StockBillItemVO s = vos.get(i);
            Breakage breakage = new Breakage(s.commodityVO.getID(), s.commodityVO.getName(), String.valueOf(s.commodityVO.getNumberInStock()), String.valueOf(s.number), "");
            data.add(breakage);
        }

        String str = "库存赠送单";
        if (stockBillVO.getType() == StockBillType.Less) {
            str = "库存报损单";
        } else if (stockBillVO.getType() == StockBillType.More) {
            str = "库存报溢单";
        }
        billName.setText(str);
        if (stockBillVO.getStatus() == BillStatus.rejected) {
            billStatus.setText("审批未通过");
            billStatus.setTextFill(Color.rgb(230, 18, 6));
        } else if (stockBillVO.getStatus() == BillStatus.approval) {
            billStatus.setText("审批通过");
            billStatus.setTextFill(Color.rgb(51, 200, 51));
        } else if (stockBillVO.getStatus() == BillStatus.commit) {
            billStatus.setText("已提交");
            billStatus.setTextFill(Color.rgb(0, 153, 204));
        }

        if (stockBillVO.getManager() != null) {
            chiefName.setText(stockBillVO.getManager().getName());
        } else {
            chiefName.setText("null");
        }
        remarkArea.setText(stockBillVO.getCommentByManager());
        remarkArea.setEditable(false);
        commitTime.setText(stockBillVO.getCommit_time().toString());
        if (stockBillVO.getApproval_time() != null) {
            time.setText(stockBillVO.getApproval_time().toString());
        } else {
            time.setText("null");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTableView();
    }
}
