package vo;

import util.BillStatus;
import util.FinanceBillType;
import util.Time;

import java.util.ArrayList;

/**
 * Description: 收款单 付款单 Created by Hanxinhu at 20:01 2017/11/21/021
 */
public class FinanceBillVO {
	/**
	 * 单据编号 收款单（SKD-yyyyMMdd-xxxxx） 付款单 （FKD-yyyyMMdd-xxxxx）
	 */
	public String ID;
	/**
	 * 操作员的ID
	 */
	public UserVO operator;
	/**
	 * 客户的ID
	 */
	public CustomerVO customerVO;
	/**
	 * 审批的经理的ID
	 */
	public UserVO managerVO;
	/**
	 * 创建财务单时间
	 */
	public Time init_time;
	/**
	 * 提交财务单时间
	 */
	public Time commit_time;
	/**
	 * 审批财务单时间
	 */
	public Time approval_time;
	/**
	 * 财务单类型 为收款单 付款单
	 */
	private FinanceBillType type;
	/**
	 * 总额汇总
	 */
	public double sum;

	/**
	 * 单据的状态
	 */
	public BillStatus status;
	/**
	 * 条目清单 条目包括 条目名 金额 备注
	 */
	public ArrayList<FinanceItemVO> list;

    public FinanceBillVO() {
    }

	public FinanceBillVO(String ID, UserVO operator, ArrayList<FinanceItemVO> list, BillStatus status, double sum,
                         UserVO managerVO, FinanceBillType type, Time init_time, Time commit_time, Time approval_time) {
		this.ID = ID;
		this.status = status;
		this.operator = operator;
		this.approval_time = approval_time;

		this.sum = sum;
		this.managerVO = managerVO;
		this.init_time = init_time;
		this.commit_time = commit_time;
		this.list = list;
		this.type = type;
	}

	public FinanceBillVO( UserVO operator, CustomerVO customer, FinanceBillType type,
			ArrayList<FinanceItemVO> list,double sum) {
		this.operator = operator;
		this.customerVO = customer;
		this.type = type;
		this.list = list;
		this.sum = sum;

	}

    public FinanceBillVO(String ID, UserVO operator, CustomerVO customerVO, UserVO managerVO, Time init_time, Time commit_time, Time approval_time, FinanceBillType type, double sum, BillStatus status, ArrayList<FinanceItemVO> list) {
        this.ID = ID;
        this.operator = operator;
        this.customerVO = customerVO;
        this.managerVO = managerVO;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.type = type;
        this.sum = sum;
        this.status = status;
        this.list = list;
    }

	public void setList(ArrayList<FinanceItemVO> list) {
		this.list = list;
	}

	public FinanceBillType getType() {
		return type;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}

	public BillStatus getStatus() {
		return status;
	}

	public void setStatus(BillStatus status) {
		this.status = status;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setInit_time(Time init_time) {
		this.init_time = init_time;
	}

	public void setType(FinanceBillType type) {
		this.type = type;
	}

	public UserVO getOperator() {
		return operator;
	}

	public Time getInit_time() {
		return init_time;
	}

	public void setCommit_time(Time commit_time) {
		this.commit_time = commit_time;
	}

	public Time getCommit_time() {
		return commit_time;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public Time getApproval_time() {
		return approval_time;
	}

	public void setApproval_time(Time approval_time) {
		this.approval_time = approval_time;
	}

	public void setOperator(UserVO operator) {
		this.operator = operator;
	}

	public ArrayList<FinanceItemVO> getList() {
		return list;
	}

	public UserVO getManagerVO() {
		return managerVO;
	}

	public void setManagerVO(UserVO managerVO) {
		this.managerVO = managerVO;
	}

}
