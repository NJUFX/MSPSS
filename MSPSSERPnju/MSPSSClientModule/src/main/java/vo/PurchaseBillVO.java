package vo;

import java.util.ArrayList;

public class PurchaseBillVO {
    /**
     * 进货单编号
     */
    public String ID;
    /**
     * 供应商
     */
    public CustomerVO supplier;
    /**
     * 仓库
     */
    public String store;
    /**
     * 操作员
     */
    public String worker;
    /**
     * 入库商品列表
     */
    public ArrayList<CommodityVO> prolist;
    /**
     * 总额
     */
    double sum;
    /**
     * 备注
     */
    String remark;



    public PurchaseBillVO(String ID, CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark) {
        this.ID = ID;
        this.supplier = supplier;
        this.store = store;
        this.worker = worker;
        this.prolist = prolist;
        this.sum = sum;
        this.remark = remark;
    }

}
