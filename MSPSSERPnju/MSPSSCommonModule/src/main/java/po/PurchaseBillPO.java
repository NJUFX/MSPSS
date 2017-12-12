package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PurchaseBillPO implements Serializable {
    /**
     * 主键，切勿自己赋值！！！
     */
    private String keycolumn;
    /**
     * 进货单编号
     */
    private String ID;
    /**
     * 供应商
     */
    private String supplier;
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
    private List<CommodityPO> prolist;
    /**
     * 总额
     */
    double sum;
    /**
     * 备注
     */
    String remark;

    public PurchaseBillPO() {
    }

    public PurchaseBillPO(String keycolumn, String ID, String supplier, String store, String worker, List<CommodityPO> prolist, double sum, String remark) {
        this.keycolumn = keycolumn;
        this.ID = ID;
        this.supplier = supplier;
        this.store = store;
        this.worker = worker;
        this.prolist = prolist;
        this.sum = sum;
        this.remark = remark;
    }

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public List<CommodityPO> getProlist() {
        return prolist;
    }

    public void setProlist(List<CommodityPO> prolist) {
        this.prolist = prolist;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}