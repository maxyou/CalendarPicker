package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.YearMonthDay;

/**
 * Created by youhy on 17/12/11.
 */

public class Builder {

    Activity activity;
    FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm;

    YearMonthDay preset;


    public Builder setPreset(YearMonthDay preset){
        this.preset = preset;
        return this;
    }



    public Builder(Activity activity, FragmentCalendarPicker.CalendarPickerOnConfirm calendarPickerOnConfirm){
        this.activity = activity;
        this.calendarPickerOnConfirm = calendarPickerOnConfirm;
    }

    public Builder build(){
        return this;
    }

    public void show(){
        MyConfig.openCalendarPicker(activity, preset, calendarPickerOnConfirm);
    }
}
