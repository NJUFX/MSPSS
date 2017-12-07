package blservice.billblservice;

import po.PurchaseBillPO;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:56 2017/11/11/011
 */
public interface BillBLService {
    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillVO
     * @return
     */
    public ResultMessage addStockBill(StockBillVO stockBillVO);

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillVO
     * @return
     */
    public ResultMessage updateStockBill(StockBillVO stockBillVO);

    /**
     * 审批单据 本质上是在界面层更改了bill的状态为 approval 或 rejected
     *
     * @param stockBillVO
     * @return
     */
    public ResultMessage checkStockBill(StockBillVO stockBillVO);

}
