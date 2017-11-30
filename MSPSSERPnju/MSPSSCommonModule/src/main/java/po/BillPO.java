package po;

//所有单据的PO，只是一个测试类，无实际用途，但是有usages，所以尽量不要删除
public class BillPO {
	String billId;

	public BillPO(String t) {
		billId = t;
	}

	public String getBillId() {
		return billId;
	}
}
