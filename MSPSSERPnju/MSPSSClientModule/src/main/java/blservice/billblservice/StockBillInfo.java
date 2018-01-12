package blservice.billblservice;

import util.ResultMessage;
import vo.PresentationCommodityItemVO;

import java.util.List;

/**
 * Description: 为了在系统内产生库存赠送单又不产生耦合
 * Created by Hanxinhu at 13:55 2017/12/28/028
 */
public interface StockBillInfo {
    public ResultMessage addStockPresentationBill(List<PresentationCommodityItemVO> list, String ps);
}
