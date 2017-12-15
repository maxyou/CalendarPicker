package com.maxproj.calendarpicker.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.Models.CalendarMonth;
import com.maxproj.calendarpicker.Models.EventCalendarSelectDay;
import com.maxproj.calendarpicker.R;
import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Config.MyLog;
import com.maxproj.calendarpicker.Views.ViewCalendarDayWithActivity;
import com.maxproj.calendarpicker.Views.ViewCalendarWeekWithActivity;

import org.joda.time.LocalDate;

import de.greenrobot.event.EventBus;


public class FragmentCalendarMonthBase extends FragmentBase {

    TextView fragment_calendar_base_day_index_1;
    TextView fragment_calendar_base_day_index_2;
    TextView fragment_calendar_base_day_index_3;
    TextView fragment_calendar_base_day_index_4;
    TextView fragment_calendar_base_day_index_5;
    TextView fragment_calendar_base_day_index_6;
    TextView fragment_calendar_base_day_index_7;

    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_0;
    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_1;
    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_2;
    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_3;
    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_4;
    ViewCalendarWeekWithActivity viewCalendarWeekWithActivity_5;

    CalendarMonth calendarMonth;
    CalendarDay daySelected = new CalendarDay(null);

    TextView fragment_calendar_year_month;

    public interface DayInMonthOnClickListener{
        public void dayOnClicked(CalendarDay calendarDay);
    }
    public DayInMonthOnClickListener dayInMonthOnClickListener;

    ViewCalendarDayWithActivity.DayOnClickListener dayOnClickListener = new ViewCalendarDayWithActivity.DayOnClickListener() {
        @Override
        public void dayOnClicked(CalendarDay calendarDay) {

            EventBus.getDefault().post(new EventCalendarSelectDay(CalendarDay.clone(calendarDay)));
//            daySelected = calendarDay;
//            updateCalendarPage();

            if(dayInMonthOnClickListener != null){
                dayInMonthOnClickListener.dayOnClicked(CalendarDay.clone(calendarDay));
            }

        }
    };

    public void onEventMainThread(EventCalendarSelectDay eventCalendarSelectDay) {

        if(eventCalendarSelectDay != null) {
            daySelected.copy(eventCalendarSelectDay.calendarDay);

            MyLog.d("","EventCalendarSelectDay: monthbase ");

        }else{
            daySelected.copy(null);
        }
        updateCalendarPage();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyLog.d("","FragmentCalendarChooserDialog: FragmentCalendarMonthBase.onCreateView " + calendarMonth.firstDayOfCurrentMonth.getMonthOfYear()+"月");
        View v = inflater.inflate(R.layout.fragment_calendar_base, null);

        fragment_calendar_year_month = (TextView)v.findViewById(R.id.fragment_calendar_year_month);

        fragment_calendar_base_day_index_1 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_1);
        fragment_calendar_base_day_index_2 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_2);
        fragment_calendar_base_day_index_3 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_3);
        fragment_calendar_base_day_index_4 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_4);
        fragment_calendar_base_day_index_5 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_5);
        fragment_calendar_base_day_index_6 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_6);
        fragment_calendar_base_day_index_7 = (TextView) v.findViewById(R.id.fragment_calendar_base_day_index_7);

        viewCalendarWeekWithActivity_0 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_0);
        viewCalendarWeekWithActivity_1 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_1);
        viewCalendarWeekWithActivity_2 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_2);
        viewCalendarWeekWithActivity_3 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_3);
        viewCalendarWeekWithActivity_4 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_4);
        viewCalendarWeekWithActivity_5 = (ViewCalendarWeekWithActivity) v.findViewById(R.id.fragment_calendar_base_week_5);

        updateCalendarPage();

        return v;
    }

    public void updateCalendarPage() {

        if(MyConfig.customize.formatMonthTitle != null){
            fragment_calendar_year_month.setText(MyConfig.customize.formatMonthTitle.setMonthTitle(calendarMonth.firstDayOfCurrentMonth.getYear(), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear()));
        }else{
            fragment_calendar_year_month.setText(calendarMonth.firstDayOfCurrentMonth.getYear()+" - "+calendarMonth.firstDayOfCurrentMonth.getMonthOfYear());
        }

        if(MyConfig.customize.weekIndex != null && MyConfig.customize.weekIndex.length == 7) {
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_1, MyConfig.customize.weekIndex[0]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_2, MyConfig.customize.weekIndex[1]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_3, MyConfig.customize.weekIndex[2]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_4, MyConfig.customize.weekIndex[3]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_5, MyConfig.customize.weekIndex[4]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_6, MyConfig.customize.weekIndex[5]);
            MyConfig.setTextViewTxt(fragment_calendar_base_day_index_7, MyConfig.customize.weekIndex[6]);
        }


        viewCalendarWeekWithActivity_0.setViewCalendarWeek(calendarMonth.calendarWeeks.get(0), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        viewCalendarWeekWithActivity_1.setViewCalendarWeek(calendarMonth.calendarWeeks.get(1), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        viewCalendarWeekWithActivity_2.setViewCalendarWeek(calendarMonth.calendarWeeks.get(2), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        viewCalendarWeekWithActivity_3.setViewCalendarWeek(calendarMonth.calendarWeeks.get(3), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);

        if (calendarMonth.calendarWeeks.size() > 4) {
            viewCalendarWeekWithActivity_4.setViewCalendarWeek(calendarMonth.calendarWeeks.get(4), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        } else {
            viewCalendarWeekWithActivity_4.setViewCalendarWeek(null, calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
            viewCalendarWeekWithActivity_5.setViewCalendarWeek(null, calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        }
        if (calendarMonth.calendarWeeks.size() > 5) {
            viewCalendarWeekWithActivity_5.setViewCalendarWeek(calendarMonth.calendarWeeks.get(5), calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        } else {
            viewCalendarWeekWithActivity_5.setViewCalendarWeek(null, calendarMonth.firstDayOfCurrentMonth.getMonthOfYear(), daySelected, dayOnClickListener);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    public static FragmentCalendarMonthBase newInstance(LocalDate localDate, CalendarDay daySelected, FragmentCalendarMonthBase.DayInMonthOnClickListener dayInMonthOnClickListener) {

        FragmentCalendarMonthBase f = new FragmentCalendarMonthBase();
        f.calendarMonth = MyConfig.getMonthIncludeThisDay(localDate);
        f.daySelected.copy(daySelected);
        f.dayInMonthOnClickListener = dayInMonthOnClickListener;

        return f;
    }





}
