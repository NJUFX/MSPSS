package java.dataservicestubdrive;

import util.ResultMessage;

import java.dataservice.BillDataService;

public class BillDataServiceStub implements BillDataService {
    @Override
    public ResultMessage MakeLossAndOverflowReport() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage MakePresentationReport() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage DealAlarmReport() {
        return ResultMessage.SUCCESS;
    }
}
