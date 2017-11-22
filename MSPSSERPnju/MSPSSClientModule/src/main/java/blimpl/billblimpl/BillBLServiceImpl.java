package blimpl.billblimpl;

import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl implements BillBLService,BillBLInfo {
    @Override
    public ResultMessage makeAlarmBill(AlarmBillVO alarmBillVO) {
        return null;
    }

    @Override
    public ResultMessage makeLessOrMoreBill(LessOrMoreBillVO lessOrMoreBillVO) {
        return null;
    }

    @Override
    public ResultMessage makePresentationBill(PresentationBillVO presentationBillVO) {
        return null;
    }

    @Override
    public ArrayList<AlarmBillVO> getAlarmBills() {
        return null;
    }

    @Override
    public ResultMessage makePurchaseBill(PurchaseVO prvo) {
        return null;
    }

    @Override
    public ResultMessage makePurchaseReturnBill(PurchaseReturnBillVO purchaseReturnBillVO) {
        return null;
    }

    @Override
    public ResultMessage makeSalesBill(SalesVO salesVO) {
        return null;
    }

    @Override
    public ResultMessage makeSalesReturnBill(SalesReturnVO salesReturnVO) {
        return null;
    }

    @Override
    public ResultMessage makePaymentAndReceiptBill(PaymentAndReceiptBillVO paymentAndReceiptBillVO) {
        return null;
    }

    @Override
    public ResultMessage makeCashBill(CashBillVO cashBillVO) {
        return null;
    }

    @Override
    public ArrayList<BillVO> getBills() {
        return null;
    }
}
