package util;

/**
 * Description:
 * Created by Hanxinhu at 19:50 2017/11/27/027
 */
public enum StockBillType {
    /**
     *  库存赠送单
     */
    Presentation,
    /**
     * 库存报溢单
     */
    More,
    /**
     * 库存报损单
     */
    Less;

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        switch (this) {
            case Less:
                return "KCBSD";
            case More:
                return "KCBYD";
            case Presentation:
                return "KCZSD";
        }
        return super.toString();
    }
}
