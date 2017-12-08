package po;

import util.PromotionType;


import java.io.Serializable;
import java.util.List;

public class PromotionPO implements Serializable{
	/**
	 * 策略编号
	 */
	private String promotionID;

	/**
	 * 策略名称
	 */
	private String promotionName;

	/**
	 * 策略类型
	 */
	private PromotionType promotionType;

	/**
	 * 策略折扣
	 */
	private double promotionDiscount;

	/**
	 * 策略所需最低金额
	 */
	private double leastMoney;

	/**
	 * 赠送的代金券金额
	 */
	private double voucher;

	/**
	 *赠品
	 */
	private List<String> giftID;

	/**
	 * 组合商品
	 */
	private List<String> commodityID;

	/**
	 * 组合价
	 */
	private double fixedCost;

	/**
	 * 策略执行开始日期
	 */
	private String startDate;

	/**
	 * 策略执行结束日期
	 */
	private String endDate;

	/**
	 * 执行策略所需的最低用户等级
	 */
	private int clientGrade;
}