package com.maxproj.calendarpicker.Models;

import android.util.Log;

import org.joda.time.LocalDate;



/**
 * Created by youhy on 5/13/15.
 */
public class CalendarDay {

    public org.joda.time.LocalDate day;
    public boolean have_activity = false;

    public CalendarDay(org.joda.time.LocalDate day, boolean have_activity) {
        this.day = day;
        this.have_activity = have_activity;
    }

    public CalendarDay(org.joda.time.LocalDate day) {

        this.day = day;
        this.have_activity = false;
    }

    public CalendarDay() {

        this.day = null;
        this.have_activity = false;
    }

    public CalendarDay(int year, int month, int day) {

        this.day = new LocalDate(year, month,day);
        this.have_activity = false;
    }

    public void copy(CalendarDay calendarDay){

        if(calendarDay == null){
            Log.d("","EventCalendarSelectDay: CalendarDay copy null ");
            this.day = null;
            this.have_activity = false;
            return;
        }

        if(calendarDay.day == null){
            Log.d("", "EventCalendarSelectDay: CalendarDay copy null 2");
        }else {
            Log.d("", "EventCalendarSelectDay: CalendarDay copy: " + calendarDay.day.toString());
        }
        this.day = calendarDay.day;
        this.have_activity = calendarDay.have_activity;
    }

    public static CalendarDay clone(CalendarDay calendarDay){

        //即便源是null，也clone一份实体，只是实体内容为未初始化
        CalendarDay calendarDay_clone = new CalendarDay();
        calendarDay_clone.copy(calendarDay);
        return calendarDay_clone;
    }
}
