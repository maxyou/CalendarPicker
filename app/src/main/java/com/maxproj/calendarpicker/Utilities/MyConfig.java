package com.maxproj.calendarpicker.Utilities;

import com.maxproj.calendarpicker.Models.CalendarMonth;
import com.maxproj.calendarpicker.Models.CalendarWeek;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

/**
 * Created by youhy on 17/12/4.
 */

public class MyConfig {



    public static CalendarWeek getWeekIncludeThisDay(LocalDate localDate) {

        LocalDate monday = localDate.withDayOfWeek(DateTimeConstants.MONDAY);
        LocalDate tuesday = localDate.withDayOfWeek(DateTimeConstants.TUESDAY);
        LocalDate wednesday = localDate.withDayOfWeek(DateTimeConstants.WEDNESDAY);
        LocalDate thursday = localDate.withDayOfWeek(DateTimeConstants.THURSDAY);
        LocalDate friday = localDate.withDayOfWeek(DateTimeConstants.FRIDAY);
        LocalDate saturday = localDate.withDayOfWeek(DateTimeConstants.SATURDAY);
        LocalDate sunday = localDate.withDayOfWeek(DateTimeConstants.SUNDAY);

        CalendarWeek calendarWeek = new CalendarWeek(
                monday,
                tuesday,
                wednesday,
                thursday,
                friday,
                saturday,
                sunday
        );
        calendarWeek.firstDayOfCurrentMonth = localDate.withDayOfMonth(1);
        calendarWeek.originDate = localDate;

        return calendarWeek;
    }


    public static CalendarMonth getMonthIncludeThisDay(LocalDate localDate) {


        CalendarMonth calendarMonth = new CalendarMonth();

        calendarMonth.firstDayOfCurrentMonth = localDate.withDayOfMonth(1);

        for (int i = 0; i < 6; i++) {//每个月最多6周，最少4周
            CalendarWeek w = getWeekIncludeThisDay(calendarMonth.firstDayOfCurrentMonth.plusDays(7 * i));

            if (i < 4) {
                calendarMonth.calendarWeeks.addLast(w);
            } else if (w.calendarDayList.getFirst().day.getMonthOfYear() == calendarMonth.firstDayOfCurrentMonth.getMonthOfYear()) {
                /**
                 * 从第5周开始检
                 * 如果w的第一天的月份等于本月第一天的月份，那么这一周也算本月的周
                 */
                calendarMonth.calendarWeeks.addLast(w);
            } else {
                break;
            }

        }
        calendarMonth.originDate = localDate;

        return calendarMonth;
    }
}
