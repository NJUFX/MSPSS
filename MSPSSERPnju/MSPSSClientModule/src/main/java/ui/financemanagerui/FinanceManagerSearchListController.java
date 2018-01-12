package ui.financemanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import blimpl.blfactory.BLFactoryImpl;
import blservice.tableblservice.TableBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.chiefmanagerui.ChiefManagerSearchManageListController;
import ui.chiefmanagerui.ChiefManagerSearchProcessListController;
import ui.chiefmanagerui.ChiefManagerSearchSalesListController;
import ui.common.Dialog;
import util.Time;
import vo.BusinessTableVO;
import vo.ProcessTableFilterFlagsVO;
import vo.ProcessTableVO;
import vo.SaleTableFilterFlagsVO;
import vo.SaleTableVO;
import vo.UserVO;

public class FinanceManagerSearchListController implements Initializable {

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
	ComboBox TableType;
	@FXML
	DatePicker StartTime;
	@FXML
	DatePicker EndTime;
	@FXML
	TextField ProductName;
	@FXML
	TextField CustomerName;
	@FXML
	TextField AssistantName;
	@FXML
	TextField StorageName;
	@FXML
	ComboBox BillType;
	@FXML
	Button Search;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
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
	 * 判断报表类型
	 * @param e
	 * @throws Exception
	 */
	public void ChooseTableType(ActionEvent e) throws Exception{
		//comboBox不允许自己输入内容
		TableType.setEditable(false);
		BillType.setEditable(false);
		//初始化控件
		StartTime.setDisable(false);
		EndTime.setDisable(false);
		ProductName.setEditable(true);
		CustomerName.setEditable(true);
		AssistantName.setEditable(true);
		StorageName.setEditable(true);
		BillType.setDisable(false);
		
		String tableType = TableType.getValue().toString();
		switch(tableType) {
		case"销售明细表":{
			BillType.setDisable(true);
			break;
		}
		case"经营情况表":{
			ProductName.setEditable(false);
			CustomerName.setEditable(false);
			AssistantName.setEditable(false);
			StorageName.setEditable(false);
			BillType.setDisable(true);
			break;
		}
		case"经营历程表":{
			ProductName.setEditable(false);
			break;
		}
		}
	}
	
	/**
	 * 清空所有条件
	 * @param e
	 * @throws Exception
	 */
	public void handleClearButtonAction(ActionEvent e) throws Exception{
		ProductName.setText("");
		CustomerName.setText("");
		AssistantName.setText("");
		StorageName.setText("");
	
	}
	
	/**
	 * 监听查询按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleSearchButtonAction(ActionEvent e) throws Exception{
		String tableType = TableType.getValue().toString();
		switch(tableType) {
		case"销售明细表":{
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			
			String commodityName = "";
			commodityName = ProductName.getText();
			String customerName = "";
			customerName = CustomerName.getText();
			String operator = "";
			operator = AssistantName.getText();
			String storage = "";
			storage = StorageName.getText();
			
			SaleTableFilterFlagsVO flag = new SaleTableFilterFlagsVO();
			flag.setBegin(start);
			flag.setEnd(end);
			flag.setCommodityName(commodityName);
			flag.setCustomerName(customerName);
			flag.setOperatorName(operator);
			flag.setStorage(storage);
			SaleTableVO vo = tableBLService.checkSaleTable(flag);
			FinanceManagerSearchSalesListController controller = (FinanceManagerSearchSalesListController) replaceSceneContent(
						"/view/financemanager/FinanceManagerSearchSalesList.fxml");
			controller.ShowSalesList(vo);
			break;
		}
		
		case"经营情况表":{
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			BusinessTableVO vo = tableBLService.checkBusinessTable(start, end);
			FinanceManagerSearchManageListController controller = (FinanceManagerSearchManageListController) replaceSceneContent(
						"/view/financemanager/FinanceManagerSearchManageList.fxml");
			controller.showManageTable(vo);
			break;
		}
		
		case"经营历程表":{
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			String customerName = "";
			customerName = CustomerName.getText();
			String operator = "";
			operator = AssistantName.getText();
			String storage = "";
			storage = StorageName.getText();
			String billType = BillType.getValue().toString();
			ProcessTableFilterFlagsVO flag = new ProcessTableFilterFlagsVO();
			flag.setBegin(start);
			flag.setEnd(end);
			flag.setCustomerName(customerName);
			flag.setOperatorName(operator);
			flag.setStorage(storage);
			ProcessTableVO vo = tableBLService.checkProcessTable(flag);
				FinanceManagerSearchProcessListController controller = (FinanceManagerSearchProcessListController) replaceSceneContent(
						"/view/financemanager/FinanceManagerSearchProcessList.fxml");
			controller.setBillType(billType);	
			controller.showProcessTable(vo);
			break;
		}
		
		}
	}

}