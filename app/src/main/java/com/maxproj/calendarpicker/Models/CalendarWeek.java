package com.maxproj.calendarpicker.Models;

import org.joda.time.LocalDate;

import java.util.LinkedList;

/**
 * Created by youhy on 5/13/15.
 */
public class CalendarWeek {
    /**
     * 注意，week和年月日是不同的体系，往往跨越年和月，所以定义特殊
     * 上个月的最后一周和本月的第一周可能是一样的
     * 我们需要的是，根据月的第一天得到本月所有的week
     */
    public LocalDate firstDayOfCurrentMonth;
    public LocalDate originDate;
    public LinkedList<CalendarDay> calendarDayList = new LinkedList<>();

    public CalendarWeek(LinkedList<CalendarDay> calendarDayList){
        this.calendarDayList = calendarDayList;
    }

    public CalendarWeek(
            LocalDate d1,
            LocalDate d2,
            LocalDate d3,
            LocalDate d4,
            LocalDate d5,
            LocalDate d6,
            LocalDate d7
    ){
        calendarDayList.clear();

//        calendarDayList.add(new CalendarDay(d1, false));
//        calendarDayList.add(new CalendarDay(d2, false));
//        calendarDayList.add(new CalendarDay(d3, false));
//        calendarDayList.add(new CalendarDay(d4, false));
//        calendarDayList.add(new CalendarDay(d5, false));
//        calendarDayList.add(new CalendarDay(d6, false));
//        calendarDayList.add(new CalendarDay(d7, false));


        calendarDayList.add(new CalendarDay(d1));
        calendarDayList.add(new CalendarDay(d2));
        calendarDayList.add(new CalendarDay(d3));
        calendarDayList.add(new CalendarDay(d4));
        calendarDayList.add(new CalendarDay(d5));
        calendarDayList.add(new CalendarDay(d6));
        calendarDayList.add(new CalendarDay(d7));
    }

    public CalendarWeek(
            CalendarDay d1,
            CalendarDay d2,
            CalendarDay d3,
            CalendarDay d4,
            CalendarDay d5,
            CalendarDay d6,
            CalendarDay d7
                        ){

        calendarDayList.clear();
        calendarDayList.add(d1);
        calendarDayList.add(d2);
        calendarDayList.add(d3);
        calendarDayList.add(d4);
        calendarDayList.add(d5);
        calendarDayList.add(d6);
        calendarDayList.add(d7);

    }
}
