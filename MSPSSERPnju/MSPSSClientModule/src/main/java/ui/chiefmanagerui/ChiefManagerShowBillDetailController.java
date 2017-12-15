package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliary.Bill;
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
import vo.CashCostBillVO;
import vo.FinanceBillVO;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;

public class ChiefManagerShowBillDetailController implements Initializable{
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
	Pane StockBillPane;
	@FXML
	Pane SalesInBillPane;
	@FXML
	Pane SalesOutBillPane;
	@FXML
	Pane FinanceBillPane;
	@FXML
	Label StockBillId;
	@FXML
	Label StockBillType;
	@FXML
	Label StockBillStatus;
	@FXML
	Label StockBillInitTime;
	@FXML
	Label StockBillCommitTime;
	@FXML
	Label StockBillExamineTime;
	@FXML
	Label StockBillStockManagerComment;
	@FXML
	Label StockBillOperator;
	@FXML
	Label StockBillExamineManager;
	@FXML
	Label StockBillExamineManagerComment;
	@FXML
	TextArea StockBillItem;
	@FXML
	Label SalesInBillId;
	@FXML 
	Label SalesInBillDAE;
	@FXML
	Label SalesInBillProvider;
	@FXML
	Label SalesInBillStorage;
	@FXML
	Label SalesInBillType;
	@FXML
	Label SalesInBillOperator;
	@FXML
	Label SalesInBillPS;
	@FXML
	Label SalesInBillSumMoney;
	@FXML
	Label SalesInBillStatus;
	@FXML
	Label SalesInBillInitTime;
	@FXML
	Label SalesInBillExamineTime;
	@FXML
	Label SalesInBillExamineManager;
	@FXML
	Label SalesInBillExamineComment;
	@FXML
	Label SalesInBillCommitTime;
	@FXML
	TextArea SalesInBillItem;
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
	Label SalesOutBillExamineManager;
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
	Label SalesOutBillExamineTime;
	@FXML
	TextArea SalesOutBillItem;
	@FXML
	Label FinanceBillId;
	@FXML
	Label FinanceBillOperator;
	@FXML
	Label FinanceBillCustomer;
	@FXML
	Label FinanceBillExamineManager;
	@FXML
	Label FinanceBillInitTime;
	@FXML
	Label FinanceBillCommitTime;
	@FXML
	Label FinanceBillExamineTime;
	@FXML
	Label FinanceBillType;
	@FXML
	Label FinanceBillSum;
	@FXML
	Label FinanceBillStatus;
	@FXML
	TextArea FinanceBillItem;
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
	 * 显示库存单据详情
	 * @param vo
	 */
	public void ShowStockBillDetail(StockBillVO vo) {
		StockBillPane.setVisible(true);
		SalesInBillPane.setVisible(false);
		SalesOutBillPane.setVisible(false);
		FinanceBillPane.setVisible(false);
		
		StockBillId.setText(vo.id);
		StockBillType.setText(vo.type.toString());
		StockBillStatus.setText(vo.status.toString());
		StockBillInitTime.setText(vo.init_time.toString());
		StockBillCommitTime.setText(vo.commit_time.toString());
		StockBillExamineTime.setText(vo.approval_time.toString());
		StockBillStockManagerComment.setText(vo.commentByStockManager);
		StockBillOperator.setText(vo.stockManager.getName());
		StockBillExamineManager.setText(vo.manager.getName());
		StockBillExamineManagerComment.setText(vo.commentByManager);
		String BillItem = "";
		for(int i=0;i<vo.getItemVOS().size();i++) {
			BillItem = BillItem + vo.getItemVOS().get(i).getCommodityVO().name+"    " +vo.getItemVOS().get(i).number+"\n";
		}
		StockBillItem.setText(BillItem);
		
		
	}
	
	/**
	 * 显示进货单据详情
	 * @param vo
	 */
	public void ShowSalesInBillDetail(SalesInBillVO vo) {
		StockBillPane.setVisible(false);
		SalesInBillPane.setVisible(true);
		SalesOutBillPane.setVisible(false);
		FinanceBillPane.setVisible(false);
		
		SalesInBillId.setText(vo.getID());
		SalesInBillDAE.setText(vo.getDAE());
		SalesInBillProvider.setText(vo.getProvider());
		SalesInBillStorage.setText(vo.getStorage());
		SalesInBillType.setText(vo.getType().toString());
		SalesInBillOperator.setText(vo.getOperator().getName());
		SalesInBillPS.setText(vo.getPs());
		SalesInBillSumMoney.setText(Double.toString(vo.getSumMoney()));
		SalesInBillStatus.setText(vo.getStatus().toString());
		SalesInBillInitTime.setText(vo.getInit_time().toString());
		SalesInBillExamineTime.setText(vo.getApproval_time().toString());
		SalesInBillExamineManager.setText(vo.getManager().getName());
		SalesInBillExamineComment.setText(vo.getCommentByManager());
		SalesInBillCommitTime.setText(vo.getCommit_time().toString());
		String BillItem = "";
		for(int i=0;i<vo.getItemVOS().size();i++) {
			BillItem = BillItem + vo.getItemVOS().get(i).getName()+"-"+vo.getItemVOS().get(i).getType()+"-"+vo.getItemVOS().get(i).getId()+"-"+Double.toString(vo.getItemVOS().get(i).price)+"-"+Double.toString(vo.getItemVOS().get(i).number)+"\n";
		}
		SalesInBillItem.setText(BillItem);
	}
	
