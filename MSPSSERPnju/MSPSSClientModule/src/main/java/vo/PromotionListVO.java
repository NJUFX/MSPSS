package vo;

public class PromotionListVO {
	PromotionVO[] currentPromotion;

	public PromotionListVO(PromotionVO[] p) {
		currentPromotion = p;
	}

	public PromotionVO[] getCurrentPromotion() {
		return currentPromotion;
	}
}
