package vo;

import java.util.*;

public class SalesVO {
    /**
     * ID
     */
    private String ID;
    /**
     * 销售商
     */
    private CustomerVO saler;
    /**
     * 默认业务员
     */
    private String DAE;
    /**
     * 操作员
     */
    private String worker;
    /**
     * 仓库
     */
    public String store;
    /**
     * 出货商品清单
     */
    private ArrayList<CommodityVO> prolist;
    /**
     * 折让前总额
     */
    private double befSum;
    /**
     * 折让
     */
    public double discount;
    /**
     * 代金券
     */
    private double vocher;
    /**
     * 折让后总额
     */
    private double aftSum;
    /**
     * 备注
     */
    private String remark;

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
    public SalesVO(String ID, CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark) {
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
