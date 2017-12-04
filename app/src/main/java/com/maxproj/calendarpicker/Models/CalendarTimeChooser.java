package com.maxproj.calendarpicker.Models;


import com.maxproj.calendarpicker.Utilities.MyConfig;

public class CalendarTimeChooser {

    public static class Time{
        public int hour;
        public int minute;

        public Time(int hour, int minute){
            /**
             * -1表示没有预置时间，那么使用当前时间，所有类似
             */
            this.hour = hour;
            this.minute = minute;
        }
    }

    public static class Month{
        public int year;
        public int month;
        public int day;

        public Month(int year, int month, int day){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

//    public CalendarTimeChooser(Time time){
//        this.time = time;
//    }
//
//    public CalendarTimeChooser(Month month){
//        this.month = month;
//    }

    public CalendarTimeChooser(Month month, Time time){
        this.time = time;
        this.month = month;
    }

    public Time time;
    public Month month;

    public String timeShow(){
        return "" +month.year+"-"+month.month+"-"+month.day+" "+((time.hour<10)?"0":"")+time.hour+":"+((time.minute<10)?"0":"")+time.minute;
    }

    public long transToLong(){
        return MyConfig.string_yyyy_MM_dd_HH_mm2Date(
                timeShow()
        ).getTime();
    }

}
