package commodity;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import org.junit.Test;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 17:54 2018/1/3/003
 */
public class CommodityTest {
    private static final CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();

    @Test
    public void test1() {
        FilterFlagVO filterFlagVO = new FilterFlagVO();
        filterFlagVO.setClassificationName("123456");
        ArrayList<CommodityVO> vos = commodityBLService.searchCommodity(filterFlagVO);
        System.out.println(vos.size());
        assertEquals(2, vos.size());
    }
}
