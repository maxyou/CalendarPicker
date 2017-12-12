package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.Customize;
import com.maxproj.calendarpicker.Models.YearMonthDay;

/**
 * Created by youhy on 17/12/11.
 */

public class Builder {

    private Activity activity;
    private FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm;


    public interface FormatMonthTitle{
        String setMonthTitle(int year, int month);
    }

    public Builder setMonthTitle(FormatMonthTitle formatMonthTitle){
        MyConfig.customize.formatMonthTitle = formatMonthTitle;
        return this;
    }

    public Builder setPreset(YearMonthDay preset){
        MyConfig.customize.preset = preset;
        return this;
    }

    public Builder setSelectedText(String selectedText){
        MyConfig.customize.selected = selectedText;
        return this;
    }

    public Builder setTodayText(String todayText){
        MyConfig.customize.today = todayText;
        return this;
    }


    public Builder(Activity activity, FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm){
        this.activity = activity;
        this.calendarPickerOnConfirm = calendarPickerOnConfirm;
        MyConfig.customize = new Customize();
    }

//    public Builder build(){
//        return this;
//    }

    public void show(){
        MyConfig.builder = this;
        MyConfig.openCalendarPicker(activity, MyConfig.customize.preset, calendarPickerOnConfirm);
    }
}
