package util;

/**
 * created by hanxinhu at 2017/12/20
 */
public enum Kind_Of_Users {
    SystemManager,

    StockManager,

    StockSeller,

    StockSellerManager,

    Financer,

    FinancerManager,

    ChiefManager;

    public int getNumber() {
        if (this == StockManager)
            return 1;
        if (this == StockSeller)
            return 2;
        if (this == StockSellerManager)
            return 3;
        if (this == Financer)
            return 4;
        if (this == FinancerManager)
            return 5;
        if (this == ChiefManager)
            return 6;
        if (this == SystemManager)
            return 7;
        return 0;
    }
}
