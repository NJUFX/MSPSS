package blservice.stockbl;

import util.ResultMessage;
import util.Time;
import vo.StockInventoryVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.List;
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
     * @param startTime
     * @param endTime
     */
    public List<StockVO> viewStock(Time startTime, Time endTime);

    /**
     * 库存盘点
     *
     * @return
     */
    public ArrayList<StockInventoryVO> viewInventory();

    public ResultMessage exportToExcel(ArrayList<StockInventoryVO> stockInventoryVOS);
}
