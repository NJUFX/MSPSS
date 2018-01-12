package blimpl.commodityblimpl;

import blservice.billblservice.BillBLInfo;
import network.CommodityClientNetworkImpl;
import network.CommodityClientNetworkService;
import po.CommodityPO;
import util.ResultMessage;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:13 2017/11/15/015
 */
public class Commodity {
    private static CommodityClientNetworkService netService = new CommodityClientNetworkImpl();
    private static BillBLInfo billBLInfo = blimpl.billblimpl.BillFactory.getBillBLInfo();
    /**
     * 添加商品
     * @param commodityVO
     * @return
     */
    public ResultMessage addCommodity(CommodityVO commodityVO){
        //此时的ID为空
        CommodityPO po = vo_to_po(commodityVO);

        ArrayList<CommodityPO> pos = netService.fullSearchCommodity("classificationID", commodityVO.classificationName);
        int max = 0;
        for (int i = 0; i < pos.size(); i++) {
            String[] strings = pos.get(i).getID().split("-");
            int x = Integer.parseInt(strings[1]);
            if (x > max) {
                max = x;
            }
        }
        String ID = commodityVO.getClassificationName() + "-" + (max + 1);
        po.setID(ID);
        commodityVO.setID(po.getID());

        return netService.addCommodity(po);
    }

    /**
     * 更新商品信息
     * @param commodityVO
     * @return
     */
    public ResultMessage updateCommodity(CommodityVO commodityVO){
        CommodityPO po = vo_to_po(commodityVO);
        return netService.modifyCommodity(po);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    public ResultMessage deleteCommodity(String id){
        CommodityPO po = netService.exactlySearchCommodity(id);
        //该商品已经有了使用记录
        if (po.isUsed())
            return ResultMessage.FAILED;

        return netService.deleteCommodity(po);
    }

    /**
     * 通过商品ID得到商品信息
     * @param id
     * @return
     */
    public CommodityVO getCommodity(String id){

        CommodityPO po = netService.exactlySearchCommodity(id);
        if (po != null) {
            CommodityVO vo = po_to_vo(po);
            return vo;
        }
        return null;
    }

    /**
     * @param vo
     * @return
     */
    public CommodityPO vo_to_po(CommodityVO vo) {

        return new CommodityPO(vo.getName(), vo.getClassificationName(), vo.getType(), vo.getID(), vo.getImportCost()
                , vo.getExportCost(), vo.getLatestImportCost(), vo.getLatestExportCost(), vo.getNumberInStock(), vo.getAlertNumber());
    }
    /**
     * 将商品的PO转化为VO
     * @param po
     * @return
     */
    public CommodityVO po_to_vo(CommodityPO po){
        CommodityVO vo = new CommodityVO(po.getName(),po.getID(),po.getType(),po.getImportCost(),po.getExportCost(),
                po.getNumberInStock());
        vo.setAlertNumber(po.getAlertNumber());
        return vo;
    }
    /**
     * 搜索商品
     * @param flag
     * @return
     */
    public ArrayList<CommodityVO> searchCommodity(FilterFlagVO flag){
            ArrayList<CommodityPO> commodities = new ArrayList<>();
            if (flag.classificationName !=null){
                commodities.addAll(netService.fullSearchCommodity("classificationID", flag.classificationName));
            }
            if (flag.id!=null){
                commodities.addAll(netService.fuzzySearchCommodity("ID", flag.id));
            }
            if (flag.name!=null){
                commodities.addAll(netService.fuzzySearchCommodity("name",flag.name));
            }
            if (flag.exportCostMax !=0||flag.exportCostMin !=0){
                commodities.addAll(netService.rangeSearchCommodity("exportCost",flag.exportCostMin,flag.exportCostMax));
            }
            if (flag.importCostMax!=0||flag.importCostMin!=0){
                commodities.addAll(netService.rangeSearchCommodity("importCost",flag.importCostMin,flag.importCostMax));
            }

            ArrayList<CommodityVO> vos = new ArrayList<>();
            for (int i = 0 ; i < commodities.size() ;i++){
                vos.add(po_to_vo(commodities.get(i)));
            }
        return vos;}


    /**
     * 按照进价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceAscendingSort(ArrayList< CommodityVO> vos){
         vos.sort(new BuyPriceAscendingComparator());
         return vos;
    }

    /**
     * 按照进价降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceDescendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new BuyPriceDescendingComparator());
        return vos;
    }

    /**
     * 按照售价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceAscendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new SellPriceAscendingComparator());
        return vos;
    }

    /**
     * 按照售价降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceDescendingSort(ArrayList< CommodityVO> vos)
    {   vos.sort(new SellPriceDescendingComparator());
        return vos;
    }

    /**
     * 按照库存数量降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockDescendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new StockAscendingComparator());
        return vos;
    }

    /**
     * 按照库存数量升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockAscendingSort(ArrayList< CommodityVO> vos){
        vos.sort(new StockDescendingComparator());
        return vos;
    }

    /**
     * 在进货后，根据商品的进货信息，更新商品的库存均价，以及最近进价
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    public ResultMessage updateCommodityByIn(String commodityID, int number, double price) {
        CommodityPO po = netService.exactlySearchCommodity(commodityID);
        po.setLatestImportCost(price);
        double currentPrice = (po.getNumberInStock() * po.getImportCost() + number * price) / (po.getNumberInStock()
                + number);
        po.setImportCost(currentPrice);
        po.setNumberInStock(po.getNumberInStock() + number);
        return netService.modifyCommodity(po);
    }

    /**
     * 售货后，根据商品的售出信息，更新库存数量，以及最近售价
     * 同时检测是否会出现库存报警现象
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    public ResultMessage updateCommodityByOut(String commodityID, int number, double price) {
        CommodityPO po = netService.exactlySearchCommodity(commodityID);
        po.setLatestExportCost(price);
        double currentPrice = (price * number + po.getNumberInStock() * po.getExportCost()) / (number + po.getNumberInStock());
        po.setExportCost(currentPrice);
        po.setNumberInStock(po.getNumberInStock() - number);
        //如果当期库存值小于等于库存报警值 产生库存报警单
        if (po.getNumberInStock() < po.getAlertNumber())
            billBLInfo.addAlarmBill(commodityID, po.getNumberInStock());

        return netService.modifyCommodity(po);
    }


}
