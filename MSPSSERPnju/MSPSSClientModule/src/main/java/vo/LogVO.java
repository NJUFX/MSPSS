package vo;

public class LogVO {
	String id;
	String operator;
	String time;
	int kind;
	


	public LogVO(String i, String o, String t, int k) {
		id = i;
		operator = o;
		time = t;
		kind = k;
	
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
