package blimpl.generalaccountblimpl;

import util.ResultMessage;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;

public class MockGeneralAccount extends GeneralAccount {
    public MockGeneralAccount() {
        super();
    }

    /**
     * 添加期初账户
     *
     * @param generalAccountVO@return ResultMessage
     */
    @Override
    public ResultMessage addGeneralAcocunt(GeneralAccountVO generalAccountVO) {
        return super.addGeneralAcocunt(generalAccountVO);
    }

    /**
     * 精确查找商品
     *
     * @param field
     * @param id
     * @return
     */
    @Override
    public GeneralAccountVO exactlySearchGeneralAccount(String field, String id) {
        return super.exactlySearchGeneralAccount(field, id);
    }

    @Override
    public ArrayList<GeneralAccountVO> fullSearchGeneralAccount(String field, Object value) {
        return super.fullSearchGeneralAccount(field, value);
    }

    /**
     * @param filed
     * @param value
     * @return
     */
    @Override
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccount(String filed, String value) {
        return super.fuzzySearchGeneralAccount(filed, value);
    }

    /**
     * @param field
     * @param min
     * @param max
     * @return
     */
    @Override
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccount(String field, Object min, Object max) {
        return super.rangeSearchGeneralAccount(field, min, max);
    }

    /**
     * 在已有数据库中搜索客户
     *
     * @param name
     * @return
     */
    @Override
    public CustomerVO searchCustomer(String name) {
        return super.searchCustomer(name);
    }

    /**
     * 在已有数据库中搜索商品
     *
     * @param name
     * @return
     */
    @Override
    public CommodityVO searchCommodity(String name) {
        return super.searchCommodity(name);
    }
}
