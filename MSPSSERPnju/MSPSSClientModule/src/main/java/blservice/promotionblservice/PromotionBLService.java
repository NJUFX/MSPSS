package blservice.promotionblservice;

import java.util.ArrayList;
import util.ResultMessage;

/**
 * 
 * Created by Harper on 17/11/12
 */
public interface PromotionBLService {
	
/**
 * 增加一条促销策略
 * 
 * @param PromotionPO
 * @return ResultMessage
 */
	public ResultMessage add(Promotion PO promotionPO);
	
/**
 * 删除一条促销策略
 * 
 * @param id
 * @return ResultMessage
 */
	public ResultMessage delete(String id);
	
/**
 * 更新一条促销策略
 * 
 * @param id
 * @param PromotionPO
 * @return ResultMessage
 */
	public ResultMessage update(String id,PromotionPO promotionPO);
	
/**
 * 搜索所有有效的促销策略
 * 
 * @param Time
 * @return ArrayList<PromotionPO>
 */
	public ArrayList<PromotionPO> search(Time date);
}
