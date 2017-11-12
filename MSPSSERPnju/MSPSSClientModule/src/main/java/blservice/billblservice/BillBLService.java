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

    public ResultMessage makeLessOrMoreBill(LessOrMoreBillVO lessOrMoreBillVO);

    public ResultMessage makePresentationBill(PresentationBillVO presentationBillVO);

    public ArrayList<AlarmBillVO> getAlarmBills();

    public ResultMessage makePurchaseBill(PurchaseVO prvo);

    public ResultMessage makePurchaseReturnBill(PurchaseReturnBillVO purchaseReturnBillVO);

    public ResultMessage makeSalesBill(SalesVO salesVO);

    public ResultMessage makeSalesReturnBill(SalesReturnVO salesReturnVO);

    public ResultMessage makePaymentAndReceiptBill(PaymentAndReceiptBillVO paymentAndReceiptBillVO);

    public ResultMessage makeCashBill(CashBillVO cashBillVO);

    public ArrayList<BillVO> getBills();
}
