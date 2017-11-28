package util;

/**
 * Created by xgy on 2017/11/11.
 */
public class Time {

    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;

    public Time(int yaer,int month,int day,int hour,int minute,int second){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return year;
    }
    public int getSecond(){
        return year;
    }

    public boolean isBefore(Time time){
        return true;
    }
}
