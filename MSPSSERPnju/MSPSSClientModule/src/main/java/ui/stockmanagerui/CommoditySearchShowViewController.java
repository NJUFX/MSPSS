package ui.stockmanagerui;

import auxiliary.CommodityTable;
import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
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
import vo.CommodityVO;
import vo.FilterFlagVO;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen
 * date:2017/12/8
 */
public class CommoditySearchShowViewController implements Initializable {
    public CommodityTable OperateCommodity = new CommodityTable();
    Stage stage = StageSingleton.getStage();
    CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    static ArrayList<CommodityVO> arrayList = new ArrayList<>();
    private String keyType, keyword;
    FilterFlagVO filterFlagVO = new FilterFlagVO();

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @FXML
    Button BackToLogin;
    @FXML
    Button commodityDelButton;
    @FXML
    Button commodityAddButton;
    @FXML
    Button commodityModButton;
    @FXML
    Button backButton, refreshButton;
    @FXML
    TableView<CommodityTable> commodityTableTable;
    @FXML
    TableColumn<CommodityTable, String> IdCol, NameCol, CategoryCol, ImportCol, ExportCol;
    @FXML
    TableColumn<CommodityTable, String> OperationCol;


    public void showTableView() {
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CategoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        ImportCol.setCellValueFactory(new PropertyValueFactory<>("ImportPrice"));
        ExportCol.setCellValueFactory(new PropertyValueFactory<>("ExportPrice"));
        OperationCol.setCellFactory((col) -> {
            TableCell<CommodityTable, String> cell = new TableCell<CommodityTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button delBtn = new Button("选择");
                        delBtn.setPrefSize(80, 10);
                        //delBtn.setFont(Font.font(12));
                        delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            //OperateCommodity = this.getTableView().getItems().get(this.getIndex());
                            try {
                                CommodityInfoShowViewController controller = (CommodityInfoShowViewController) replaceSceneContent(
                                        "/view/stockmanager/CommodityInfoShow.fxml");
                                controller.id_to_modify = this.getTableView().getItems().get(this.getIndex()).getId();
                                //controller.setCommodityTable(OperateCommodity);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        });
                    }
                }
            };
            return cell;
        });
        addRow();
    }

    public void addRow() {
        ObservableList<CommodityTable> data = commodityTableTable.getItems();

        switch (keyType) {
            case "分类":
                filterFlagVO.classificationName = keyword;
                break;
            case "编号":
                filterFlagVO.id = keyword;
                break;
            case "名称":
                filterFlagVO.name = keyword;
                break;
            case "进价（向上查找）":
                filterFlagVO.importCostMin = Double.parseDouble(keyword);
                break;
            case "进价（向下查找）":
                filterFlagVO.importCostMax = Double.parseDouble(keyword);
                break;
            case "零售价（向上查找）":
                filterFlagVO.exportCostMin = Double.parseDouble(keyword);
                break;
            case "零售价（向下查找）":
                filterFlagVO.exportCostMax = Double.parseDouble(keyword);
                break;
        }
        arrayList = commodityInfoService.search(filterFlagVO);
        for (int i = 0; i < arrayList.size(); i++) {
            CommodityTable c = new CommodityTable(arrayList.get(i).getName(), arrayList.get(i).getID(), arrayList.get(i).getClassificationName(), String.valueOf(arrayList.get(i).getImportCost()), String.valueOf(arrayList.get(i).getExportCost()));
            data.add(c);
        }
    }

    @FXML
    public void refreshButtonAction(ActionEvent e) {
        ObservableList<CommodityTable> data = commodityTableTable.getItems();
        arrayList = commodityInfoService.search(filterFlagVO);
        for (int i = 0; i < arrayList.size(); i++) {
            CommodityTable c = new CommodityTable(arrayList.get(i).getName(), arrayList.get(i).getID(), arrayList.get(i).getClassificationName(), String.valueOf(arrayList.get(i).getImportCost()), String.valueOf(arrayList.get(i).getExportCost()));
            data.add(c);
        }
    }

    public void refreshButtonAction() {
        ObservableList<CommodityTable> data = commodityTableTable.getItems();
        arrayList = commodityInfoService.search(filterFlagVO);
        for (int i = 0; i < arrayList.size(); i++) {
            CommodityTable c = new CommodityTable(arrayList.get(i).getName(), arrayList.get(i).getID(), arrayList.get(i).getClassificationName(), String.valueOf(arrayList.get(i).getImportCost()), String.valueOf(arrayList.get(i).getExportCost()));
            data.add(c);
        }
    }

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            CommoditySearchViewController controller = (CommoditySearchViewController) replaceSceneContent(
                    "/view/stockmanager/commoditySearch.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 删除商品
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityDelButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityDelViewController controller = (CommodityDelViewController) replaceSceneContent(
                    "/view/stockmanager/commodityDel.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 增加商品
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityAddButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityAddViewController controller = (CommodityAddViewController) replaceSceneContent(
                    "/view/stockmanager/commodityAdd.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 修改属性
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityModButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityModifyFirstViewController controller = (CommodityModifyFirstViewController) replaceSceneContent(
                    "/view/stockmanager/commodityModifyFirst.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 下一步
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void nextOperationButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityModitySecondViewController controller = (CommodityModitySecondViewController) replaceSceneContent(
                    "/view/stockmanager/commodityModifySecond.fxml");
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
            LoginController controller = (LoginController) replaceSceneContent(
                    "/view/admin/Login.fxml");
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
        showTableView();
    }

}

