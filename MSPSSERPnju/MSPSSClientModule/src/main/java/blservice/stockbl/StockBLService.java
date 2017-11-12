package blservice.stockbl;

import vo.InventoryVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:03 2017/11/11/011
 */
public interface StockBLService {
    /**
     * 查看库存查看 返回
     * @return
     */
    public Iterator<StockVO> viewStock(String startTime,String endTime);

    /**
     *  库存盘点
     * @return 返回当天的库存快照
     */
    public Iterator<InventoryVO> checkInventory();


}
