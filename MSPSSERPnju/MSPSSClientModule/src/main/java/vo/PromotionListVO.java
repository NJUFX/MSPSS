package vo;

import java.util.ArrayList;

public class PromotionListVO {
	ArrayList<PromotionVO> currentPromotion = new ArrayList<PromotionVO>();

	public PromotionListVO(ArrayList<PromotionVO> p) {

		currentPromotion = p;
	}

	public ArrayList<PromotionVO> getCurrentPromotion() {

		return currentPromotion;
	}
}