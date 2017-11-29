package po;

import util.BillStatus;
import util.SalesOutBillType;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:41 2017/11/28/028
 */
public class SalesOutBillPO {
    /**
     *销售单单据编号（XSD-yyyyMMdd-xxxxx）
     * 销售退货单 XSTHD-yyyyMMdd-xxxxx
     */
    private String ID;
    /**
     * 销售单的类型
     */
    private SalesOutBillType type;
    /**
     * 经销商
     */
    private String customerID;
    /**
     * 默认业务员
     */
    private String DAE;

    /**
     * 产生该单据的用户
     */
    private String operatorID;
    /**
     * 审批该单据的经理
     */
    private String managerID;
    /**
     * 订单的状态
     */
    private BillStatus status;
    /**
     * 仓库
     */
    private String storage;

    /**
     *促销策略的编号
     */
    private String promotionID;
    /**
     * 创建销售单的时间
     */
    private String init_time;
    /**
     * 销售单的提交时间
     */
    private String commit_time;
    /**
     * 销售单的审批时间
     */
    private String approval_time;
    /**
     * 备注
     */
    private String ps;

    /**
     * 折让
     */
    private int allowance;
    /**
     * 使用的代金券金额
     */
    private int voucher;

    /**
     *折让前总额
     */
    private double sumBeforeDiscout;

    /**
     * 折让后总额
     */
    private double sumAfterDiscount;
    /**
     * 出库商品列表
     */
    ArrayList<SalesItemPO> salesItemPOS;

    public SalesOutBillPO(String ID, String DAE, String storage, SalesOutBillType type, int allowance, int voucher, String customerID, String operatorID, String  managerID
            , ArrayList<SalesItemPO> salesItemPOS,String  init_time, String commit_time, String approval_time, BillStatus status, String promotionID,double sumAfterDiscount,double sumBeforeDiscount,String ps){
        this.ID = ID;
        this.DAE = DAE;
        this.status = status;
        this.storage = storage;
        this.type = type;
        this.allowance = allowance;
        this.voucher =voucher;
        this.sumAfterDiscount = sumAfterDiscount;
        this.sumBeforeDiscout = sumBeforeDiscount;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.ps = ps;
        this.customerID = customerID;
        this.managerID = managerID;
        this.operatorID = operatorID;
        this.salesItemPOS = salesItemPOS;
        this.promotionID = promotionID;
    }

    public void setDAE(String DAE) {
        this.DAE = DAE;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public SalesOutBillType getType() {
        return type;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public String getStorage() {
        return storage;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setSumAfterDiscount(double sumAfterDiscount) {
        this.sumAfterDiscount = sumAfterDiscount;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public String getDAE() {
        return DAE;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getID() {
        return ID;
    }

    public void setInit_time(String init_time) {
        this.init_time = init_time;
    }

    public double getSumAfterDiscount() {
        return sumAfterDiscount;
    }

    public void setType(SalesOutBillType type) {
        this.type = type;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setCommit_time(String commit_time) {
        this.commit_time = commit_time;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPs() {
        return ps;
    }

    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }

    public double getSumBeforeDiscout() {
        return sumBeforeDiscout;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public ArrayList<SalesItemPO> getSalesItemPOS() {
        return salesItemPOS;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getApproval_time() {
        return approval_time;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getCommit_time() {
        return commit_time;
    }

    public void setSalesItemPOS(ArrayList<SalesItemPO> salesItemPOS) {
        this.salesItemPOS = salesItemPOS;
    }

    public String getInit_time() {
        return init_time;
    }

    public void setSumBeforeDiscout(double sumBeforeDiscout) {
        this.sumBeforeDiscout = sumBeforeDiscout;
    }

    public String getPromotionID() {
        return promotionID;
    }

}
