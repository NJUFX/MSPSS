package billdataservicestubdriver;
/*
 *Created by Harper Liu on 17/10/22
 */

import java.util.ArrayList;

import billdataservice.BillDataService;
import po.BillPO;
import po.ConditionPO;

public class BillDataService_Stub implements BillDataService{
	//Test Constant
	BillPO Test_BillPO = new BillPO("0000001");
	ArrayList<BillPO> Test_BillPOList = new ArrayList<BillPO>();

	@Override
	public ArrayList<BillPO> search(ConditionPO Condition){
		Test_BillPOList.add(Test_BillPO);
		return Test_BillPOList;
	}
	
	@Override
	public void update(ArrayList<BillPO> billPOArray){
		billPOArray.clear();
		billPOArray.add(Test_BillPO);
	}
	
	@Override
	public void add(ArrayList<BillPO> billPOArray){
		billPOArray.add(Test_BillPO);
	}
	
	@Override
	public void delete(ArrayList<BillPO> billPOArray){
		billPOArray.clear();
	}
}
