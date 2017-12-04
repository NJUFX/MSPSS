package blimpl.stockblimpl;

import blservice.commodityblservice.CommodityInfoService;
import network.StockClientNetworkService;
import po.StockPO;
import util.ResultMessage;
import util.Time;
import vo.ChangeInfoVO;
import vo.StockVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:05 2017/11/18/018
 */
public class Stock {
    StockClientNetworkService networkService;
    CommodityInfoService infoService;
    public ResultMessage addStock(ArrayList<ChangeInfoVO> change){
        ResultMessage message;
        boolean success = false;
        for (int i = 0 ; i < change.size();i++){
            ChangeInfoVO vo = change.get(i);
            StockPO po = new StockPO(vo.info,vo.commodityID,vo.number,vo.Time,vo.price);
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
            StockVO vo = new StockVO(po.getInOrOut(),po.getNumber(),po.getPrice(),new Time(po.getTime()),infoService.getCommodity( po.getCommodityID()));
            vos.add(vo);
        }
        return vos;
    }
}
