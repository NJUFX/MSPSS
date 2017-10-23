package vo;

public class BillVO {
	String billId;
	boolean isExamined;
	boolean state;

	public BillVO(String s, boolean flag,boolean p) {
		billId = s;
		isExamined = flag;
		state = p;
	}

	public String getBillId() {
		return billId;
	}

	public boolean getIsExamined() {
		return isExamined;
	}
	public boolean getState(){
		return state;
	}
	public void setState(boolean s){
		state = s;
	}
	public void setIsExamined(boolean flag){
		isExamined = flag;
	}
}
