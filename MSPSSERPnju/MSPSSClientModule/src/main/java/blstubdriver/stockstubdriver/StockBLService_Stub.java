package blstubdriver.stockstubdriver;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import util.ResultMessage;
import util.Time;
import vo.ChangeInfoVO;
import vo.StockInventoryVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:09 2017/11/11/011
 */
public class StockBLService_Stub implements StockBLInfo, StockBLService {
    /**
     * 更新库存信息
     *
     * @param change
     * @return
     */
    @Override
    public ResultMessage updateStock(ArrayList<ChangeInfoVO> change) {
        return null;
    }

    /**
     * 查看库存查看 返回
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<StockVO> viewStock(Time startTime, Time endTime) {
        return null;
    }

    /**
     * 库存盘点
     *
     * @return
     */
    @Override
    public ArrayList<StockInventoryVO> viewInventory() {
        return null;
    }

    @Override
    public ResultMessage exportToExcel(ArrayList<StockInventoryVO> stockInventoryVOS) {
        return null;
    }
}
