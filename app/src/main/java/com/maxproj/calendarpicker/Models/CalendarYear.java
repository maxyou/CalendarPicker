package com.maxproj.calendarpicker.Models;

import org.joda.time.LocalDate;

import java.util.LinkedList;

/**
 * Created by youhy on 5/13/15.
 */
public class CalendarYear {

    LocalDate firstDay;

    public LinkedList<CalendarMonth> calendarMonths = new LinkedList<>();

    public LinkedList<CalendarWeek> calendarWeeks = new LinkedList<>();

}