	/**
	 * 显示销售单据详情
	 * @param vo
	 */
	public void ShowSalesOutBillDetail(SalesOutBillVO vo) {
		StockBillPane.setVisible(false);
		SalesInBillPane.setVisible(false);
		SalesOutBillPane.setVisible(true);
		FinanceBillPane.setVisible(false);
		
		SalesOutBillId.setText(vo.getID());
		SalesOutBillType.setText(vo.getType().toString());
		SalesOutBillStatus.setText(vo.getStatus().toString());
		SalesOutBillDAE.setText(vo.getDAE());
		SalesOutBillPromotion.setText(vo.getPromotionVO().getType());
		SalesOutBillCoupon.setText(Integer.toString(vo.getVoucher()));
		SalesOutBillCustomer.setText(vo.getCustomerVO().getName());
		SalesOutBillStorage.setText(vo.getStorage());
		SalesOutBillOperator.setText(vo.getOperator().getName());
		SalesOutBillExamineManager.setText(vo.getManager().getName());
		SalesOutBillSumBeforeDiscount.setText(Double.toString(vo.getSumBeforeDiscount()));
		SalesOutBillSumAfterDiscount.setText(Double.toString(vo.getSumAfterDiscount()));
		SalesOutBillAllowance.setText(Double.toString(vo.getAllowance()));
		SalesOutBillInitTime.setText(vo.getInit_time().toString());
		SalesOutBillCommitTime.setText(vo.getCommit_time().toString());
		SalesOutBillExamineTime.setText(vo.getApproval_time().toString());
		
		String BillItem = "";
		for(int i=0;i<vo.getItemVOS().size();i++) {
			BillItem = BillItem + vo.getItemVOS().get(i).getName()+"-"+vo.getItemVOS().get(i).getType()+"-"+vo.getItemVOS().get(i).getId()+"-"+Double.toString(vo.getItemVOS().get(i).price)+"-"+Double.toString(vo.getItemVOS().get(i).number)+"\n";
		}
		SalesOutBillItem.setText(BillItem);
		
		
	}
	
	/**
	 * 显示财务单据详情
	 * @param vo
	 */
	public void ShowFinanceBillDetail(FinanceBillVO vo) {
		StockBillPane.setVisible(false);
		SalesInBillPane.setVisible(false);
		SalesOutBillPane.setVisible(false);
		FinanceBillPane.setVisible(true);
		
		FinanceBillId.setText(vo.getID());
		FinanceBillOperator.setText(vo.getOperator().getName());
		FinanceBillCustomer.setText(vo.getCustomerVO().getName());
		FinanceBillExamineManager.setText(vo.getManagerVO().getName());
		FinanceBillInitTime.setText(vo.getInit_time().toString());
		FinanceBillCommitTime.setText(vo.getCommit_time().toString());
		FinanceBillExamineTime.setText(vo.getApproval_time().toString());
		FinanceBillType.setText(vo.getType().toString());
		FinanceBillSum.setText(Double.toString(vo.getSum()));
		FinanceBillStatus.setText(vo.getStatus().toString());
		
		String BillItem = "";
		for(int i=0;i<vo.getList().size();i++) {
			BillItem = BillItem + vo.getList().get(i).accountVO.getName()+"    "+Double.toString(vo.getList().get(i).money)+"    "+vo.getList().get(i).ps+"\n";
		}
		FinanceBillItem.setText(BillItem);
	}
	/**
	 * 显示现金费用单详情
	 * @param vo
	 */
	public void ShowCashCostBillDetail(CashCostBillVO vo) {
		StockBillPane.setVisible(false);
		SalesInBillPane.setVisible(false);
		SalesOutBillPane.setVisible(false);
		FinanceBillPane.setVisible(true);
		//现金费用单和财务类单据共享同一个面板
		FinanceBillId.setText(vo.getID());
		FinanceBillOperator.setText(vo.getOperator().getName());
		FinanceBillCustomer.setText("---");
		FinanceBillExamineManager.setText(vo.getManager().getName());
		FinanceBillInitTime.setText(vo.getInit_time().toString());
		FinanceBillCommitTime.setText(vo.getCommit_time().toString());
		FinanceBillExamineTime.setText(vo.getApproval_time().toString());
		FinanceBillType.setText("现金费用单");
		FinanceBillSum.setText(Double.toString(vo.getSum()));
		FinanceBillStatus.setText(vo.getStatus().toString());
		
		String BillItem = "";
		for(int i=0;i<vo.getList().size();i++) {
			BillItem = BillItem + vo.getList().get(i).name+"    "+Double.toString(vo.getList().get(i).money)+"    "+vo.getList().get(i).ps+"\n";
		}
		FinanceBillItem.setText(BillItem);
		
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