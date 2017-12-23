package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import vo.GrossPromotionVO;

public class GrossPromotion {
	private SimpleStringProperty startTime = new SimpleStringProperty("");
	private SimpleStringProperty endTime = new SimpleStringProperty("");
	private SimpleStringProperty total = new SimpleStringProperty("");
	private SimpleStringProperty voucher = new SimpleStringProperty("");
	private SimpleStringProperty giftItems = new SimpleStringProperty("");
	private SimpleStringProperty giftNum = new SimpleStringProperty("");
	public GrossPromotionVO vo;
	
	public GrossPromotion() {
		this("","","","","","",null);
	}
	
	public GrossPromotion(String startTime,String endTime,String total,String voucher,String giftItems,String giftNum,GrossPromotionVO gpVO) {
		setStartTime(startTime);
		setEndTime(endTime);
		setTotal(total);
		setVoucher(voucher);
		setGiftItems(giftItems);
		setGiftNum(giftNum);
		vo = gpVO;
	}
	
	public void setStartTime(String stime) {
		startTime.set(stime);
	}
	
	public String getStartTime() {
		return startTime.get();
	}
	
	public void setEndTime(String etime) {
		endTime.set(etime);
	}
	
	public String getEndTime() {
		return endTime.get();
	}
	
	public void setTotal(String t) {
		total.set(t);
	}
	
	public String getTotal() {
		return total.get();
	}
	
	
	public void setVoucher(String vou) {
		voucher.set(vou);
	}
	
	public String getVoucher() {
		return voucher.get();
	}
	
	public void setGiftItems(String gItems) {
		giftItems.set(gItems);
	}
	
	public String getGiftItems() {
		return giftItems.get();
	}
	
	public void setGiftNum(String gNum) {
		giftNum.set(gNum);
	}
	
	public String getGiftNum() {
		return giftNum.get();
	}
	
	public GrossPromotionVO getGrossPromotionVO() {
		return vo;
	}
	
}
