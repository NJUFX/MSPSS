package blstubdriver.stockstubdriver;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import org.junit.Test;
import util.ResultMessage;
import vo.BillVO;
import vo.InventoryVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:09 2017/11/11/011
 */
public class StockBLService_Driver {
    private static final String startTime = "2017-10-01";
    private static final String endTime = "2017-11-11";
    private static final StockBLService stockblService =new StockBLService_Stub();
    private static final StockBLInfo stockblInfo = new StockBLService_Stub();
    private static final BillVO bv = new BillVO("1",true,true);
    @Test
    public void drive(){
        //1
        ResultMessage testMessage = stockblInfo.updateStockAndInventory(bv);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("update success");
        else
            System.out.println("update failed");

        //2
        testMessage = stockblInfo.updateStockAndInventory(null);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("update success");
        else
            System.out.println("update failed");

        //3
        Iterator<StockVO> stockVOIterator =stockblService.viewStock(null,null);
        if (stockVOIterator==null)
            System.out.println("view failed");
        else
            System.out.println("view success");
        //4
        stockVOIterator = stockblService.viewStock(startTime,endTime);
        if (stockVOIterator==null)
            System.out.println("view failed");
        else
            System.out.println("view success");
        //5
        Iterator<InventoryVO> inventoryVOIterator = stockblService.checkInventory();
        if (inventoryVOIterator==null)
            System.out.println("check success");
        else
            System.out.println("check finished");

    }
}
