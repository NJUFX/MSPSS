package po;

import util.BillStatus;


import java.util.ArrayList;

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
    private BillStatus status;
    /**
     * 条目清单
     */
    ArrayList<CashCostItemPO> list;
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

    public CashCostBillPO (String ID,String operatorID,String managerID,BillStatus status,double sum,ArrayList<CashCostItemPO> list,String init_time,String commit_time,String approval_time){
      this .ID  =ID;
      this.operatorID =operatorID;
      this.managerID = managerID;
      this.status =status;
      this.sum = sum;
      this.init_time = init_time;
      this.commit_time = commit_time;
      this.approval_time = approval_time;
      this.list = list;
    }

}
