package po;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 22:59 2017/11/27/027
 */
public class SalesItemPO implements Serializable{
  /**
   * 关键字
   */
  private String keycolumn;
    /**
     * 商品ID
     */
  private   String id;
    /**
     * 商品数量
     */
  private   int number;
    /**
     * 商品价格
     */
  private   double price;

    /**
     * 备注
     */
  private   String ps;

  /**
   * 所属的salesInBill
   */
  private SalesInBillPO salesInBillPO;

  /**
   * 所属的salesOutBill，与salesInBill二选一
   */
  private SalesOutBillPO salesOutBillPO;


}
