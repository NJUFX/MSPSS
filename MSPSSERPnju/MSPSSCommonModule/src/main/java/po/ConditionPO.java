package po;

public class ConditionPO {
	String type;
	String time;
	String billId;
	String[] detail;

	public ConditionPO(String ty, String ti, String id, String[] codi) {
		type = ty;
		time = ti;
		billId = id;
		detail = codi;
	}

	public String getType() {
		return type;
	}

	public String getTime() {
		return time;
	}

	public String getBillId() {
		return billId;
	}

	public String[] getDetail() {
		return detail;
	}
}
