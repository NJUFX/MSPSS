package vo;

import util.Time;

public class LogVO {
	/**
	 * 日志信息的ID
	 */
	public 	String id;
	/**
	 * 产生该日志的操作者
	 */
	public 	String operator;
	/**
	 * 产生日志信息的时间
	 */
	public Time time;
	/**
	 * 日志记录的操作
	 */
	public String operate;


	public LogVO(String id, String operator, Time time,String operate) {
		this.id = id;
		this.operator = operator;
		this.time = time;
		this.operate = operate;
	}

	public LogVO(String operator, Time time, String operate) {
		this.operator = operator;
		this.time = time;
		this.operate = operate;
	}

	//get方法可以根据需要补充
	public String getId() {
		return id;
	}

	public String getOperator() {
		return operator;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Time getTime() {
		return time;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
