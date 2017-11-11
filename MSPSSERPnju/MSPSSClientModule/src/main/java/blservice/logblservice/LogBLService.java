package blservice.logblservice;

import util.ResultMessage;
import vo.LogVO;
import vo.LogListVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/12
 *
 */
public interface LogBLService {
/**
 * 搜索日志记录
 * 
 * @param Time
 * @return ArrayList<LogPO>
 */
	public ArrayList<LogPO> search(Time date);
	
/**
 * 显示日志列表
 * 
 * @param Time
 * @return LogListVO
 */
	public LogListVO showLogList(ArrayList<LogPO> logList);
	
/**
 * 显示日志详情
 * 
 * @param LogPO
 * @return LogVO
 */
	public LogListVO showLogList(ArrayList<LogPO> logList);
	

}
