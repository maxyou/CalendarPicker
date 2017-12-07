package com.maxproj.calendarpicker.Utilities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;

import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.CalendarMonth;
import com.maxproj.calendarpicker.Models.YearMonthDay;
import com.maxproj.calendarpicker.Models.CalendarWeek;
import com.maxproj.calendarpicker.R;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by youhy on 17/12/4.
 */

public class MyConfig {

    public static Context app;

//    public static WindowManager wm;
//    public static float scale;
//    public static int screenWidth;
//    public static int screenHeight;

    public static int dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f); //from http://developer.android.com/guide/practices/screens_support.html#screen-independence
//        return (int) Math.round(scale * dp);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getPxFromDimen(Context context, int dimen_id) {
        return context.getResources().getDimensionPixelSize(dimen_id);
    }

    public static Date string_yyyy_MM_dd_HH_mm2Date(String time) {
        Date date;

        SimpleDateFormat df = new SimpleDateFormat(MyConfig.app.getString(R.string.time_yyyy_MM_dd_HH_mm));
        //df.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        try {
            date = df.parse(time);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static CalendarWeek getWeekIncludeThisDay(LocalDate localDate) {

        LocalDate monday = localDate.withDayOfWeek(DateTimeConstants.MONDAY);
        LocalDate tuesday = localDate.withDayOfWeek(DateTimeConstants.TUESDAY);
        LocalDate wednesday = localDate.withDayOfWeek(DateTimeConstants.WEDNESDAY);
        LocalDate thursday = localDate.withDayOfWeek(DateTimeConstants.THURSDAY);
        LocalDate friday = localDate.withDayOfWeek(DateTimeConstants.FRIDAY);
        LocalDate saturday = localDate.withDayOfWeek(DateTimeConstants.SATURDAY);
        LocalDate sunday = localDate.withDayOfWeek(DateTimeConstants.SUNDAY);

        CalendarWeek calendarWeek = new CalendarWeek(
                monday,
                tuesday,
                wednesday,
                thursday,
                friday,
                saturday,
                sunday
        );
        calendarWeek.firstDayOfCurrentMonth = localDate.withDayOfMonth(1);
        calendarWeek.originDate = localDate;

        return calendarWeek;
    }


    public static CalendarMonth getMonthIncludeThisDay(LocalDate localDate) {


        CalendarMonth calendarMonth = new CalendarMonth();

        calendarMonth.firstDayOfCurrentMonth = localDate.withDayOfMonth(1);

        for (int i = 0; i < 6; i++) {//每个月最多6周，最少4周
            CalendarWeek w = getWeekIncludeThisDay(calendarMonth.firstDayOfCurrentMonth.plusDays(7 * i));

            if (i < 4) {
                calendarMonth.calendarWeeks.addLast(w);
            } else if (w.calendarDayList.getFirst().day.getMonthOfYear() == calendarMonth.firstDayOfCurrentMonth.getMonthOfYear()) {
                /**
                 * 从第5周开始检
                 * 如果w的第一天的月份等于本月第一天的月份，那么这一周也算本月的周
                 */
                calendarMonth.calendarWeeks.addLast(w);
            } else {
                break;
            }

        }
        calendarMonth.originDate = localDate;

        return calendarMonth;
    }



    public static void openCalendarPicker(Activity activity, YearMonthDay preset, FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm) {

        FragmentCalendarPicker fragmentCalendarPicker = FragmentCalendarPicker.newInstance(
                preset,
                calendarPickerOnConfirm);
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, fragmentCalendarPicker);
        ft.addToBackStack("com.maxproj.calendarpicker");
        ft.commit();
    }
}
