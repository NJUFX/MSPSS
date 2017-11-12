package blservice.commodityblservice;

import util.ResultMessage;
import vo.CommodityVO;

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
}
