package blstubdriver.chiefmanagerstubdriver;

import java.util.ArrayList;

import blservice.chiefmanagerblservice.ChiefManagerBLService;
import po.SalesBillPO;
import po.UserPO;
import vo.BillListVO;
import vo.BillVO;
import vo.ListVO;
import vo.LogListVO;
import vo.LogVO;
import vo.ManageListVO;
import vo.PromotionListVO;
import vo.PromotionVO;
import vo.SalesListVO;

/**
 * Created by HarperLiu on 17/10/19
 */
public class ChiefManager_Stub implements ChiefManagerBLService {
	// Constants
	SalesBillPO Test_SalesBillPO = new SalesBillPO("17/10/20", "Book", "CustomerA", "SalesmanA", "WarehouseA",
			"ISBN0001", 10, 20.0);
	UserPO Test_UserPO = new UserPO("0000001", "TestName", true,true,true,true);
	ManageListVO Test_ManageListVO = new ManageListVO("17/10/20", 200.0, 50.0, 50.0);
	LogVO Test_LogVO = new LogVO(000001, "TestLog");
	LogVO[] Test_LogList = { Test_LogVO };
	LogListVO Test_LogListVO = new LogListVO(1, Test_LogList);
	BillVO Test_BillVO = new BillVO("000001", false,false);
	BillVO[] Test_BillVOList = { Test_BillVO };
	BillListVO Test_BillListVO = new BillListVO(1, Test_BillVOList);
	PromotionVO Test_PromotionVO = new PromotionVO("分级赠送赠品","17/10/20");
	PromotionVO[] PromotionVOList = {Test_PromotionVO};
	PromotionListVO Test_PromotionListVO = new PromotionListVO(PromotionVOList);
	// Stub
	public boolean checkLimit(String id, String serviceType) {
		if (id.equals(Test_UserPO.getId()) && serviceType.equals("makeLists")) {
			return true;
		}
		return false;
	}

	public boolean exportList(ListVO listVO) {
		if (listVO != null) {
			return true;
		}
		return false;
	}

	public boolean emptyCondition() {
		return true;
	}

	public void exit() {
	}

	public SalesListVO makeSalesList(String time, String commodityName, String customerName, String salesmanName,
			String warehouseName) {
		double totalPrice = Test_SalesBillPO.getAmount() * Test_SalesBillPO.getUnitPrice();
		SalesListVO TestSalesListVO = new SalesListVO(Test_SalesBillPO.getBillId(), Test_SalesBillPO.getCommodityName(),
				Test_SalesBillPO.getModelId(), Test_SalesBillPO.getAmount(), Test_SalesBillPO.getUnitPrice(),
				totalPrice);
		return TestSalesListVO;
	}

	public ManageListVO makeManageList(String time) {
		return Test_ManageListVO;
	}

	public LogListVO showLogList() {
		return Test_LogListVO;
	}

	public LogVO showLogDetail(int id) {
		return Test_LogVO;
	}

	public BillListVO showBillList(boolean isExamined) {
		if (Test_BillListVO.getBillVO()[0].getIsExamined() == false) {
			return Test_BillListVO;
		} 
		else {
			return null;
		}
	}

	public ArrayList<BillVO> changeBillState(ArrayList<BillVO> billVOArray, boolean pass) {
		billVOArray.get(0).setIsExamined(true);
		billVOArray.get(0).setState(true);
		return billVOArray;
	}

	public void updateBillData(ArrayList<BillVO> billVOArray) {
	}

	public BillVO showBillDetail(String id) {
        if(id.equals(Test_BillVO.getBillId())){
		return Test_BillVO;
        }
        else{
        	return null;
        }
	}

	public PromotionVO choosePromotionType(String type) {
		if(type.equals(Test_PromotionVO.getType())){
		return Test_PromotionVO;
		}
		else{
			return null;
		}
	}

	public PromotionVO setPromotionTime(PromotionVO promotionVO) {
		promotionVO.setTime("17/10/20");
		return promotionVO;
	}

	public boolean checkPromotionInfo(PromotionVO promotionVO) {
		if(promotionVO.getTime().equals("17/10/21")){
		return true;
		}
		else{
			return false;
		}
	}

	public PromotionListVO ShowPromotionList() {
		if(Test_PromotionListVO.getCurrentPromotion()[0]!=null){
		return Test_PromotionListVO;
		}
		else{
			return null;
		}
	}

	public void updatePromotionInfo(PromotionVO promotionVO) {
	}

}
