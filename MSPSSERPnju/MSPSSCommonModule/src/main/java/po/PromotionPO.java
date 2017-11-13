package po;

import util.Time;

public class PromotionPO {
	String id;
	String type;
	String[] infoList;
	Time time;

	public PromotionPO(String i, String t,String[] info,Time ti) {
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
