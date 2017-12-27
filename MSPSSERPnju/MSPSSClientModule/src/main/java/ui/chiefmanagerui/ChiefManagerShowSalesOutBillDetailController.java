package ui.chiefmanagerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.SalesOutBillVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ChiefManagerShowSalesOutBillDetailController implements Initializable{
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
	Pane SalesOutBillPane;
	
	@FXML
	Label SalesOutBillId;
	@FXML
	Label SalesOutBillType;
	@FXML
	Label SalesOutBillStatus;
	@FXML
	Label SalesOutBillDAE;
	@FXML
	Label SalesOutBillPromotion;
	@FXML
	Label SalesOutBillCoupon;
	@FXML
	Label SalesOutBillCustomer;
	@FXML
	Label SalesOutBillStorage;
	@FXML
	Label SalesOutBillOperator;
	
	@FXML
	Label SalesOutBillSumBeforeDiscount;
	@FXML
	Label SalesOutBillSumAfterDiscount;
	@FXML
	Label SalesOutBillAllowance;
	@FXML
	Label SalesOutBillInitTime;
	@FXML
	Label SalesOutBillCommitTime;
	
	@FXML
	TextArea SalesOutBillItem;
	
	@FXML
	Button BackToExamineBill;
	
	
	
	
	
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
	 * 显示销售单据详情
	 * @param vo
	 */
	public void ShowSalesOutBillDetail(SalesOutBillVO vo) {
		
		
		SalesOutBillId.setText(vo.getID());
		SalesOutBillType.setText(vo.getType().toString());
		SalesOutBillStatus.setText(vo.getStatus().toString());
		SalesOutBillDAE.setText(vo.getDAE());
        SalesOutBillPromotion.setText("");//fixme 这里暂时存在一些问题 所以我先把它注释掉了
		SalesOutBillCoupon.setText(Integer.toString(vo.getVoucher()));
		SalesOutBillCustomer.setText(vo.getCustomerVO().getName());
		SalesOutBillStorage.setText(vo.getStorage());
		SalesOutBillOperator.setText(vo.getOperator().getName());
		//SalesOutBillExamineManager.setText("");
		SalesOutBillSumBeforeDiscount.setText(Double.toString(vo.getSumBeforeDiscount()));
		SalesOutBillSumAfterDiscount.setText(Double.toString(vo.getSumAfterDiscount()));
		SalesOutBillAllowance.setText(Double.toString(vo.getAllowance()));
		SalesOutBillInitTime.setText(vo.getInit_time().toString());
		SalesOutBillCommitTime.setText(vo.getCommit_time().toString());
		//SalesOutBillExamineTime.setText("");
		
		String BillItem = "";
		for(int i=0;i<vo.getItemVOS().size();i++) {
			BillItem = BillItem + vo.getItemVOS().get(i).getName()+"-"+vo.getItemVOS().get(i).getType()+"-"+vo.getItemVOS().get(i).getId()+"-"+Double.toString(vo.getItemVOS().get(i).price)+"-"+Double.toString(vo.getItemVOS().get(i).number)+"\n";
		}
		SalesOutBillItem.setText(BillItem);
		
		
	}
	
	
	
	/**
	 * 返回审批单据界面
	 * @param e
	 * @throws Exception
	 */
	public void handleBackToExamineBillButtonAction(ActionEvent e) throws Exception{
		try {
			ChiefManagerExamineBillController controller = (ChiefManagerExamineBillController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerExamineBill.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}