package po;

import java.util.ArrayList;

public class PurchaseBillPO {
    /**
     * 进货单编号
     */
    private String ID;
    /**
     * 供应商
     */
    private CustomerPO supplier;
    /**
     * 仓库
     */
    private String store;
    /**
     * 操作员
     */
    private String worker;
    /**
     * 入库商品列表
     */
    private ArrayList<CommodityPO> prolist;
    /**
     * 总额
     */
    double sum;
    /**
     * 备注
     */
    String remark;

    public ArrayList<CommodityPO> getProlist() {
        return prolist;
    }

    public PurchaseBillPO(String ID, CustomerPO supplier, String store, String worker, ArrayList<CommodityPO> prolist, double sum, String remark) {
        this.ID = ID;
        this.supplier = supplier;
        this.store = store;
        this.worker = worker;
        this.prolist = prolist;
        this.sum = sum;
        this.remark = remark;
    }

}