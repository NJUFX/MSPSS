package po;

import util.BillStatus;
import util.SalesOutBillType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:41 2017/11/28/028
 */
public class SalesOutBillPO implements Serializable {
    /**
     *销售单单据编号（XSD-yyyyMMdd-xxxxx）
     * 销售退货单 XSTHD-yyyyMMdd-xxxxx
     */
    private String ID;
    /**
     * 销售单的类型SalesOutBillType
     */
    private int type;
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
     * 订单的状态BillStatus
     */
    private int status;
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
    private double sumBeforeDiscount;

    /**
     * 折让后总额
     */
    private double sumAfterDiscount;
    /**
     * 出库商品列表
     */
    ArrayList<SalesItemPO> salesItemPOS;

    public SalesOutBillPO(String ID, int type, String customerID, String DAE, String operatorID, String managerID, int status, String storage, String promotionID, String init_time, String commit_time, String approval_time, String ps, int allowance, int voucher, double sumBeforeDiscount, double sumAfterDiscount, ArrayList<SalesItemPO> salesItemPOS) {
        this.ID = ID;
        this.type = type;
        this.customerID = customerID;
        this.DAE = DAE;
        this.operatorID = operatorID;
        this.managerID = managerID;
        this.status = status;
        this.storage = storage;
        this.promotionID = promotionID;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.ps = ps;
        this.allowance = allowance;
        this.voucher = voucher;
        this.sumBeforeDiscount = sumBeforeDiscount;
        this.sumAfterDiscount = sumAfterDiscount;
        this.salesItemPOS = salesItemPOS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDAE() {
        return DAE;
    }

    public void setDAE(String DAE) {
        this.DAE = DAE;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getInit_time() {
        return init_time;
    }

    public void setInit_time(String init_time) {
        this.init_time = init_time;
    }

    public String getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(String commit_time) {
        this.commit_time = commit_time;
    }

    public String getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public double getSumBeforeDiscount() {
        return sumBeforeDiscount;
    }

    public void setSumBeforeDiscount(double sumBeforeDiscount) {
        this.sumBeforeDiscount = sumBeforeDiscount;
    }

    public double getSumAfterDiscount() {
        return sumAfterDiscount;
    }

    public void setSumAfterDiscount(double sumAfterDiscount) {
        this.sumAfterDiscount = sumAfterDiscount;
    }

    public ArrayList<SalesItemPO> getSalesItemPOS() {
        return salesItemPOS;
    }

    public void setSalesItemPOS(ArrayList<SalesItemPO> salesItemPOS) {
        this.salesItemPOS = salesItemPOS;
    }
}
