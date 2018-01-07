package exception.timeexception;

/**
 * Created by thinkpad on 2018/1/7.
 */

/**
 * 时间范围异常，在时间范围超出时间范围时抛出异常
 */
public class TimeRangeException extends TimeException {
    private String time;
    public TimeRangeException(String time){
        this.time = time;
    }

    @Override
    public String toString(){
        return time;
    }
}
