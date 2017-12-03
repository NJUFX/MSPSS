package blimpl.commodityblimpl;

import vo.CommodityVO;

import java.util.Comparator;

/**
 * Description:
 * Created by Hanxinhu at 23:15 2017/11/15/015
 */
public class StockAscendingComparator implements Comparator<CommodityVO> {
    @Override
    public int compare(CommodityVO o1, CommodityVO o2) {
        if(o1.numberInStock>o2.numberInStock){
            return 1;
        }
        if(o1.numberInStock<o2.numberInStock){
            return -1;
        }
        return 0;
    }
}
