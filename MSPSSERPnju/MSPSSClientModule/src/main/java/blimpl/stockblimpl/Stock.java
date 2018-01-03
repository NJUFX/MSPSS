package blimpl.stockblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityInfoService;
import network.StockClientNetworkImpl;
import network.StockClientNetworkService;
import po.StockPO;
import util.ResultMessage;
import util.StockInfo;
import util.Time;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:05 2017/11/18/018
 */
public class Stock {
    StockClientNetworkService networkService = new StockClientNetworkImpl();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    public ResultMessage addStock(ArrayList<ChangeInfoVO> change){
        ResultMessage message;
        boolean success = false;
        for (int i = 0 ; i < change.size();i++){
            ChangeInfoVO vo = change.get(i);
            StockPO po = new StockPO(vo.info.ordinal(),vo.commodityID,vo.number,vo.Time,vo.price);
            message = networkService.addStock(po);
            if (message!=ResultMessage.SUCCESS)
                success =false;
        }
        if (success)
            return ResultMessage.SUCCESS;
        else
            return ResultMessage.FAILED;
    }
    public ArrayList<StockVO> viewStock(String startTime, String endTime){

        ArrayList<StockPO> pos= networkService.rangeSearchStock("time",startTime,endTime);
        ArrayList<StockVO> vos = new ArrayList<>();
        for (StockPO po : pos){
            StockVO vo = new StockVO(StockInfo.values()[po.getInOrOut()], po.getNumber(), po.getPrice(), new Time(po.getTime()), commodityInfoService.getCommodity(po.getCommodityID()));
            vos.add(vo);
        }
        return vos;
    }

    public ArrayList<StockInventoryVO> viewInventory() {
        FilterFlagVO filterFlagVO = new FilterFlagVO();
        filterFlagVO.setImportCostMin(0);
        filterFlagVO.setImportCostMax(Integer.MAX_VALUE);
        ArrayList<CommodityVO> pos = commodityInfoService.search(filterFlagVO);
        ArrayList<StockInventoryVO> stockInventoryVOS = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            CommodityVO vo = pos.get(i);
            stockInventoryVOS.add(new StockInventoryVO(vo.getName(), vo.getNumberInStock(), vo.getImportCost()));
        }
        return stockInventoryVOS;
    }
}
