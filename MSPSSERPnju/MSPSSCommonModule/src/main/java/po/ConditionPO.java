package po;

public class ConditionPO {

	/**
	 * 暂时没发现这个po的具体用处，所以暂时不为它创建数据库
	 */
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
