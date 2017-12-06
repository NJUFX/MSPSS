package vo;

public class LogVO {
	String id;
	String operator;
	String time;
	String kind;
	String commodity;
	int money;
	Long stock;

	public LogVO(String id, String operator, String time, String kind, String commodity, int money, Long stock) {
		this.id = id;
		this.operator = operator;
		this.time = time;
		this.kind = kind;
		this.commodity = commodity;
		this.money = money;
		this.stock = stock;
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
