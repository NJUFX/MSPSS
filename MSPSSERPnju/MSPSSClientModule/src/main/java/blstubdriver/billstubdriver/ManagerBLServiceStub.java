package blstubdriver.billstubdriver;

import blimpl.billblimpl.FinanceBill;
import blservice.billblservice.ManagerBillBLService;
import util.*;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:13 2017/12/15/015
 */
public class ManagerBLServiceStub implements ManagerBillBLService {
   private static final CommodityVO commodity1 = new CommodityVO("LED灯","12138","IEEE-0001",10,10,100);
   private static final CommodityVO commodity2 = new CommodityVO("LED灯","12138","IEEE-0002",10,11,110);
   private static final CommodityVO commodity3 = new CommodityVO("LED灯","12138","IEEE-0003",10,12,120);
   private static final CommodityVO commodity4 = new CommodityVO("LED灯","12138","IEEE-0004",10,13,130);
   private static final CommodityVO commodity5 = new CommodityVO("LED灯","12138","IEEE-0005",10,14,140);
   private static final CommodityVO commodity6 = new CommodityVO("LED灯","12138","IEEE-0006",10,15,150);
   private static final CommodityVO commodity7 = new CommodityVO("LED灯","12138","IEEE-0007",10,16,160);
   private static final CommodityVO commodity8 = new CommodityVO("LED灯","12138","IEEE-0008",10,17,170);
   private static final CommodityVO commodity9 = new CommodityVO("LED灯","12138","IEEE-0009",10,18,180);
   private static final UserVO stockManager = new UserVO("sm","hanxinhu", Kind_Of_Users.StockManager,"111","121");
   private static final UserVO manager = new UserVO("sm","hanxinhu", Kind_Of_Users.StockManager,"111","121");
   private static final CustomerVO customer = new CustomerVO("1",Kind_Of_Customers.SUPPLIER,2,"hanqi",
        "10086","NJ","210046","hxh@foxmail.com",100,1000,100,"hemusheng");
   private static final    AccountVO accountVO1 = new AccountVO("HuaQi",111,new Time());
   private static final AccountVO accountVO2 = new AccountVO("zhaoshang",1111111,new Time());

