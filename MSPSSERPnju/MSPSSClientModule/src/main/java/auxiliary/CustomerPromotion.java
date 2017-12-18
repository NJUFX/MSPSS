package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import vo.CustomerPromotionVO;

public class CustomerPromotion {
	private SimpleStringProperty startTime = new SimpleStringProperty("");
	private SimpleStringProperty endTime = new SimpleStringProperty("");
	private SimpleStringProperty customerLevel = new SimpleStringProperty("");
	private SimpleStringProperty discount = new SimpleStringProperty();
	private SimpleStringProperty voucher = new SimpleStringProperty("");
	private SimpleStringProperty giftItems = new SimpleStringProperty("");
	private SimpleStringProperty giftNum = new SimpleStringProperty("");
	public CustomerPromotionVO vo ;
	
	public CustomerPromotion() {
		this("","","","","","","",null);
	}
	
	public CustomerPromotion(String startTime,String endTime,String customerLevel,String discount,String voucher,String giftItems,String giftNum,CustomerPromotionVO cpVO) {
		setStartTime(startTime);
		setEndTime(endTime);
		setCustomerLevel(customerLevel);
		setDiscount(discount);
		setVoucher(voucher);
		setGiftItems(giftItems);
		setGiftNum(giftNum);
		vo = cpVO;
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
	
	public void setCustomerLevel(String level) {
		customerLevel.set(level);
	}
	
	public String getCustomerLevel() {
		return customerLevel.get();
	}
	
	public void setDiscount(String dis) {
		discount.set(dis);
	}
	
	public String getDiscount() {
		return discount.get();
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
	
	public CustomerPromotionVO getCustomerPromotionVO() {
		return vo;
	}
}
