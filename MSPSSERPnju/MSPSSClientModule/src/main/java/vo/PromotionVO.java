package vo;

//促销策略VO的子类
public class PromotionVO {
	String type;
	String time;

	public PromotionVO(String s, String t) {
		type = s;
		time = t;
	}

	public String getType() {
		return type;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String s){
		time = s;
	}
}
