package auxiliary;


import javafx.beans.property.SimpleStringProperty;
import vo.StockBillVO;

/**
 * 审批单据时的库存单据数据类
 * 
 * @author Harper
 *
 */

public class StockBill extends Bill{

	private final SimpleStringProperty billId = new SimpleStringProperty("");
	private final SimpleStringProperty createTime = new SimpleStringProperty("");
	private final SimpleStringProperty commitTime = new SimpleStringProperty("");
	private final SimpleStringProperty operator = new SimpleStringProperty("");
	private final SimpleStringProperty billType = new SimpleStringProperty("");
	public StockBillVO myself;

	public StockBill() {
		this("", "", "", "", "", null);
	}

	public StockBill(String billId, String createTime, String commitTime, String operator, String billType,
			StockBillVO stockBillVO) {
		setBillId(billId);
		setCreateTime(createTime);
		setCommitTime(commitTime);
		setOperator(operator);
		setBillType(billType);
		myself = stockBillVO;

	}

	public String getBillId() {
		return billId.get();
	}

	public void setBillId(String bid) {
		billId.set(bid);
	}

	public String getCreateTime() {
		return createTime.get();
	}

	public void setCreateTime(String CreateTime) {
		createTime.set(CreateTime);
	}

	public String getCommitTime() {
		return commitTime.get();
	}

	public void setCommitTime(String CommitTime) {
		commitTime.set(CommitTime);
	}

	public String getOperator() {
		return operator.get();
	}

	public void setOperator(String Operator) {
		operator.set(Operator);
	}

	public String getBillType() {
		return billType.get();
	}

	public void setBillType(String BillType) {
		billType.set(BillType);
	}

	
}