    public static void main(String[] args) {
        ManagerBillBLService service = new ManagerBLServiceStub();
        System.out.println(new Time());
        ArrayList<StockBillVO> stockBillVOS = service.getWaitingStockBill();
        for(StockBillVO vo : stockBillVOS){
            System.out.println(vo.init_time.toString());
        }
    }
    public ManagerBLServiceStub() {


    }
    /**
     * 通过库存类单据 包括  库存赠送单 库存报损单 库存报溢单
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        stockBillVO.setStatus(BillStatus.approval);
        return ResultMessage.SUCCESS;
    }

    /**
     * 通过进货类单据  进货单 进货退货单
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        salesInBillVO.setStatus(BillStatus.approval);

        return ResultMessage.SUCCESS;
    }

    /**
     * 通过销售单 销售退货单
     *
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setStatus(BillStatus.approval);
        return ResultMessage.SUCCESS;

    }

    /**
     * 通过 应收单 应付单
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        financeBillVO.setStatus(BillStatus.approval);
        return ResultMessage.SUCCESS;
    }

    /**
     * 通过 现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage approveCashCostBill(CashCostBillVO cashCostBillVO) {
        cashCostBillVO.setStatus(BillStatus.approval);
        return ResultMessage.SUCCESS;
    }

    /**
     * 拒绝库存类单据 包括  库存赠送单 库存报损单 库存报溢单
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage rejectStockBill(StockBillVO stockBillVO) {
        stockBillVO.setStatus(BillStatus.rejected);
        return ResultMessage.SUCCESS;
    }

    /**
     * 拒绝 进货类单据  进货单 进货退货单
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        salesInBillVO.setStatus(BillStatus.rejected);
        return ResultMessage.SUCCESS;
    }

    /**
     * 拒绝 销售单 销售退货单
     *
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setStatus(BillStatus.rejected);
        return ResultMessage.SUCCESS;
    }

    /**
     * 拒绝 应收单 应付单
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        financeBillVO.setStatus(BillStatus.rejected);
        return ResultMessage.SUCCESS;
    }

    /**
     * 拒绝 现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage rejectCashCostBill(CashCostBillVO cashCostBillVO) {
        cashCostBillVO.setStatus(BillStatus.rejected);
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到所有等待审批的库存类单据
     *
     * @return
     */
    @Override
    public ArrayList<StockBillVO> getWaitingStockBill() {
        ArrayList<StockBillVO> stockBillVOS = new ArrayList<>();
        ArrayList<StockBillItemVO> stockBillItemVOS = new ArrayList<>();
        stockBillItemVOS.add(new StockBillItemVO(commodity1,1));
        stockBillItemVOS.add(new StockBillItemVO(commodity2,2));
        stockBillItemVOS.add(new StockBillItemVO(commodity3,3));
        stockBillItemVOS.add(new StockBillItemVO(commodity4,4));
        stockBillItemVOS.add(new StockBillItemVO(commodity5,5));

        StockBillVO stockBillVO1 = new StockBillVO("kczsd-20121212-00001",StockBillType.Less,BillStatus.commit,stockBillItemVOS,
                new Time(),new Time(),"no message",stockManager);
        StockBillVO stockBillVO2 = new StockBillVO("kczsd-20121212-00001",StockBillType.Less,BillStatus.commit,stockBillItemVOS,
                new Time(),new Time(),"no message",stockManager);
        StockBillVO stockBillVO3 = new StockBillVO("kczsd-20121212-00001",StockBillType.Less,BillStatus.commit,stockBillItemVOS,
                new Time(),new Time(),"no message",stockManager);
      stockBillVOS.add(  new StockBillVO("kczsd-20121212-00001",StockBillType.Less,BillStatus.commit,stockBillItemVOS,
                new Time(),new Time(),"no message",stockManager));

        stockBillVOS.add(stockBillVO1);
        stockBillVOS.add(stockBillVO2);
        stockBillVOS.add(stockBillVO3);
        return stockBillVOS;
    }

    /**
     * 得到所有等待审批的进货类单据
     *
     * @return
     */
    @Override
    public ArrayList<SalesInBillVO> getWaitingSalesInBill() {
        ArrayList<SalesInBillVO> salesInBillVOS = new ArrayList<>();
        ArrayList<SalesItemVO> salesItemVOS =new ArrayList<>();
        salesItemVOS.add(new SalesItemVO(commodity9,1,12));
        salesItemVOS.add(new SalesItemVO(commodity8,1,12));
        salesItemVOS.add(new SalesItemVO(commodity7,1,12));
        salesItemVOS.add(new SalesItemVO(commodity6,1,12));
        salesItemVOS.add(new SalesItemVO(commodity5,1,12));
        salesItemVOS.add(new SalesItemVO(commodity4,1,12));
        SalesInBillVO salesInBillVO1 =      new SalesInBillVO("jhd-20131212-00001","huawei","intel","第一仓库",SalesInBillType.OUT
                ,stockManager,"断货了很急",111111,salesItemVOS,BillStatus.commit,new Time(),new Time());


        SalesInBillVO salesInBillVO2 = new SalesInBillVO("jhd-20131212-00001","huawei","intel","第一仓库",SalesInBillType.OUT
                ,stockManager,"断货了很急",111111,salesItemVOS,BillStatus.commit,new Time(),new Time());
        salesInBillVOS.add(salesInBillVO1);
        salesInBillVOS.add(salesInBillVO2);
        salesInBillVOS.add(new SalesInBillVO("jhd-20131212-00001","huawei","intel","第一仓库",SalesInBillType.OUT
                ,stockManager,"断货了很急",111111,salesItemVOS,BillStatus.commit,new Time(),new Time()));
        return salesInBillVOS ;
    }

