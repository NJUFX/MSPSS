package blservice.billblservice;

import exception.initclassexception.KeyColumnLostException;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 11:45 2017/12/19/019
 */
public interface SalesmanBillBLService {
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesInBill(SalesInBillVO vo)throws KeyColumnLostException;

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesInBill(SalesInBillVO vo)throws KeyColumnLostException;

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesInBill(SalesInBillVO vo);

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo);
    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID);

    /**
     * 添加销售单
     *  保存
     * @param vo
     * @return
     */
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo);

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo);

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo);

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID);

    /**
     * 撤回自己的销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo);

    /**
     * 根据订单内容返回合适的客户促销策略
     *
     * @param vo
     * @return
     */
    public ArrayList<CustomerPromotionVO> searchCustomerPromotion(SalesOutBillVO vo);

    /**
     * 根据订单内容返回合适的特价包策略
     *
     * @param vo
     * @return
     */
    public ArrayList<GroupPromotionVO> searchGroupPromotion(SalesOutBillVO vo);

    /**
     * 根据订单内容返回合适的满减策略
     *
     * @param vo
     * @return
     */
    public ArrayList<GrossPromotionVO> searchGrossPromotion(SalesOutBillVO vo);

    /**
     * 对一个销售单设置针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO);

    /**
     * 对一个销售单设置针对满额的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO);

    /**
     * 对一个销售单使用特价包的销售策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO);

    /**
     * 对于一个销售单取消使用针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO);

    /**
     * 对一个销售单取消使用针对满减的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO);

    /**
     * 对一个销售单取消使用针对组合包的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO);


}
