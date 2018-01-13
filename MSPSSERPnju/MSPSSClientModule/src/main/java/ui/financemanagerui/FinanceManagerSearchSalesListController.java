package ui.financemanagerui;

import auxiliary.SalesTableBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.tableblservice.TableBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.SaleTableVO;
import vo.SalesItemVO;
import vo.SalesOutBillVO;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class FinanceManagerSearchSalesListController implements Initializable {

	@FXML
	Button SearchList;
	@FXML
	Button MakeBill;
	@FXML
	Button SuperviseAccount;
	@FXML
	Button CreateGeneralAccount;
	@FXML
	Label NameTag;
	@FXML
	Label RoleTag;
	@FXML
	Label IdTag;
	@FXML
	Button BackToLogin;
	@FXML
	TableView SalesTable;
	@FXML
	Button ExportSalesList;
	@FXML
	Button BackToSearchList;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	static SaleTableVO tableVO;
	TableBLService tableBLService = new BLFactoryImpl().getTableBLService();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		NameTag.setText(currentUser.getName());
		RoleTag.setText(currentUser.getCategory().toString());
		IdTag.setText(currentUser.getID());
	}

	public void setApp(MainApp application) {
		this.application = application;
	}
	
	/*
	public void SetTags(String name,String Role,String id) {
		NameTag.setText(name);
		RoleTag.setText(Role);
		IdTag.setText(id);
	}
	*/

	
	/**
	 * 监听查看报表按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSearchListButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerSearchListController controller = (FinanceManagerSearchListController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听制定单据按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleMakeBillButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerMakeBillMainController controller = (FinanceManagerMakeBillMainController) replaceSceneContent(
					"/view/financemanager/FinanceManagerMakeBillMain.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听账户管理按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSuperviseAccountButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerSuperviseAccountController controller = (FinanceManagerSuperviseAccountController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSuperviseAccount.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听期初建账按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleCreateGeneralAccountButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerCreateGeneralAccountController controller = (FinanceManagerCreateGeneralAccountController) replaceSceneContent(
					"/view/financemanager/FinanceManagerCreateGeneralAccount.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 返回登录界面
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


	/**
	 * 显示销售明细表
	 * @param vo
	 */
	public void ShowSalesList(SaleTableVO vo) {
		tableVO = vo;
		ObservableList data = SalesTable.getItems();
		for(int i=0;i<vo.getSalesOutBills().size();i++) {
			SalesOutBillVO tempBill = vo.getSalesOutBills().get(i);
			String time = tempBill.getInit_time().toString();
			for(int j=0;j<tempBill.getItemVOS().size();j++) {
				SalesItemVO item = tempBill.getItemVOS().get(j);
				data.add(new SalesTableBill(time,item.getName(),item.getType(),Integer.toString(item.getNumber()),Double.toString(item.getPrice()),item.getTotal()));
			}
		}
	}
	
	/**
	 * 导出销售明细表
	 * @param e
	 * @throws Exception
	 */
	public void handleExportSalesListButtonAction(ActionEvent e) throws Exception{
		tableBLService.exportSaleTable(tableVO);
		Dialog d = new Dialog();
		d.confirmDialog("导出报表成功！");
	}
	
	/**
	 * 返回查看报表主界面
	 * @param e
	 * @throws Exception
	 */
	public void handleBackToSearchListButtonAction(ActionEvent e) throws Exception{
		try {
			FinanceManagerSearchListController controller = (FinanceManagerSearchListController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}