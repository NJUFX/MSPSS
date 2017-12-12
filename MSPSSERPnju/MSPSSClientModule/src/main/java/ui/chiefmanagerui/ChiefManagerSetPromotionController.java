package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

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
import ui.common.Dialog;

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
	TextField GiftAmount;
	@FXML
	TextField ProductName;
	@FXML
	TextField DiscountAmount;
	@FXML
	TextField CouponDeno;
	@FXML
	TextField CouponNumber;
	@FXML
	TextField AmountSection;
	@FXML
	TextField BargainBagPrice;
	@FXML
	TextField BargainBagProduct;
	
	
	
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
		CouponDeno.setEditable(false);
		CouponNumber.setEditable(false);
		DiscountAmount.setEditable(false);
		ProductName.setEditable(false);
		GiftAmount.setEditable(false);
		AmountSection.setEditable(false);
		BargainBagPrice.setEditable(false);
		BargainBagProduct.setEditable(false);
		//判定选中的促销策略类型
		switch(promotionType){
		case"分级赠送代金券":{
			CustomerLevel.setDisable(false);
			CouponDeno.setEditable(true);
			CouponNumber.setEditable(true);
			break;
		}
		case"分级价格折让":{
			CustomerLevel.setDisable(false);
			DiscountAmount.setEditable(true);
			break;
		}
		case"分级赠送赠品":{
			CustomerLevel.setDisable(false);
			ProductName.setEditable(true);
			GiftAmount.setEditable(true);
			break;
		}
		case"总额赠送代金券":{
			AmountSection.setEditable(true);
			CouponDeno.setEditable(true);
			CouponNumber.setEditable(true);
			break;
		}
		case"总额赠送赠品":{
			AmountSection.setEditable(true);
			ProductName.setEditable(true);
			GiftAmount.setEditable(true);
			break;
		}
		case"制定特价包":{
			BargainBagPrice.setEditable(true);
			BargainBagProduct.setEditable(true);
			break;
		}
		
		}
	}

}
