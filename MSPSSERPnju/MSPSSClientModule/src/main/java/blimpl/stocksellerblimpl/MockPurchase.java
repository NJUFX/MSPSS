package blimpl.stocksellerblimpl;

import vo.PurchaseVO;

public class MockPurchase extends Purchase {
    /**
     * 创建进货单
     *
     * @param purchase
     * @return
     */
    @Override
    public boolean createPurchase(PurchaseVO purchase) {
        return true;
    }
}
