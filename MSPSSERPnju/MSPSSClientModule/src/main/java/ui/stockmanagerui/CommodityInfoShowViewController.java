package ui.stockmanagerui;

import auxiliary.stockmanager.CommodityTable;
import blimpl.commodityblimpl.MockCommodity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.CommodityVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class CommodityInfoShowViewController implements Initializable {
	Stage stage = StageSingleton.getStage();
	Dialog dialog = new Dialog();
	Stage newStage = new Stage();

	private CommodityTable commodityTable;

	public void setCommodityTable(CommodityTable commodityTable) {
		this.commodityTable = commodityTable;
	}

	// 获取id对应的商品详细信息
	// MockCommodity commodity = new MockCommodity();
	// CommodityVO commodityVO = commodity.getCommodity(commodityTable.getId());
	@FXML
	Button BackToLogin;
	@FXML
	Button commodityAddButton;
	@FXML
	Button commodityDelButton;
	@FXML
	Button commodityModButton;
	@FXML
	Button commoditySearchButton;
	@FXML
	Button backButton;

	@FXML
	Button delButton;
	@FXML
	Button modButton;

	@FXML
	Label name, id, type, category, purchasingPrice, sellingPrice, stockNumber, stockAlertNumber, recentPurchasingPrice,
			recentSellingPrice;
	// 名称，编号，型号，分类，进价，售价，库存数量，库存警戒值

	public void setView() {
		/*
		 * name.setText(commodityVO.getName()); id.setText(commodityVO.getID());
		 * type.setText(commodityVO.getType());
		 * //category.setText(commodityVO.setClassificationVO());
		 * purchasingPrice.setText(String.valueOf(commodityVO.getImportCost()));
		 */
	}

	/**
	 * 删除当前的商品，返回商品列表
	 *
	 * @param e
	 */
	@FXML
	public void delButtonAction(ActionEvent e) {
		try {
			//System.out.println("test");
			CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
					"/view/stockmanager/CommoditySearchShow.fxml");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		dialog.infoDialog("Delete the commodity successfully.");
	}

	/**
	 * 修改商品按钮跳转
	 *
	 * @param e
	 */
	@FXML
	public void modButtonAction(ActionEvent e) {
		try {
			System.out.println("test");
			//CommodityInfoModifyViewController controller = (CommodityInfoModifyViewController) replaceSceneContent("/view/stockmanager/CommodityInfoModify.fxml");
			CommodityInfoModifyViewController controller = (CommodityInfoModifyViewController) replaceAnotherSceneContent(
					"/view/stockmanager/CommodityInfoModify.fxml", 415, 421);
			System.out.println("test");
		} catch (Exception e1) {
			e1.printStackTrace();
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
			CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
					"/view/stockmanager/commoditySearchShow.fxml");
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
	 * 修改商品
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
	 * 查找商品
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void commoditySearchButtonAction(ActionEvent e) throws IOException {
		try {
			CommoditySearchShowViewController controller = (CommoditySearchShowViewController) replaceSceneContent(
					"/view/stockmanager/commoditySearchShow.fxml");
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
	 * @param fxml
	 * @param width
	 * @param height
	 * @return
	 * @throws Exception
	 */
	private Initializable replaceAnotherSceneContent(String fxml, double width, double height) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = MainApp.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(MainApp.class.getResource(fxml));
		Pane page;
		try {
			page = (Pane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page, width, height);
		newStage.setTitle("MSPSS");
		newStage.setScene(scene);
		newStage.sizeToScene();
		newStage.setResizable(false);
		newStage.show();
		return (Initializable) loader.getController();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		this.setView();
	}
}
