package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import vo.GroupPromotionVO;

public class GroupPromotion {
	private SimpleStringProperty startTime = new SimpleStringProperty("");
	private SimpleStringProperty endTime = new SimpleStringProperty("");
	private SimpleStringProperty discountRate = new SimpleStringProperty();
	private SimpleStringProperty productItems = new SimpleStringProperty("");
	private SimpleStringProperty productNum = new SimpleStringProperty("");
	public GroupPromotionVO vo;
	
	public GroupPromotion() {
		this("","","","","",null);
	}
	
	public GroupPromotion(String startTime,String endTime,String discountRate,String productItems,String productNum,GroupPromotionVO gpVO) {
		setStartTime(startTime);
		setEndTime(endTime);
		setDiscountRate(discountRate);
		setProductItems(productItems);
		setProductNum(productNum);
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
	
	
	public void setDiscountRate(String dis) {
		discountRate.set(dis);
	}
	
	public String getDiscountRate() {
		return discountRate.get();
	}
	
	
	public void setProductItems(String pItems) {
		productItems.set(pItems);
	}
	
	public String getGiftItems() {
		return productItems.get();
	}
	
	public void setProductNum(String pNum) {
		productNum.set(pNum);
	}
	
	public String getGiftNum() {
		return productNum.get();
	}
	
	public GroupPromotionVO getGroupPromotionVO() {
		return vo;
	}
}
