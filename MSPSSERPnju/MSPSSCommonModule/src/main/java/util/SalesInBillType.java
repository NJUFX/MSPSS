package util;

import java.io.Serializable;

/**
 * Description: 区分进货类单据中的进货单和进货退货单
 * Created by Hanxinhu at 21:20 2017/11/27/027
 */
public enum  SalesInBillType implements Serializable {
    /**
     * 进货单
     */
    IN ,
    /**
     * 进货退货单
     */
    OUT;

}
