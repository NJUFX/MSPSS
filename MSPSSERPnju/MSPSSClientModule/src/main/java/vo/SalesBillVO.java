package vo;

import java.util.*;

public class SalesBillVO {
    /**
     * ID
     */
    public String ID;
    /**
     * 销售商
     */
    public CustomerVO saler;
    /**
     * 默认业务员
     */
    public String DAE;
    /**
     * 操作员
     */
    public String worker;
    /**
     * 仓库
     */
    public String store;
    /**
     * 出货商品清单
     */
    public ArrayList<CommodityVO> prolist;
    /**
     * 折让前总额
     */
    public double befSum;
    /**
     * 折让
     */
    public double discount;
    /**
     * 代金券
     */
    public double vocher;
    /**
     * 折让后总额
     */
    public double aftSum;
    /**
     * 备注
     */
    public String remark;

    /**
     * @param saler
     * @param DAE
     * @param worker
     * @param store
     * @param prolist
     * @param befSum
     * @param discount
     * @param vocher
     * @param aftSum
     * @param remark
     */
    public SalesBillVO(String ID, CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark) {
        this.ID = ID;
        this.saler = saler;
        this.DAE = DAE;
        this.worker = worker;
        this.store = store;
        this.prolist = prolist;
        this.befSum = befSum;
        this.discount = discount;
        this.vocher = vocher;
        this.aftSum = aftSum;
        this.remark = remark;
    }
}
