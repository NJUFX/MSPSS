package blimpl.billblimpl;

import util.ResultMessage;
import vo.FilterFlagVO;
import vo.FinanceBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:50 2017/11/21/021
 */
public class MockFinanceBill extends FinanceBill {
    @Override
    public ResultMessage addFinanceBill(FinanceBillVO financeBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateFinanceBill(FinanceBillVO financeBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<FinanceBillVO> searchFinanceBill(FilterFlagVO flagVO) {
        return new ArrayList<FinanceBillVO>();
    }
}
