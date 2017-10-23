package vo;

public class LogListVO {
	int logAmount;
	LogVO[] logList;

	public LogListVO(int i, LogVO[] arr) {
		logAmount = i;
		logList = arr;
	}

	public int getLogAmount() {
		return logAmount;
	}

	public LogVO[] getLogList() {
		return logList;
	}
}
