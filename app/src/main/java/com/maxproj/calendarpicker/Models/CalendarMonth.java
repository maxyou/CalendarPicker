package com.maxproj.calendarpicker.Models;

import org.joda.time.LocalDate;

import java.util.LinkedList;

/**
 * Created by youhy on 5/13/15.
 */
public class CalendarMonth {

    public LocalDate firstDayOfCurrentMonth;
    public LocalDate originDate;

//    public LinkedList<CalendarDay> calendarDays = new LinkedList<>();

    public LinkedList<CalendarWeek> calendarWeeks = new LinkedList<>();


}
