package chiefmanagerstubdriver;
import java.util.ArrayList;

import org.junit.*;

import vo.BillListVO;
import vo.BillVO;
import vo.ListVO;
import vo.LogListVO;
import vo.LogVO;
import vo.ManageListVO;
import vo.PromotionListVO;
import vo.PromotionVO;
import vo.SalesListVO;

public class ChiefManager_Driver {
	//Test Constant
	
	ChiefManager_Stub chiefManagerBLService = new ChiefManager_Stub();
	ListVO Test_ListVO = new ListVO("17/10/19");
	ArrayList<BillVO> billVOArr = new ArrayList<BillVO>();
	BillVO Test_BillVO = new BillVO("000001", false,false);
	PromotionVO Test_PromotionVO = new PromotionVO("分级赠送赠品","17/10/21");
	@Test
	public void drive(){
	//1
		boolean TestResult1 = chiefManagerBLService.checkLimit("0000001","makeLists");
	    if(TestResult1==true){
	    	System.out.println("Check Limit Succeed!");
	    }
	    else{
	    	System.out.println("Check Limit Failed");
	    }
	//2
	    boolean TestResult2 = chiefManagerBLService.exportList(Test_ListVO);
	    if(TestResult2==true){
	    	System.out.println("Export List Succeed!");
	    }
	    else{
	    	System.out.println("Export List Failed!");
	    }
	//3
	    boolean TestResult3 = chiefManagerBLService.emptyCondition();
	    if(TestResult3==true){
	    	System.out.println("Empty Condition Succeed!");
	    }
	    else{
	    	System.out.println("Empty Condition Failed!");
	    }
	//4
	    System.out.println("Exit Succeed!");
	//5
	    SalesListVO TestResult5 = chiefManagerBLService.makeSalesList("17/10/20","Book","CustomerA","SalesmanA","WarehouseA");
	    if(TestResult5.getTotalPrice()==200.0){
	    	System.out.println("Make SalesList Succeed!");
	    }
	    else{
	    	System.out.println("Make SalesList Failed!");
	    }
	//6
	    ManageListVO TestResult6 = chiefManagerBLService.makeManageList("17/10/20");
	    if(TestResult6.getProfit()==100.0){
	    	System.out.println("Make ManageList Succeed!");
	    }
	    else{
	    	System.out.println("Make ManageList Failed!");
	    }
	//7
	    LogListVO TestResult7 = chiefManagerBLService.showLogList();
	    if(TestResult7.getLogList()[0].getLogText().equals("TestLog")){
	    	System.out.println("Show LogList Succeed!");
	    }
	    else{
	    	System.out.println("Show LogList Failed!");
	    }
	//8
	    LogVO TestResult8 = chiefManagerBLService.showLogDetail(0000001);
	    if(TestResult8.getLogText().equals("TestLog")){
	    	System.out.println("Show LogDetail Succeed!");
	    }
	    else{
	    	System.out.println("Show LogDetail Failed!");
	    }
	//9
	    BillListVO TestResult9 = chiefManagerBLService.showBillList(false);
	    if(TestResult9!=null){
	    	System.out.println("Show Bill List Succeed!");
	    }
	    else{
	    	System.out.println("Show Bill List Failed!");
	    }
	//10
	    billVOArr.add(Test_BillVO);
	    ArrayList<BillVO> TestResult10 = chiefManagerBLService.changeBillState(billVOArr, true);
	    if(TestResult10.get(0).getState()==true){
	    	System.out.println("Change Bill State Succeed!");
	    }
	    else{
	    	System.out.println("Change Bill State Failed!");
	    }
	//11
	    System.out.println("Update Bill Data Succeed!");
	//12
	    BillVO TestResult12 = chiefManagerBLService.showBillDetail("000001");
	    if(TestResult12!=null){
	    	System.out.println("Show Bill Detail Succeed!");
	    }
	    else{
	    	System.out.println("Show Bill Detail Failed!");
	    }
	//13
	    PromotionVO TestResult13 = chiefManagerBLService.choosePromotionType("分级赠送赠品");
	    if(TestResult13!=null){
	    	System.out.println("Choose Promotion Type Succeed!");
	    }
	    else{
	    	System.out.println("Choose Promotion Type Failed!");
	    }
	//14
	    PromotionVO TestResult14 = chiefManagerBLService.setPromotionTime(Test_PromotionVO);
	    if(TestResult14.getTime().equals("17/10/20")){
	    	System.out.println("Set Promotion Time Succeed!");
	    }
	    else{
	    	System.out.println("Set Promotion Time Failed!");
	    }
	//15
	    boolean TestResult15 = chiefManagerBLService.checkPromotionInfo(Test_PromotionVO);
	    if(TestResult15==true){
	    	System.out.println("Check PromotionInfo Succeed!");
	    }
	    else{
	    	System.out.println("Check PromotionInfo Failed!");
	    }
	//16
	    PromotionListVO TestResult16 =  chiefManagerBLService.ShowPromotionList();
	    if(TestResult16!=null){
	    	System.out.println("Show Promotion List Succeed!");
	    }
	    else{
	    	System.out.println("Show Promotion List Failed!");
	    }
	} 

}
