package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.stockmanager.Log;
import blimpl.blfactory.BLFactoryImpl;
import blimpl.logblimpl.LogBLServiceImpl;
import blservice.logblservice.LogBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.Time;
import vo.LogVO;

public class ChiefManagerReadLogController implements Initializable {
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
	DatePicker StartTime;
	@FXML
	DatePicker EndTime;
	@FXML 
	TableView<Log> LogTable;
	@FXML 
	Button Search;
	@FXML 
	Button Clear;
	

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
	 * public void SetTags(String name,String Role,String id) {
	 * NameTag.setText(name); RoleTag.setText(Role); IdTag.setText(id); }
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
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
		try {
			LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
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
	 * 根据日期查询日志
	 * 
	 * @param e
	 * @throws Exception
	 */
	public void handleSearchButtonAction(ActionEvent e) throws Exception{
		LocalDate startTime = StartTime.getValue();
		LocalDate endTime = EndTime.getValue();
		LogBLService logblservice =  new BLFactoryImpl().getLogBLService();
		Time start = new Time(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0,0);
		Time end = new Time(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth(),0,0,0);
		ArrayList<LogVO> logList = logblservice.timeSearchLog(start, end);
		ObservableList<Log> data = LogTable.getItems();
		for(int i=0;i<logList.size();i++) {
			LogVO temp = logList.get(i);
			String timeTemp = temp.getTime().toString();
			data.add(new Log(temp.getId(),temp.getOperator(),timeTemp,temp.getOperate()));
		}
		
	}
	
	/**
	 * 清空当前日志
	 * @param e
	 * @throws Exception
	 */
	public void handleClearButtonAction(ActionEvent e) throws Exception{
		ObservableList<Log> data = LogTable.getItems();
		data.clear();
	}
	
	
}
