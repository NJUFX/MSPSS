package util;

import java.io.Serializable;
import java.util.Calendar;


/**
 * Created by xgy on 2017/11/11.
 */
public class Time implements Serializable{
   public static final String MAX_TIME = "9999-12-31 23:59:59";
   public static final String MIN_TIME = "0000-01-01 00:00:00";
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
    public Time(String time){
        if (time == null || time.equals("")) {
            return;
        }
        String[] times = time.split(" ");
       String[] date = times[0].split("-");

       String[] concrete=  times[1].split(":");
       year = Integer.parseInt(date[0]);
       month = Integer.parseInt(date[1]);
       day = Integer.parseInt(date[2]);

       hour = Integer.parseInt(concrete[0]);
       minute = Integer.parseInt(concrete[1]);
       second = Integer.parseInt(concrete[2]);
    }
    public Time(int year,int month,int day,int hour,int minute,int second){
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
         int month = c.get(Calendar.MONTH)+1;
         int date = c.get(Calendar.DATE);
         int hour = c.get(Calendar.HOUR_OF_DAY);
         int minute = c.get(Calendar.MINUTE);
         int second = c.get(Calendar.SECOND);
        return new Time(year,month,date,hour,minute,second) ;
    }
    public Time(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        year = c.get(Calendar.YEAR);
         month = c.get(Calendar.MONTH)+1;
         day = c.get(Calendar.DATE);
         hour = c.get(Calendar.HOUR_OF_DAY);
         minute = c.get(Calendar.MINUTE);
         second = c.get(Calendar.SECOND);
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
        return String.format("%04d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, second);
    }

    public String getTimeStringWithoutSplit() {
        return String.format("%04d%02d%02d", year, month, day);
    }

    public static String getTimeFormat() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        return String.format("%04d%02d%02d", year, month, day);
    }

    public static void main(String[] args) {
        System.out.println(Time.getInstance().toString());
        System.out.println(Time.getTimeFormat());
        System.out.println(new Time(null));
    }


}
