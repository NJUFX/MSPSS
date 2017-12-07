package vo;

public class LogVO {
	String id;
	String operator;
	String time;
	int kind;
	

<<<<<<< HEAD
	public LogVO(String id, String operator, String time, String kind, String commodity, int money, Long stock) {
		this.id = id;
		this.operator = operator;
		this.time = time;
		this.kind = kind;
		this.commodity = commodity;
		this.money = money;
		this.stock = stock;
=======

	public LogVO(String i, String o, String t, int k) {
		id = i;
		operator = o;
		time = t;
		kind = k;
	
>>>>>>> 52215b8994f21d122f1b54eacc239124ed9f9a53
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
	public int getKind() {
		return kind;
	}
}
