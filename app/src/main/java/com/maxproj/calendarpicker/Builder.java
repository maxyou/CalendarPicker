package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.Options;
import com.maxproj.calendarpicker.Models.YearMonthDay;

/**
 * Created by youhy on 17/12/11.
 */

public class Builder {

    private Activity activity;
    private FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm;


    public Builder setPreset(YearMonthDay preset){
        MyConfig.options.preset = preset;
        return this;
    }

    public Builder setTodayText(String todayText){
        MyConfig.options.today = todayText;
        return this;
    }


    public Builder(Activity activity, FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm){
        this.activity = activity;
        this.calendarPickerOnConfirm = calendarPickerOnConfirm;
        MyConfig.options = new Options();
    }

//    public Builder build(){
//        return this;
//    }

    public void show(){
        MyConfig.builder = this;
        MyConfig.openCalendarPicker(activity, MyConfig.options.preset, calendarPickerOnConfirm);
    }
}
