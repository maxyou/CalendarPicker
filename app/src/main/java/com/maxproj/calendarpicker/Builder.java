package com.maxproj.calendarpicker;

import android.app.Activity;

import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Models.Custom;
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
        MyConfig.custom.promptText = promptText;
        return this;
    }

    public Builder setPromptSize(int promptSize){
        MyConfig.custom.promptSize = promptSize;
        return this;
    }

    public Builder setPromptColor(int promptColor){
        MyConfig.custom.promptColor = promptColor;
        return this;
    }

    public Builder setPromptBgColor(int promptBgColor){
        MyConfig.custom.promptBgColor = promptBgColor;
        return this;
    }

    public Builder setTodayText(String todayText){
        MyConfig.custom.todayText = todayText;
        return this;
    }

    public Builder setTodaySize(int todaySize){
        MyConfig.custom.todaySize = todaySize;
        return this;
    }

    public Builder setTodayColor(int todayColor){
        MyConfig.custom.todayColor = todayColor;
        return this;
    }

    public Builder setTodayBgColor(int todayBgColor){
        MyConfig.custom.todayBgColor = todayBgColor;
        return this;
    }

    public Builder setSelectedText(String selectedText){
        MyConfig.custom.selectedText = selectedText;
        return this;
    }


    public Builder setSelectedSize(int selectedSize){
        MyConfig.custom.selectedSize = selectedSize;
        return this;
    }

    public Builder setSelectedColor(int selectedColor){
        MyConfig.custom.selectedColor = selectedColor;
        return this;
    }

    public Builder setSelectedBgColor(int selectedBgColor){
        MyConfig.custom.selectedBgColor = selectedBgColor;
        return this;
    }
    
    /**
     * Month Title部分
     */

    public interface FormatMonthTitle{
        String setMonthTitle(int year, int month);
    }

    public Builder setMonthTitle(FormatMonthTitle formatMonthTitle){
        MyConfig.custom.formatMonthTitle = formatMonthTitle;
        return this;
    }


    public Builder setMonthTitleSize(int monthTitleSize){
        MyConfig.custom.monthTitleSize = monthTitleSize;
        return this;
    }

    public Builder setMonthTitleColor(int monthTitleColor){
        MyConfig.custom.monthTitleColor = monthTitleColor;
        return this;
    }

    public Builder setMonthTitleBgColor(int monthTitleBgColor){
        MyConfig.custom.monthTitleBgColor = monthTitleBgColor;
        return this;
    }


    /**
     * Week Index部分
     */

    public Builder setWeekIndex(String index[]){
        MyConfig.custom.weekIndex = index;
        return this;
    }

    public Builder setWeekIndexSize(int weekIndexSize){
        MyConfig.custom.weekIndexSize = weekIndexSize;
        return this;
    }

    public Builder setWeekIndexColor(int weekIndexColor){
        MyConfig.custom.weekIndexColor = weekIndexColor;
        return this;
    }

    public Builder setWeekIndexBgColor(int weekIndexBgColor){
        MyConfig.custom.weekIndexBgColor = weekIndexBgColor;
        return this;
    }


    /**
     * Day部分
     */


    public Builder setPreset(YearMonthDay preset){
        MyConfig.custom.preset = preset;
        return this;
    }

    /**
     * Confirm部分
     */

    public Builder setCancelText(String cancelText){
        MyConfig.custom.cancelText = cancelText;
        return this;
    }

    public Builder setCancelSize(int cancelSize){
        MyConfig.custom.cancelSize = cancelSize;
        return this;
    }

    public Builder setCancelColor(int cancelColor){
        MyConfig.custom.cancelColor = cancelColor;
        return this;
    }

    public Builder setCancelBgColor(int cancelBgColor){
        MyConfig.custom.cancelBgColor = cancelBgColor;
        return this;
    }


    public Builder setConfirmText(String confirmText){
        MyConfig.custom.confirmText = confirmText;
        return this;
    }

    public Builder setConfirmSize(int confirmSize){
        MyConfig.custom.confirmSize = confirmSize;
        return this;
    }

    public Builder setConfirmColor(int confirmColor){
        MyConfig.custom.confirmColor = confirmColor;
        return this;
    }

    public Builder setConfirmBgColor(int confirmBgColor){
        MyConfig.custom.confirmBgColor = confirmBgColor;
        return this;
    }



    public interface CalendarPickerOnConfirm {
        void onComplete(YearMonthDay yearMonthDay);
    }

    public Builder(Activity activity, CalendarPickerOnConfirm calendarPickerOnConfirm){
        this.activity = activity;
        this.calendarPickerOnConfirm = calendarPickerOnConfirm;
    }


    public Builder restoreDefault(){
        MyConfig.custom = new Custom();
        return this;
    }

    public void show(){
        MyConfig.builder = this;
        MyConfig.openCalendarPicker(activity, MyConfig.custom.preset, calendarPickerOnConfirm);
    }
}
