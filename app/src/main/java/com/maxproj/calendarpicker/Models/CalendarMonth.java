package com.maxproj.calendarpicker.Models;

import org.joda.time.LocalDate;

import java.util.LinkedList;


public class CalendarMonth {

    public LocalDate firstDayOfCurrentMonth;
    public LocalDate originDate;
    public LinkedList<CalendarWeek> calendarWeeks = new LinkedList<>();

}
