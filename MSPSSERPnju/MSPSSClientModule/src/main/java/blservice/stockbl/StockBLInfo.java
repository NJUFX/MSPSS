package blservice.stockbl;

import util.ResultMessage;
import vo.BillVO;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:04 2017/11/11/011
 */
public interface StockBLInfo {
    /**
     * 更新库存信息
     * @param billVO
     * @return
     */
    public ResultMessage updateStockAndInventory(BillVO billVO);

}
