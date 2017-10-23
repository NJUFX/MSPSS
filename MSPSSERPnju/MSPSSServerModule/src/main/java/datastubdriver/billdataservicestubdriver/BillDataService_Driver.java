package billdataservicestubdriver;

import java.util.ArrayList;

import org.junit.Test;

import po.BillPO;
import po.ConditionPO;

/*
 * Created by Harper Liu on 17/10/22
 */
public class BillDataService_Driver {
//Test Constant
	BillPO Test_BillPO = new BillPO("0000002");
	ArrayList<BillPO> Test_BillPOList = new ArrayList<BillPO>();
	BillDataService_Stub BillDataService = new BillDataService_Stub();
	ConditionPO Test_ConditionPO = new ConditionPO("库存赠送单","17/10/22","000003",null);
	
	@Test
	public void drive(){
		//1
		    ArrayList<BillPO> TestResult1 = BillDataService.search(Test_ConditionPO);
		    if(TestResult1!=null){
		    	System.out.println("Search Succeed!");
		    }
		    else{
		    	System.out.println("Search Failed!");
		    }
		//2
		    BillDataService.update(Test_BillPOList);
		    if(Test_BillPOList.get(0).getBillId().equals("0000001")){
		    	System.out.println("Update Succeed!");
		    }
		    else{
		    	System.out.println("Update Failed!");
		    }
		    Test_BillPOList.clear();
		//3
		    BillDataService.add(Test_BillPOList);
		    if(Test_BillPOList.size()!=0){
		    	System.out.println("Add Succeed!");
		    }
		    else{
		    	System.out.println("Add Failed");
		    }
		//4
		    BillDataService.delete(Test_BillPOList);
		    if(Test_BillPOList.size()==0){
		    	System.out.println("Delete Succeed!");
		    }
		    else{
		    	System.out.println("Delete Failed");
		    }
	}
}
