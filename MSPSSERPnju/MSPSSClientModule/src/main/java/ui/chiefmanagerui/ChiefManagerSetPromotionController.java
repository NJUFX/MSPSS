package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.Bill;
import auxiliary.PromotionCommodity;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.ManagerBillBLService;
import blservice.logblservice.LogBLService;
import blservice.promotionblservice.PromotionBLService;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.Time;
import vo.CustomerPromotionVO;
import vo.GrossPromotionVO;
import vo.GroupPromotionVO;
import vo.PresentationCommodityItemVO;

public class ChiefManagerSetPromotionController implements Initializable{
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
	ComboBox PromotionType;
	@FXML
	DatePicker StartTime;
	@FXML
	DatePicker EndTime;
	@FXML
	ComboBox CustomerLevel;
	@FXML
	TextField DiscountAmount;
	@FXML
	TextField Coupon;
	
	@FXML
	TextField Amount;
	@FXML
	TextField BargainBagPrice;
	@FXML
	TableView ProductTable;
	@FXML
	TextField ProductField;
	@FXML
	TextField ProductSum;
	@FXML
	Button AddButton;
	@FXML
	Button ConfirmPromotion;
	@FXML
	Button ClearCondition;
	@FXML 
	Button SearchPromotion;
	
	
	
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		
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
	 * 判断选中的促销策略类型
	 * @param e
	 * @throws Exception
	 */
	public void ChoosePromotionType(ActionEvent e) throws Exception{
		String promotionType = PromotionType.getValue().toString();
		//初始设置所有的条件都不可选
		CustomerLevel.setDisable(true);
		Coupon.setEditable(false);
		DiscountAmount.setEditable(false);
		Amount.setEditable(false);
		BargainBagPrice.setEditable(false);
		ProductField.setEditable(false);
		ProductSum.setEditable(false);
	
		//判定选中的促销策略类型
		switch(promotionType){
		case"分级促销策略":{
			CustomerLevel.setDisable(false);
			Coupon.setEditable(true);
			DiscountAmount.setEditable(true);
			ProductField.setEditable(true);
			ProductSum.setEditable(true);
			break;
		}
		
		case"总额促销策略":{
			Amount.setEditable(true);
			Coupon.setEditable(true);
			ProductField.setEditable(true);
			ProductSum.setEditable(true);
			break;
		}
		
		case"制定特价包":{
			BargainBagPrice.setEditable(true);
			ProductField.setEditable(true);
			ProductSum.setEditable(true);
			break;
		}
		
		}
	}
	
	/**
	 * 监听制定策略按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleConfirmPromotionButtonAction(ActionEvent e) throws Exception{
		String promotionType = PromotionType.getValue().toString();
		switch(promotionType){
		case"分级促销策略":{
			int level = Integer.parseInt(CustomerLevel.getValue().toString());
			double discount = 0.0;
			int voucher = 0;
			ArrayList<PresentationCommodityItemVO> promotionCommodity = new ArrayList<PresentationCommodityItemVO>();
			ObservableList<PromotionCommodity> data = ProductTable.getItems();
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);

			if(data.size()!=0) {
				for(int i=0;i<data.size();i++) {
					promotionCommodity.add(new PresentationCommodityItemVO(data.get(i).getCommodity(),Integer.parseInt(data.get(i).getSum())));
				}
			}
			if(!(DiscountAmount.getText().equals(""))) {
				discount = Double.parseDouble(DiscountAmount.getText());
			}
			if(!(Coupon.getText().equals(""))) {
				voucher = Integer.parseInt(Coupon.getText());
			}
			
			PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			if(promotionCommodity.size()!=0) {
				promotionBLService.addCustomerPromotion(new CustomerPromotionVO(level,discount,voucher,start,end));
			}
			else {
				promotionBLService.addCustomerPromotion(new CustomerPromotionVO(level,discount,voucher,promotionCommodity,start,end));
			}
			break;
		}
		
		case"总额促销策略":{
			double total = 0.0;
			int voucher = 0;
			ArrayList<PresentationCommodityItemVO> promotionCommodity = new ArrayList<PresentationCommodityItemVO>();
			ObservableList<PromotionCommodity> data = ProductTable.getItems();
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			
			if(data.size()!=0) {
				for(int i=0;i<data.size();i++) {
					promotionCommodity.add(new PresentationCommodityItemVO(data.get(i).getCommodity(),Integer.parseInt(data.get(i).getSum())));
				}
			}
			if(!(Amount.getText().equals(""))) {
				total = Double.parseDouble(Amount.getText());
			}
			if(!(Coupon.getText().equals(""))) {
				voucher = Integer.parseInt(Coupon.getText());
			}
			PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			if(promotionCommodity.size()!=0) {
				promotionBLService.addGrossPromotion(new GrossPromotionVO(total,voucher,promotionCommodity,start ,end));
			}
			else {
				promotionBLService.addGrossPromotion(new GrossPromotionVO(total,voucher,start,end));
			}
			
			break;
		}
		
		case"制定特价包":{
			double discountRate = Double.parseDouble(BargainBagPrice.getText());
			ObservableList<PromotionCommodity> data = ProductTable.getItems();
			ArrayList<String> commodity = new ArrayList<String>();
			LocalDate startTime = StartTime.getValue();
			LocalDate endTime = EndTime.getValue();
			Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
			Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
			
			for(int i=0;i<data.size();i++) {
				commodity.add(data.get(i).getCommodity());
			}
			PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			promotionBLService.addGroupPromotion(new GroupPromotionVO(discountRate,commodity,start,end));
			
			break;
		}
		
		}
		
		
	}
	
	/**
	 * 监听增加商品按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddButtonButtonAction(ActionEvent e) throws Exception{
		ObservableList<PromotionCommodity> data = ProductTable.getItems();
		data.add(new PromotionCommodity(ProductField.getText(),ProductSum.getText()));
	}
	
	/**
	 * 监听清空条件按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleClearConditionButtonAction(ActionEvent e) throws Exception{
		
		CustomerLevel.setDisable(true);
		Coupon.setText("");
		Coupon.setEditable(false);
		DiscountAmount.setText("");
		DiscountAmount.setEditable(false);
		Amount.setText("");
		Amount.setEditable(false);
		BargainBagPrice.setText("");
		BargainBagPrice.setEditable(false);
		ProductField.setText("");
		ProductSum.setText("");
		ProductField.setEditable(false);
		ProductSum.setEditable(false);
		ObservableList<PromotionCommodity> data = ProductTable.getItems();
		data.clear();
	}
	
	/**
	 * 监听策略列表按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleSearchPromotionButtonAction(ActionEvent e) throws Exception{
		try {
			ChiefManagerSearchPromotionListController controller = (ChiefManagerSearchPromotionListController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSearchPromotionList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
