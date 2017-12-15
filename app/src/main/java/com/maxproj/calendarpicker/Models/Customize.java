package com.maxproj.calendarpicker.Models;

import com.maxproj.calendarpicker.Builder;

/**
 * Created by youhy on 17/12/11.
 */

public class Customize {

    /**
     * Calendar Prompt部分
     */
    public String promptText;
    public int promptSize;
    public int promptColor;
    public int promptBgColor;

    public String todayText;
    public int todaySize;
    public int todayColor;
    public int todayBgColor;
    public String selectedText;

    /**
     * Month Title部分
     */
    public Builder.FormatMonthTitle formatMonthTitle;
    public String yearMonth;
    public int yearMonthSize;
    public int yearMonthColor;
    public int yearMonthBgColor;

    /**
     * Week Index部分
     */
    public String weekIndex[];
    public int weekColor;
    public int weekBgColor;


    /**
     * Day部分
     */
    public YearMonthDay preset;

    public int dayColor;
    public int dayBgColor;
    public int dayOtherMonthColor;
    public int dayOtherMonthBgColor;
    public int dayTodayColor;
    public int daySelectedColor;

    /**
     * Confirm部分
     */
    public String cancelText;
    public String confirmText;
    public int confirmSize;
    public int confirmColor;
    public int confirmBgColor;


}
