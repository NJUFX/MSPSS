package vo;

import util.Time;

/**
 * Description:
 * Created by Hanxinhu at 22:26 2017/12/8/008
 */
public class LogFilterVO {
    /**
     * 起始时间
     */
    public Time startTime;
    /**
     * 终止时间
     */
    public Time endTime;
    /**
     * 操作员
     */
    public  String operator;
    /**
     * 操作
     */
    public String operate;
    public LogFilterVO(){

    }

    public LogFilterVO(Time startTime, Time endTime, String operator, String operate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.operator = operator;
        this.operate = operate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
