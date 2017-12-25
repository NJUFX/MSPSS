package blservice.commodityblservice;

import util.ResultMessage;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 14:33 2017/11/11/011
 */
public interface CommodityInfoService {
    /**
     * 更新商品数据
     * @param cvo
     * @return
     */
    public ResultMessage updateCommodity(CommodityVO cvo);

    /**
     * 添加新的商品
     * @param cvo
     * @return
     */
    public ResultMessage addCommodity(CommodityVO cvo);

    /**
     *  获得商品信息
     * @param id
     * @return
     */
    public CommodityVO getCommodity(String id);

    public ArrayList<CommodityVO> search(FilterFlagVO vo);

    /**
     * 在进货后，根据商品的进货信息，更新商品的库存均价，以及最近进价
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    public ResultMessage updateCommodityByIn(String commodityID, int number, double price);

    /**
     * 售货后，根据商品的售出信息，更新库存数量，以及最近售价
     * 同时检测是否会出现库存报警现象
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    public ResultMessage updateCommodityByOut(String commodityID, int number, double price);
}
