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
    public Integer monthTitleSize = 18;
    public Integer monthTitleColor = 0xFF696969;
    public Integer monthTitleBgColor = 0x00000000;

    /**
     * Week Index部分
     */
    public String weekIndex[] = new String[]{"M", "T", "W", "T", "F", "S", "S"};
    public Integer weekIndexSize = 15;
    public Integer weekIndexColor = 0xFFD2691E;
    public Integer weekIndexBgColor = 0x00000000;


    /**
     * Day部分
     */
    public YearMonthDay preset;

    public Integer daySize = 14;
    public Integer daySelectedSize = 16;
    public Integer dayTodaySize = 16;
    public Integer dayColor = 0xFF696969;
//    public Integer dayBgColor;
    public Integer dayOtherMonthColor = 0xFFD3D3D3;
//    public Integer dayOtherMonthBgColor;
    public Integer monthBaseBgColor = 0xFFFFEBCD;

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
