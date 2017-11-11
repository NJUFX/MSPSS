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

    public int getyear(){
        return year;
    }

    public int getmonth(){
        return month;
    }
    public int getday(){
        return day;
    }
    public int gethour(){
        return year;
    }
    public int getminute(){
        return year;
    }
    public int getsecond(){
        return year;
    }

    public boolean isBefore(Time time){
        return true;
    }
}
