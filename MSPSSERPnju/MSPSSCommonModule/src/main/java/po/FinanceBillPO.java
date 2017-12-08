package po;

import util.BillStatus;
import util.FinanceBillType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 15:35 2017/11/28/028
 */
public class FinanceBillPO implements Serializable {
    /**
     * 单据编号 收款单（SKD-yyyyMMdd-xxxxx）
     * 付款单 （FKD-yyyyMMdd-xxxxx）
     */
   private String ID;
   /**
    * 操作员的ID
    */
   private String operatorID;
   /**
    * 客户的ID
    */
   private String customerID;
   /**
    * 审批的经理的ID
    */
   private String managerID;
   /**
    * 创建财务单时间
    */
   private String init_time;
   /**
    * 提交财务单时间
    */
   private String commit_time;
   /**
    * 审批财务单时间
    */
   private String approval_time;
   /**
    * 财务单类型 为收款单 付款单
    */
   private FinanceBillType type;
   /**
    * 总额
    */
   private double sum;

   /**
    * 单据的状态
    */
   private int status;
   /**
    * 条目清单 条目包括 条目名 金额 备注
    */
   private ArrayList<FinanceItemPO> list;

   public FinanceBillPO(String ID,String operatorID,String managerID,String init_time,String commit_time,String approval_time
      ,String customerID,int status,ArrayList<FinanceItemPO> list,double sum ){
      this.operatorID = operatorID;
      this.ID = ID;
      this.managerID = managerID;
      this.init_time = init_time;
      this.commit_time = commit_time;
      this.approval_time = approval_time;
      this.status =status;
      this.customerID = customerID;
      this.list = list;
      this.sum = sum;
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

   public String getCustomerID() {
      return customerID;
   }

   public void setCustomerID(String customerID) {
      this.customerID = customerID;
   }

   public String getManagerID() {
      return managerID;
   }

   public void setManagerID(String managerID) {
      this.managerID = managerID;
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

   public FinanceBillType getType() {
      return type;
   }

   public void setType(FinanceBillType type) {
      this.type = type;
   }

   public double getSum() {
      return sum;
   }

   public void setSum(double sum) {
      this.sum = sum;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   public ArrayList<FinanceItemPO> getList() {
      return list;
   }

   public void setList(ArrayList<FinanceItemPO> list) {
      this.list = list;
   }
}
