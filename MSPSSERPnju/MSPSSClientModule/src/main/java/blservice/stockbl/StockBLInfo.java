package blservice.stockbl;

import util.ResultMessage;
import vo.ChangeInfoVO;

import java.util.ArrayList;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:04 2017/11/11/011
 */
public interface StockBLInfo {
    /**
     * 更新库存信息
     * @param change
     * @return
     */
    public ResultMessage updateStock(ArrayList<ChangeInfoVO> change);

}
