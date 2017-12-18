package com.maxproj.calendarpicker.Models;

import com.maxproj.calendarpicker.Builder;

/**
 * Created by youhy on 17/12/11.
 */

public class Custom {

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
//    public String yearMonth;
    public Integer monthTitleSize;
    public Integer monthTitleColor;
    public Integer monthTitleBgColor;

    /**
     * Week Index部分
     */
    public String weekIndex[];
    public Integer weekIndexSize;
    public Integer weekIndexColor;
    public Integer weekIndexBgColor;


    /**
     * Day部分
     */
    public YearMonthDay preset;

    public Integer daySize;
    public Integer dayColor;
    public Integer dayBgColor;
    public Integer dayOtherMonthColor;
    public Integer dayOtherMonthBgColor;
    public Integer monthBaseBgColor;

    /**
     * Confirm部分
     */
    public String cancelText;
    public Integer cancelSize;
    public Integer cancelColor;
    public Integer cancelBgColor;
    public String confirmText;
    public Integer confirmSize;
    public Integer confirmColor;
    public Integer confirmBgColor;


}
