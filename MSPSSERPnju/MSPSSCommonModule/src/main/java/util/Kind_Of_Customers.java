package util;

import java.io.Serializable;

public enum Kind_Of_Customers implements Serializable {

    SALER, //销售商
    SUPPLIER; //进货商

    @Override
    public String toString() {
        if (this==SALER)
            return "销售商";
        return "供货商";
    }
}
