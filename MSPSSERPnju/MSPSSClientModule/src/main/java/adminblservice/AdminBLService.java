package blservice.adminblservice;

import util.ResultMessage;

public interface AdminBLService {
    public ResultMessage addAccount();
    public ResultMessage modifyAccount();
    public ResultMessage deleteAccount();

}
