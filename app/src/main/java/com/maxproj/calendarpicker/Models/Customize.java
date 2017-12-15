package com.maxproj.calendarpicker.Models;

import com.maxproj.calendarpicker.Builder;

/**
 * Created by youhy on 17/12/11.
 */

public class Customize {

    /**
     * Calendar Title部分
     */
    public String title_str;
    public int title_size;
    public int title_color;
    public int title_bg_color;

    public String selected;
    public String today;
    public int today_size;
    public int today_color;
    public int today_bg_color;

    /**
     * Month Title部分
     */
    public Builder.FormatMonthTitle formatMonthTitle;
    public String year_month;
    public int year_month_size;
    public int year_month_color;
    public int year_month_bg_color;

    /**
     * Week Index部分
     */
    public String weekIndex[];
    public int capital_color;
    public int capital_bg_color;


    /**
     * Day部分
     */
    public YearMonthDay preset;

    public int day_color;
    public int day_bg_color;
    public int day_other_month_color;
    public int day_other_month_bg_color;
    public int day_today_color;
    public int day_selected_color;

    /**
     * Confirm部分
     */
    public String cancel;
    public String confirm;
    public int confirm_size;
    public int confirm_color;
    public int confirm_bg_color;


}
