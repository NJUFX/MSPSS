package util;

import java.util.Calendar;
import java.util.concurrent.ThreadPoolExecutor;

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
    public Time(String time){

    }
    public Time(int yaer,int month,int day,int hour,int minute,int second){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
     public static Time getInstance() {
         Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
         int year = c.get(Calendar.YEAR);
         int month = c.get(Calendar.MONTH);
         int date = c.get(Calendar.DATE);
         int hour = c.get(Calendar.HOUR_OF_DAY);
         int minute = c.get(Calendar.MINUTE);
         int second = c.get(Calendar.SECOND);
        return new Time(year,month,date,hour,minute,second) ;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
