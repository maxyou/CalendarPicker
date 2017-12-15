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
    public Integer promptSize;
    public Integer promptColor;
    public Integer promptBgColor;

    public String todayText;
    public Integer todaySize;
    public Integer todayColor;
    public Integer todayBgColor;

    public String selectedText;
    public Integer selectedSize;
    public Integer selectedColor;
    public Integer selectedBgColor;

    /**
     * Month Title部分
     */
    public Builder.FormatMonthTitle formatMonthTitle;
    public String yearMonth;
    public Integer yearMonthSize;
    public Integer yearMonthColor;
    public Integer yearMonthBgColor;

    /**
     * Week Index部分
     */
    public String weekIndex[];
    public Integer weekColor;
    public Integer weekBgColor;


    /**
     * Day部分
     */
    public YearMonthDay preset;

    public Integer dayColor;
    public Integer dayBgColor;
    public Integer dayOtherMonthColor;
    public Integer dayOtherMonthBgColor;
    public Integer dayTodayColor;
    public Integer daySelectedColor;

    /**
     * Confirm部分
     */
    public String cancelText;
    public String confirmText;
    public Integer confirmSize;
    public Integer confirmColor;
    public Integer confirmBgColor;


}
