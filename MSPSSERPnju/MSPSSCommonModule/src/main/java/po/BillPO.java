package po;

//所有单据的PO
public class BillPO {
	String billId;

	public BillPO(String t) {
		billId = t;
	}

	public String getBillId() {
		return billId;
	}
}
