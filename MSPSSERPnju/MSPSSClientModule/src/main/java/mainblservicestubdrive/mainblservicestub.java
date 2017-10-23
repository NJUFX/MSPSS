package blstubdriver.mainblservicestubdrive;

import blservice.mainblservice.MainBLService;
import util.ResultMessage;

public class mainblservicestub implements MainBLService{
    @Override
    public ResultMessage rigister() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage loggin() {
        return ResultMessage.SUCCESS;
    }
}
