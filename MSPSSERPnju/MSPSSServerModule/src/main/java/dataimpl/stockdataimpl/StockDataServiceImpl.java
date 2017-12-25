package dataimpl.stockdataimpl;

import datahelper.DataHelper;
import dataservice.StockDataService;
import po.StockPO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class StockDataServiceImpl implements StockDataService{
    private DataHelper<StockPO> stockHelper;

    protected StockDataServiceImpl(DataHelper<StockPO> stockHelper){
        this.stockHelper = stockHelper;
    }

    /**
     * 得到需要时间范围内的进出库信息
     *
     * @return
     */
    public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max){

          return  stockHelper.rangeQuery(filed, min, max);

    }



    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return ResultMessage
     */
    public ResultMessage addStock(StockPO stockPO){
        try{
            stockHelper.save(stockPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.FAILED;
        }

    }
}
