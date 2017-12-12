package filterflags;

/**
 * Description:
 * Created by Hanxinhu at 22:48 2017/12/11/011
 */
public enum CustomerSearchFlag {
    /**
     *编号
     */
    ID("ID"),
    /**
     *客户名
     */
    NAME("name"),
    /**
     *客户登记
     */
    LEVEL("level"),
    /**
     * 客户分类
     */
    KIND("category"),
    /**
     * 业务员
     */
    DAE("DAE"),
    /**
     *
     * 应收额度
     */
    INVALUE("Invalue");
    ;
    private String keyType;
    CustomerSearchFlag(String keyType){
        this.keyType = keyType;
    }
    @Override
    public String toString() {
        return keyType;
    }
}
