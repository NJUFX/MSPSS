package vo;

public class LogVO {
	String id;
	String operator;
	String time;
	String kind;
	String commodity;
	int money;
	Long stock;


	public LogVO(String i, String o, String t, String k, String c, int m, long s) {
		id = i;
		operator = o;
		time = t;
		kind = k;
		commodity = c;
		money = m;
		stock = s;
	}

	//get方法可以根据需要补充
	public String getId() {
		return id;
	}

	public String getOperator() {
		return operator;
	}

	public String getTime() {
		return time;
	}
}
