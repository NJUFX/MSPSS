package ui.chiefmanagerui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.tableblservice.TableBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.Time;
import vo.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ChiefManagerSearchListController implements Initializable{
	@FXML
	Button SearchList;
	@FXML
	Button ExamineBill;
	@FXML
	Button ReadLog;
	@FXML
	Button SetPromotion;
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
			ChiefManagerSearchListController controller = (ChiefManagerSearchListController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听审批单据按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleExamineBillButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerExamineBillController controller = (ChiefManagerExamineBillController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerExamineBill.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听查询日志按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleReadLogButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerReadLogController controller = (ChiefManagerReadLogController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerReadLog.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听促销策略按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSetPromotionButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerSetPromotionController controller = (ChiefManagerSetPromotionController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSetPromotion.fxml");
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
        System.out.println();
        String tableType = TableType.getValue().toString();
        System.out.println(tableType);
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
			ChiefManagerSearchSalesListController controller = (ChiefManagerSearchSalesListController) replaceSceneContent(
						"/view/chiefmanager/ChiefManagerSearchSalesList.fxml");
			controller.ShowSalesList(vo);
			break;
		}
		
		case"经营情况表":{
            System.out.println();
            System.out.println();
            LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			BusinessTableVO vo = tableBLService.checkBusinessTable(start, end);
				ChiefManagerSearchManageListController controller = (ChiefManagerSearchManageListController) replaceSceneContent(
						"/view/chiefmanager/ChiefManagerSearchManageList.fxml");
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
            //System.out.println("storage is ::"+storage+"111");
            ProcessTableVO vo = tableBLService.checkProcessTable(flag);
            System.out.println("经营历程表");
            //System.out.println(vo==null);
            ChiefManagerSearchProcessListController controller = (ChiefManagerSearchProcessListController) replaceSceneContent(
						"/view/chiefmanager/ChiefManagerSearchProcessList.fxml");
			controller.setBillType(billType);	
			controller.showProcessTable(vo);
			break;
		}
		
		}
	}

}
