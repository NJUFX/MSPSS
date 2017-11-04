package vo;

import java.util.ArrayList;

public class PurchaseVO {
    /**
     * 进货单编号
     */
    private String ID;
    /**
     * 供应商
     */
    private CustomerVO supplier;
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
    private ArrayList<CommodityVO> prolist;
    /**
     * 总额
     */
    private double sum;
    /**
     * 备注
     */
    private String remark;


    public PurchaseVO(String ID, CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark) {
        this.ID = ID;
        this.supplier = supplier;
        this.store = store;
        this.worker = worker;
        this.prolist = prolist;
        this.sum = sum;
        this.remark = remark;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getStore(){
        return store;
    }
    public void setStore(String store) {
        this.store = store;
    }

}
