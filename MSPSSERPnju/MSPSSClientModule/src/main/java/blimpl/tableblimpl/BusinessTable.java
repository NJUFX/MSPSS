package blimpl.tableblimpl;

import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import po.SalesInBillPO;
import po.SalesOutBillPO;
import util.Time;
import vo.BusinessTableVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class BusinessTable {
    BillClientNetworkService billClientNetworkService;

    protected BusinessTable(){
        billClientNetworkService = new BillClientNetworkImpl();
    }

    /**
     * 搜索一段时间内的经营情况表
     * @param begin
     * @param end
     * @return
     */
    public BusinessTableVO search(Time begin,Time end){
        ArrayList<SalesInBillPO> salesInBillPOS = billClientNetworkService.rangeSearchSalesInBill("init_time",begin.toString(),end.toString());
        ArrayList<SalesOutBillPO> salesOutBillPOS = billClientNetworkService.rangeSearchSalesOutBill("init_time",begin.toString(),end.toString());

        //销售类收入
        double salesIncome=0;
        //商品类收入
        double commodityIncome = 0;
        //销售成本
        double salesCost=0;
        //商品类成本
        double commodityCost=0;


        for(int i=0;i<=salesInBillPOS.size()-1;i++){
            //如果是进货单
            if(salesInBillPOS.get(i).getType()==0){
              commodityCost +=salesInBillPOS.get(i).getSumMoney();
            }
            //如果是进货退货单
            if(salesInBillPOS.get(i).getType()==1){
                commodityIncome +=salesInBillPOS.get(i).getSumMoney();
            }
        }

        for(int i=0;i<=salesOutBillPOS.size()-1;i++){
            //如果是销售退货单
            if(salesOutBillPOS.get(i).getType()==0){
               salesCost +=salesOutBillPOS.get(i).getSumAfterDiscount();
            }
            //如果是销售单
            if(salesOutBillPOS.get(i).getType()==1){

                salesCost +=salesOutBillPOS.get(i).getSumBeforeDiscount()-salesOutBillPOS.get(i).getSumAfterDiscount();

            }
        }

        BusinessTableVO businessTableVO = new BusinessTableVO();
        businessTableVO.setCommodityCost(commodityCost);
        businessTableVO.setCommodityIncome(commodityIncome);
        businessTableVO.setSalesCost(salesCost);
        businessTableVO.setSalesIncome(salesIncome);
        return businessTableVO;


    }



}
