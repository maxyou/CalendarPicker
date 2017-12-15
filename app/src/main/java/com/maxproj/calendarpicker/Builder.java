package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Models.YearMonthDay;

/**
 * Created by youhy on 17/12/11.
 */

public class Builder {

    private Activity activity;
    private CalendarPickerOnConfirm calendarPickerOnConfirm;


    /**
     * Calendar Prompt部分
     */
    public Builder setPromptText(String promptText){
        MyConfig.customize.promptText = promptText;
        return this;
    }

    public Builder setPromptSize(int promptSize){
        MyConfig.customize.promptSize = promptSize;
        return this;
    }

    public Builder setPromptColor(int promptColor){
        MyConfig.customize.promptColor = promptColor;
        return this;
    }

    public Builder setPromptBgColor(int promptBgColor){
        MyConfig.customize.promptBgColor = promptBgColor;
        return this;
    }

    public Builder setTodayText(String todayText){
        MyConfig.customize.todayText = todayText;
        return this;
    }

    public Builder setTodaySize(int todaySize){
        MyConfig.customize.todaySize = todaySize;
        return this;
    }

    public Builder setTodayColor(int todayColor){
        MyConfig.customize.todayColor = todayColor;
        return this;
    }

    public Builder setTodayBgColor(int todayBgColor){
        MyConfig.customize.todayBgColor = todayBgColor;
        return this;
    }

    public Builder setSelectedText(String selectedText){
        MyConfig.customize.selectedText = selectedText;
        return this;
    }


    public Builder setSelectedSize(int selectedSize){
        MyConfig.customize.selectedSize = selectedSize;
        return this;
    }

    public Builder setSelectedColor(int selectedColor){
        MyConfig.customize.selectedColor = selectedColor;
        return this;
    }

    public Builder setSelectedBgColor(int selectedBgColor){
        MyConfig.customize.selectedBgColor = selectedBgColor;
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

    public Builder setCancelText(String cancelText){
        MyConfig.customize.cancelText = cancelText;
        return this;
    }

    public Builder setConfirmText(String confirmText){
        MyConfig.customize.confirmText = confirmText;
        return this;
    }




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
