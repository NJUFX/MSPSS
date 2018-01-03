package ui.stocksellerui;

import auxiliary.PresentationList;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityInfoService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.adminui.LoginController;
import vo.PresentationCommodityItemVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PresentationListShowViewController implements Initializable {

    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    static ArrayList<PresentationCommodityItemVO> presentationList;

    @FXML
    Button returnButton;
    @FXML
    TableView<PresentationList> tableView;
    @FXML
    TableColumn<PresentationList, String> NameCol, NumberCol;


    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    public void showTabelView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        ObservableList<PresentationList> data = tableView.getItems();
        for (int i = 0; i < presentationList.size(); i++) {
            PresentationList a = new PresentationList(commodityInfoService.getCommodity(presentationList.get(i).getCommodityID()).getName(), String.valueOf(presentationList.get(i).getNumber()));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTabelView();
    }
}