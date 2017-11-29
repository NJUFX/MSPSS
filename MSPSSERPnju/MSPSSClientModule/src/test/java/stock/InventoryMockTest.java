package stock;

import blimpl.stockblimpl.Inventory;
import blimpl.stockblimpl.MockInventory;
import org.junit.Assert;
import org.junit.Test;
import util.ResultMessage;
import vo.CommodityStockVO;

import java.util.Date;

/**
 * Description:
 * Created by Hanxinhu at 10:05 2017/11/22/022
 */
public class InventoryMockTest {
    private Inventory inventory = new MockInventory();
    private CommodityStockVO commodityStockVO = new CommodityStockVO("","",1,1,"","", new Date());

    @Test
    public void a_add(){
        ResultMessage message =  inventory.addInventory(null);
        Assert.assertEquals(message,ResultMessage.SUCCESS);
    }
    @Test
    public void b_update(){
        ResultMessage message = inventory.updateInventory(null);
        Assert.assertEquals(message,ResultMessage.SUCCESS);
    }

}
