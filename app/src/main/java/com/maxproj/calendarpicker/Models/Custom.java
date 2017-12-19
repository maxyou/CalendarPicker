package com.maxproj.calendarpicker.Models;

import com.maxproj.calendarpicker.Builder;

/**
 * Created by youhy on 17/12/11.
 */

public class Custom {

    /**
     * Calendar Prompt部分
     */
    public String promptText = "Please Pick a Day";
    public Integer promptSize = 18;
    public Integer promptColor = 0xFF696969;
    public Integer promptBgColor = 0xFFFFFFFF;

    public String todayText = "Today";
    public Integer todaySize = 12;
    public Integer todayColor = 0xFFFFFFFF;;
    public Integer todayBgColor = 0xFF1E90FF;

    public String selectedText = "Selected";
    public Integer selectedSize = 12;
    public Integer selectedColor = 0xFFFFFFFF;;
    public Integer selectedBgColor = 0xFF00BF00;

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
    public Integer confirmColor = 0xFFFF0000;
    public Integer confirmBgColor = 0xFF00FF00;


    /**
     * jump to preset if have
     */
    public boolean jump2Preset;
}
