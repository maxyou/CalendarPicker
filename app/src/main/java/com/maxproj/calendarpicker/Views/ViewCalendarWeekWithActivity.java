package com.maxproj.calendarpicker.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.Models.CalendarWeek;
import com.maxproj.calendarpicker.R;

public class ViewCalendarWeekWithActivity extends LinearLayout {

    CalendarWeek calendarWeek;

    public LinearLayout calendar_week_day_layout;
    public ViewCalendarDayWithActivity calendar_day1;
    public ViewCalendarDayWithActivity calendar_day2;
    public ViewCalendarDayWithActivity calendar_day3;
    public ViewCalendarDayWithActivity calendar_day4;
    public ViewCalendarDayWithActivity calendar_day5;
    public ViewCalendarDayWithActivity calendar_day6;
    public ViewCalendarDayWithActivity calendar_day7;


    public interface DayInWeekOnClickListener {
        void dayOnClicked(CalendarDay day); //1~7
    }
    public DayInWeekOnClickListener dayInWeekOnClickListener;//以后不再使用这个监听器，而是透传dayOnClickListener


    public ViewCalendarWeekWithActivity(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context);
    }

    public ViewCalendarWeekWithActivity(Context context) {

        super(context);

        inflate(context);

    }


    private void inflate(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.calendar_week_with_activity, this, true);

        calendar_week_day_layout = (LinearLayout)v.findViewById(R.id.calendar_week_day_layout);

        calendar_day1 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day1);
        calendar_day2 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day2);
        calendar_day3 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day3);
        calendar_day4 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day4);
        calendar_day5 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day5);
        calendar_day6 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day6);
        calendar_day7 = (ViewCalendarDayWithActivity) v.findViewById(R.id.calendar_day7);

    }


    public void setViewCalendarWeek(CalendarWeek calendarWeek, int highLightMonth){

        writeViewCalendarWeek(calendarWeek, highLightMonth, null, null);
    }

    public void setViewCalendarWeek(CalendarWeek calendarWeek, int highLightMonth, CalendarDay calendarDay,  ViewCalendarDayWithActivity.DayOnClickListener dayOnClickListener){

        writeViewCalendarWeek(calendarWeek, highLightMonth, calendarDay, dayOnClickListener);
    }

    private void writeViewCalendarWeek(CalendarWeek calendarWeek, int highLightMonth, CalendarDay calendarDay,  ViewCalendarDayWithActivity.DayOnClickListener dayOnClickListener) {
        if(calendarWeek == null){
            calendar_week_day_layout.setVisibility(INVISIBLE);
            return;
        }
        calendar_week_day_layout.setVisibility(VISIBLE);

        this.calendarWeek = calendarWeek;

        calendar_day1.setViewCalendarDay(calendarWeek.calendarDayList.get(0), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day2.setViewCalendarDay(calendarWeek.calendarDayList.get(1), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day3.setViewCalendarDay(calendarWeek.calendarDayList.get(2), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day4.setViewCalendarDay(calendarWeek.calendarDayList.get(3), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day5.setViewCalendarDay(calendarWeek.calendarDayList.get(4), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day6.setViewCalendarDay(calendarWeek.calendarDayList.get(5), highLightMonth, calendarDay, dayOnClickListener);
        calendar_day7.setViewCalendarDay(calendarWeek.calendarDayList.get(6), highLightMonth, calendarDay, dayOnClickListener);

    }

}
