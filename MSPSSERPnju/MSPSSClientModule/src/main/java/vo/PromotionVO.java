package vo;

import util.Time;

//促销策略VO的子类
public class PromotionVO {
	String id;
	String type;
	String[] infoList;
	Time time;

	public PromotionVO(String i, String t,String[] info,Time ti) {
		id = i;
		type = t;
		infoList = info;
		time = ti;
	}

	public String getId(){
		return id;
	}

	public String getType() {
		return type;
	}

	public Time getTime() {
		return time;
	}

	public String[] getInfoList(){
		return infoList;
	}
}