    /**
     * 得到所有等待审批的销售类单据
     *
     * @return
     */
    @Override
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        ArrayList<SalesOutBillVO> salesOutBillVOS = new ArrayList<>();
        ArrayList<SalesItemVO> salesItemVOS =new ArrayList<>();
        salesItemVOS.add(new SalesItemVO(commodity9,1,12));
        salesItemVOS.add(new SalesItemVO(commodity8,1,12));
        salesItemVOS.add(new SalesItemVO(commodity7,1,12));
        salesItemVOS.add(new SalesItemVO(commodity6,1,12));
        salesItemVOS.add(new SalesItemVO(commodity5,1,12));
        salesItemVOS.add(new SalesItemVO(commodity4,1,12));
        SalesOutBillVO salesOutBillVO1 = new SalesOutBillVO("xsd-20121212-00011","小黄","第一仓库",
                SalesOutBillType.OUT,11,11,customer,manager,null,salesItemVOS,new Time(),new Time(),
                null,BillStatus.commit,null);
        SalesOutBillVO salesOutBillVO2 = new SalesOutBillVO("xsthd-20121212-00011","小黄","第一仓库",
                SalesOutBillType.RETURN,11,11,customer,manager,null,salesItemVOS,new Time(),new Time(),
                null,BillStatus.commit,null);


        salesOutBillVOS.add(salesOutBillVO1);
        salesOutBillVOS.add(salesOutBillVO2);
        salesOutBillVOS.add(salesOutBillVO1);
        salesOutBillVOS.add(salesOutBillVO1);


        return salesOutBillVOS;
    }

    /**
     * 得到所有等待审批的财务类单据 应收和应付
     *
     * @return
     */
    @Override
    public ArrayList<FinanceBillVO> getWaitingFinanceBill() {
        ArrayList<FinanceBillVO> financeBillVOS = new ArrayList<>();
        ArrayList<FinanceItemVO> itemVOS = new ArrayList<>();
        itemVOS.add(new FinanceItemVO(accountVO1,"买灯泡",10000));
        itemVOS.add(new FinanceItemVO(accountVO1,"买很多灯泡",100000));
        itemVOS.add(new FinanceItemVO(accountVO2,"买很多很多灯泡",110000));
        FinanceBillVO financeBillVO1 = new FinanceBillVO("ysd-20121212-00001",stockManager,itemVOS,BillStatus.commit,10000
                ,stockManager, FinanceBillType.IN,new Time(),new Time(),null);
        FinanceBillVO financeBillVO2 = new FinanceBillVO("yfd-20121212-00001",stockManager,itemVOS,BillStatus.commit,10000
                ,stockManager, FinanceBillType.OUT,new Time(),new Time(),null);
        financeBillVOS.add(financeBillVO1);
        financeBillVOS.add(financeBillVO2);
        return financeBillVOS;
    }

    /**
     * 得到所有等待审批的现金费用单据
     *
     * @return
     */
    @Override
    public ArrayList<CashCostBillVO> getWaitingCashCostBillVO() {
        ArrayList<CashCostBillVO> cashCostBillVOS = new ArrayList<>();
        ArrayList<CashCostItemVO> cashCostItemVOS = new ArrayList<>();
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        cashCostItemVOS.add(new CashCostItemVO("maidengpao",111,"ps"));
        CashCostBillVO cashCostBillVO1 = new CashCostBillVO("xjfyd-00000000-00001"
        ,stockManager,null,BillStatus.commit,cashCostItemVOS,10000,new Time(),new Time(),null);
        CashCostBillVO cashCostBillVO2 = new CashCostBillVO("xjfyd-00000000-00001"
                ,stockManager,null,BillStatus.commit,cashCostItemVOS,10000,new Time(),new Time(),null);
        cashCostBillVOS.add(cashCostBillVO1);
        cashCostBillVOS.add(cashCostBillVO2);
        return cashCostBillVOS;
    }
}
