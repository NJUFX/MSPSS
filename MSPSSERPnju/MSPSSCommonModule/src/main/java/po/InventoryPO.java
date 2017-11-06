package po;

import java.util.Date;

/**
 * @Project_Name ERPnju
 * @Author: HanXinHu
 * @Description:
 * @Date Created in 19:20 2017/11/6/006
 */
public class InventoryPO {
    /**
     * name 商品名
     * type 商品型号
     * number 库存数量
     * average_price 库存均价
     * batch 批次
     * batch_number 批号
     * ex_date 出厂日期
     */
    String name;
    String type;
    int number;
    double average_price;
    String batch;
    String batch_number;
    Date ex_date;
}
