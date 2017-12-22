package vo;

import util.BillStatus;
import util.Time;

import java.util.ArrayList;

/**
 * Description: 现金费用单
 * Created by Hanxinhu at 19:16 2017/11/28/028
 */
public class CashCostBillVO {
    /**
     * 单据编号（XJFYD-yyyyMMdd-xxxxx）
     */
    public String ID;
    /**
     * 操作者
     */
    public UserVO operator;
    /**
     * 审批的经理
     */
    public UserVO manager;
    /**
     * 单据的状态
     */
    public BillStatus status;
    /**
     * 银行账户
     */
    public AccountVO accountVO;
    /**
     * 条目清单
     */
    ArrayList<CashCostItemVO> list;
    /**
     * 总额
     */
    public double sum;
    /**
     *  创建时间
     */
    public Time init_time;
    /**
     * 提交时间
     */
    public Time commit_time;
    /**
     * 审批时间
     */
    public Time approval_time;
    public CashCostBillVO(UserVO operator,AccountVO account,ArrayList<CashCostItemVO> list,double sum){
        
        this.operator = operator;
        this.accountVO = account;
        this.list = list;
        this.sum = sum;
       
    }
    
    public CashCostBillVO(String ID,UserVO operator,UserVO manager,BillStatus status,AccountVO account,ArrayList<CashCostItemVO> list,double sum,
            Time init_time,Time commit_time,Time approval_time){
this.ID = ID;
this.operator = operator;
this.manager = manager;
this.status = status;
this.accountVO = account;
this.list = list;
this.sum = sum;
this.init_time = init_time;
this.commit_time = commit_time;
this.approval_time = approval_time;
}

    public void setOperator(UserVO operator) {
        this.operator = operator;
    }

    public Time getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(Time approval_time) {
        this.approval_time = approval_time;
    }

    public Time getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(Time commit_time) {
        this.commit_time = commit_time;
    }

    public Time getInit_time() {
        return init_time;
    }

    public void setInit_time(Time init_time) {
        this.init_time = init_time;
    }

    public UserVO getOperator() {
        return operator;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public UserVO getManager() {
        return manager;
    }

    public void setManager(UserVO manager) {
        this.manager = manager;
    }

    public ArrayList<CashCostItemVO> getList() {
        return list;
    }

    public void setList(ArrayList<CashCostItemVO> list) {
        this.list = list;
    }

}
