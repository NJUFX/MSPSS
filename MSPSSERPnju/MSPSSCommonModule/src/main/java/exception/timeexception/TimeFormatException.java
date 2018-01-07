package exception.timeexception;

import util.Time;

/**
 * Created by thinkpad on 2018/1/7.
 */

/**
 * 时间格式异常类，在时间超出格式时抛出异常
 */
public class TimeFormatException extends TimeException {

    private String time;
    public TimeFormatException(String time){
        this.time = time;
    }
    @Override
    public String toString(){
        return time;
    }
}
