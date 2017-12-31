package blservice.stockbl;

import vo.StockVO;

import java.util.List;

import util.Time;
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


}
