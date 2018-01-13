package blstubdriver.stockstubdriver;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.StockInventoryVO;
import vo.StockVO;

import java.util.List;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:09 2017/11/11/011
 */
public class StockBLService_Driver {
    private static final String startTime = "2017-10-01";
    private static final String endTime = "2017-11-11";
    private static final StockBLService stockblService = new StockBLService_Stub();
    private static final StockBLInfo stockblInfo = new StockBLService_Stub();

    @Test
    public void drive() {
        //1
        ResultMessage testMessage = stockblInfo.updateStock(null);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("update success");
        else
            System.out.println("update failed");

        //2

        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("update success");
        else
            System.out.println("update failed");

        //3
        List<StockVO> stockVOIterator = stockblService.viewStock(null, null);
        if (stockVOIterator == null)
            System.out.println("view failed");
        else
            System.out.println("view success");
        //4
        stockVOIterator = stockblService.viewStock(new Time(), new
                Time());
        if (stockVOIterator == null)
            System.out.println("view failed");
        else
            System.out.println("view success");
        //5
        List<StockInventoryVO> inventoryVOIterator = stockblService.viewInventory();
        if (inventoryVOIterator == null)
            System.out.println("check success");
        else
            System.out.println("check finished");

    }
}
