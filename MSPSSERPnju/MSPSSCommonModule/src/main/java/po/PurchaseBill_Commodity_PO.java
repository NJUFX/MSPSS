package po;

/**
 * Created by thinkpad on 2017/12/3.
 */
public class PurchaseBill_Commodity_PO {
    /**
     * 数据库关键字，数据库会自动赋值！！切勿自己赋值
     */
    private String keycolumn;
    /**
     * 商品名称
     */
    private String name;

    /**
     * 位于的商品分类ID
     */
    private String classificationID;

    /**
     * 型号
     */
    private String type;

    /**
     * 商品编号
     */
    private String ID;

    /**
     * 进价
     */
    private double importCost;

    /**
     * 零售价
     */
    private double exportCost;

    /**
     * 库存数量(要与stock同步,这可能会出bug!!!!!!）
     */
    private int numberInStock;

    /**
     *多对一映射中对应的链表
     */
    private PurchaseBillPO purchasebill;
}
