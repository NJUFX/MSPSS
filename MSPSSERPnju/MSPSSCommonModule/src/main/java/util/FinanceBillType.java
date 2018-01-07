package util;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 15:33 2017/11/28/028
 */
public enum  FinanceBillType implements Serializable {
    /**
     * 收款单
     */
    IN,
    /**
     * 付款单
     */
    OUT;

    @Override
    public String toString() {
        if (this==IN)
            return "收款单";
        return "付款单";
    }
}
