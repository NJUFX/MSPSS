package po;

public class PromotionPO {
	String type;
	String time;// 有效时间区间

	public PromotionPO(String t, String s) {
		type = t;
		time = s;
	}

	public String getType() {
		return type;
	}

	public String getTime() {
		return time;
	}
}
