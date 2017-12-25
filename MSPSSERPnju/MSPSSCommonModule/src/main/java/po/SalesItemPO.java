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

  public SalesItemPO() {
  }

  public SalesItemPO(String id, int number, double price, String ps) {
    this.id = id;
    this.number = number;
    this.price = price;
    this.ps = ps;
  }

  public String getKeycolumn() {
    return keycolumn;
  }

  public void setKeycolumn(String keycolumn) {
    this.keycolumn = keycolumn;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getPs() {
    return ps;
  }

  public void setPs(String ps) {
    this.ps = ps;
  }

  public SalesInBillPO getSalesInBillPO() {
    return salesInBillPO;
  }

  public void setSalesInBillPO(SalesInBillPO salesInBillPO) {
    this.salesInBillPO = salesInBillPO;
  }

  public SalesOutBillPO getSalesOutBillPO() {
    return salesOutBillPO;
  }

  public void setSalesOutBillPO(SalesOutBillPO salesOutBillPO) {
    this.salesOutBillPO = salesOutBillPO;
  }
}
