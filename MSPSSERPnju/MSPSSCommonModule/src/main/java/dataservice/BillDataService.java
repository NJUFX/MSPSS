package billdataservice;

import java.util.ArrayList;

import po.BillPO;
import po.ConditionPO;

/**
 * Created by Harper Liu on 17/10/22
 */
public interface BillDataService {
	/*
	 * 搜索符合条件的BillPO
	 * 
	 * @return BillPO
	 * 
	 * @param ConditionVO
	 */

	public ArrayList<BillPO> search(ConditionPO Condition);

	/*
	 * 更新单据PO信息
	 * 
	 * @return
	 * 
	 * @param ArrayList<BillPO>
	 */
	
	public void update(ArrayList<BillPO> billPOArray);
	
	/*
	 * 增加一个单据PO信息
	 * 
	 * @return
	 * 
	 * @param ArrayList<BillPO>
	 */
	
	public void add(ArrayList<BillPO> billPOArray);
	
	/*
	 * 删除一个单据PO
	 * 
	 * @return
	 * 
	 * @param ArrayList<BillPO>
	 */
	
	public void delete(ArrayList<BillPO> billPOArray);
	
}
