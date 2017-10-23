package vo;
//单据列表VO
public class BillListVO {
	int amount;
	BillVO[] billList;

	public BillListVO(int a, BillVO[] b) {
		amount = a;
		billList = b;
	}

	public int getAmount() {
		return amount;
	}

	public BillVO[] getBillVO() {
		return billList;
	}
	
}
