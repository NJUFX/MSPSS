package po;

import util.BillStatus;


import java.util.ArrayList;
import java.util.List;

/**
 * Description: 现金费用单 管理报销等现金操作
 * Created by Hanxinhu at 19:31 2017/11/28/028
 */
public class CashCostBillPO {
    /**
     * 单据编号（XJFYD-yyyyMMdd-xxxxx）
     */
    private String ID;
    /**
     * 操作员ID
     */
    private String operatorID;
    /**
     * 审批经理的ID
     */
    private String managerID;
    /**
     * 单据状态
     */
    private int status;
    /**
     * 条目清单
     */
    List<CashCostItemPO> list;
    /**
     * 总金额
     */
    private double sum;
    /**
     * 创建时间
     */
    private String init_time;
    /**
     * 提交时间
     */
    private String commit_time;
    /**
     * 审批时间
     */
    private String approval_time;

    public CashCostBillPO() {
    }

    public CashCostBillPO(String ID, String operatorID, String managerID, int status, List<CashCostItemPO> list, double sum, String init_time, String commit_time, String approval_time) {
        this.ID = ID;
        this.operatorID = operatorID;
        this.managerID = managerID;
        this.status = status;
        this.list = list;
        this.sum = sum;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public List<CashCostItemPO> getList() {
        return list;
    }

    public void setList(List<CashCostItemPO> list) {
        this.list = list;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
}
