package blstubdriver.admainblservicestubdrive;

import blservice.adminblservice.AdminBLService;
import util.ResultMessage;

public class adminblservicestub implements AdminBLService {
    @Override
    public ResultMessage addAccount() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyAccount() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteAccount() {
        return ResultMessage.SUCCESS;
    }
}
