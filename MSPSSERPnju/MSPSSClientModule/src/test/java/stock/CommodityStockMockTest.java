package stock;

import org.junit.Assert;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.CommodityStockVO;

/**
 * Description:
 * Created by Hanxinhu at 10:05 2017/11/22/022
 */
public class CommodityStockMockTest {
    private CommodityStock commodityStock = new MockCommodityStock();
    private CommodityStockVO commodityStockVO = new CommodityStockVO(null,1,1,"","", new
            Time(1,1,1,1,1,1));

    @Test
    public void a_add(){
        ResultMessage message =  commodityStock.addCommodityStock(null);
        Assert.assertEquals(message,ResultMessage.SUCCESS);
    }
    @Test
    public void b_update(){
        ResultMessage message = commodityStock.addCommodityStock(null);
        Assert.assertEquals(message,ResultMessage.SUCCESS);
    }

}
