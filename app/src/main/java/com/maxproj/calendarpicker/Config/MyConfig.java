package com.maxproj.calendarpicker.Config;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxproj.calendarpicker.Builder;
import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.CalendarMonth;
import com.maxproj.calendarpicker.Models.CalendarWeek;
import com.maxproj.calendarpicker.Models.Custom;
import com.maxproj.calendarpicker.Models.YearMonthDay;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

/**
 * Created by youhy on 17/12/4.
 */

public class MyConfig {

    public static Context app;
    public static Builder builder;
    public static Custom custom;

    public static boolean isPortraitStatus(Activity activity){

        View contentView = activity.findViewById(android.R.id.content);

        int height = contentView.getHeight();
        int width = contentView.getWidth();

        if (height > width){
            return true;
        }else{
            return false;
        }

    }

//    public static int dp2Px(float dp) {
//        final float scale = app.getResources().getDisplayMetrics().density;
//        return (int) (dp * scale + 0.5f); //from http://developer.android.com/guide/practices/screens_support.html#screen-independence
//    }
//
//    public static int px2dip(float pxValue) {
//        final float scale = app.getResources().getDisplayMetrics().density;
//        return (int) (pxValue / scale + 0.5f);
//    }
//
//    public static int getPxFromDimen(int dimen_id) {
//        return app.getResources().getDimensionPixelSize(dimen_id);
//    }
//
//    public static Date string_yyyy_MM_dd_HH_mm2Date(String time) {
//        Date date;
//
//        SimpleDateFormat df = new SimpleDateFormat(MyConfig.app.getString(R.string.time_yyyy_MM_dd_HH_mm));
//        try {
//            date = df.parse(time);
//        } catch (Exception e) {
//            date = null;
//        }
//        return date;
//    }

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



    public static void openCalendarPicker(Activity activity, YearMonthDay preset, Builder.CalendarPickerOnConfirm calendarPickerOnConfirm) {

        FragmentCalendarPicker fragmentCalendarPicker = FragmentCalendarPicker.newInstance(
                preset,
                calendarPickerOnConfirm);
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, fragmentCalendarPicker);
        ft.addToBackStack("com.maxproj.calendarpicker");
        ft.commit();
    }


    public static void uiToast(final String s){

        uiRun(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(app, s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static void uiRun(Runnable runnable){


        if (Looper.myLooper() == Looper.getMainLooper()) {

            if (runnable != null) {
                runnable.run();
            }
        } else {

            // runOnUiThread()) will execute the Runnable immediately.
            // post() always puts the Runnable at the end of the event queue, even if you are already on the main application thread.

            new Handler(Looper.getMainLooper()).post(runnable);

        }

    }

    public static void setTextViewTxt(TextView v, String customStr){

        if(customStr != null){
            v.setText(customStr);
            return;
        }
    }

    public static void setTextViewSize(TextView v, Integer custom_size_sp){

        if(custom_size_sp != null) {
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, custom_size_sp);
        }
    }

    public static void setTextViewColor(TextView v, Integer customColor){

        if(customColor != null) {
            v.setTextColor(customColor);
        }
    }

    public static void setTextViewBgColor(TextView v, Integer customColor){

        if(customColor != null) {
            v.setBackgroundColor(customColor);
        }
    }

    public static void setLayoutBgColor(LinearLayout v, Integer customColor){

        if(customColor != null) {
            v.setBackgroundColor(customColor);
        }
    }

    public static void setDrawableColor(Drawable v, Integer customColor){

        if(customColor != null) {
            if (v instanceof ShapeDrawable) {
                ((ShapeDrawable)v).getPaint().setColor(customColor);
            } else if (v instanceof GradientDrawable) {
                ((GradientDrawable)v).setColor(customColor);
            } else if (v instanceof ColorDrawable) {
                ((ColorDrawable)v).setColor(customColor);
            }
        }
    }



}
