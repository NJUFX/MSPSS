package blstubdriver.billstubdriver;

import blservice.billblservice.SalesmanBillBLService;
import exception.initclassexception.KeyColumnLostException;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 8:31 2017/12/13/013
 */
public class SalesmanStub implements SalesmanBillBLService {
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesInBill(SalesInBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesInBill(SalesInBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesInBill(SalesInBillVO vo) {
        return null;
    }

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo) {
        return null;
    }

    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID) {
        return null;
    }

    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        return null;
    }

    /**
     * 撤回自己的销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 根据订单内容返回合适的客户促销策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> searchCustomerPromotion(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 根据订单内容返回合适的特价包策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> searchGroupPromotion(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 根据订单内容返回合适的满减策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> searchGrossPromotion(SalesOutBillVO vo) {
        return null;
    }

    /**
     * 对一个销售单设置针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 对一个销售单设置针对满额的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 对一个销售单使用特价包的销售策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 对于一个销售单取消使用针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 对一个销售单取消使用针对满减的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 对一个销售单取消使用针对组合包的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return null;
    }
}
