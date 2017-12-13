package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.YearMonthDay;

/**
 * Created by youhy on 17/12/11.
 */

public class Builder {

    private Activity activity;
    private CalendarPickerOnConfirm calendarPickerOnConfirm;


    /**
     * Calendar Title部分
     */
    public Builder setSelectedText(String selectedText){
        MyConfig.customize.selected = selectedText;
        return this;
    }

    public Builder setTodayText(String todayText){
        MyConfig.customize.today = todayText;
        return this;
    }

    /**
     * Month Title部分
     */

    public interface FormatMonthTitle{
        String setMonthTitle(int year, int month);
    }

    public Builder setMonthTitle(FormatMonthTitle formatMonthTitle){
        MyConfig.customize.formatMonthTitle = formatMonthTitle;
        return this;
    }

    /**
     * Week Index部分
     */

    public Builder setWeekIndex(String index[]){
        MyConfig.customize.weekIndex = index;
        return this;
    }


    /**
     * Day部分
     */


    public Builder setPreset(YearMonthDay preset){
        MyConfig.customize.preset = preset;
        return this;
    }

    /**
     * Confirm部分
     */

    public interface CalendarPickerOnConfirm {
        void onComplete(YearMonthDay yearMonthDay);
    }

    public Builder(Activity activity, CalendarPickerOnConfirm calendarPickerOnConfirm){
        this.activity = activity;
        this.calendarPickerOnConfirm = calendarPickerOnConfirm;
    }

//    public Builder build(){
//        return this;
//    }

    public void show(){
        MyConfig.builder = this;
        MyConfig.openCalendarPicker(activity, MyConfig.customize.preset, calendarPickerOnConfirm);
    }
}
