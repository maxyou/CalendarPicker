package com.maxproj.calendarpicker.Fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joda.time.LocalDate;

import android.support.v13.app.FragmentStatePagerAdapter;


import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.Models.EventCalendarSelectDay;
import com.maxproj.calendarpicker.R;
import com.maxproj.calendarpicker.Config.MyLog;


public class FragmentCalendarViewpager extends FragmentBase {

    ViewPager viewPager;
    MonthPagerAdapter monthPagerAdapter;
    CalendarDay daySelected = new CalendarDay(null);

    public void onEventMainThread(EventCalendarSelectDay eventCalendarSelectDay) {

        if(eventCalendarSelectDay != null && eventCalendarSelectDay.calendarDay != null){
            daySelected.copy(eventCalendarSelectDay.calendarDay);
        }else {
            daySelected.copy(null);
        }

    }

    public interface DayInViewPagerOnClickListener{
        void dayOnClicked(CalendarDay calendarDay);
    }
    public DayInViewPagerOnClickListener dayInViewPagerOnClickListener;

    public void setDayClickListener(DayInViewPagerOnClickListener dayInViewPagerOnClickListener){
        this.dayInViewPagerOnClickListener = dayInViewPagerOnClickListener;
    }

    public void setSelectedDay(CalendarDay day){

        daySelected.copy(day);
    }
    public void gotoTodayMonth(){

        viewPager.setCurrentItem(MonthPagerAdapter.CURRENT_MONTH_IN_SCROLL);
    }

    public void gotoDay(CalendarDay calendarDay){
        if(calendarDay == null || calendarDay.day == null){
            return;
        }

        LocalDate today = new LocalDate();

        viewPager.setCurrentItem((calendarDay.day.getYear() * 12 + calendarDay.day.getMonthOfYear())
                - (today.getYear() * 12 + today.getMonthOfYear())
                + MonthPagerAdapter.CURRENT_MONTH_IN_SCROLL);

    }

    public void gotoSelectedDay(){
        if(daySelected == null || daySelected.day == null){
            return;
        }

        LocalDate today = new LocalDate();
        viewPager.setCurrentItem((daySelected.day.getYear() * 12 + daySelected.day.getMonthOfYear())
                - (today.getYear() * 12 + today.getMonthOfYear())
                + MonthPagerAdapter.CURRENT_MONTH_IN_SCROLL);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyLog.d("","FragmentCalendarChooserDialog: FragmentCalendarViewpager.onCreateView");
        View v = inflater.inflate(R.layout.fragment_calendar_viewpager, null);

        viewPager = (ViewPager)v.findViewById(R.id.calendar_viewpager);
        monthPagerAdapter = new MonthPagerAdapter(getFragmentManager());
        viewPager.setAdapter(monthPagerAdapter);
        viewPager.setCurrentItem(MonthPagerAdapter.CURRENT_MONTH_IN_SCROLL);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    public static FragmentCalendarViewpager newInstance() {
        FragmentCalendarViewpager f = new FragmentCalendarViewpager();

        return f;
    }

    public class MonthPagerAdapter extends FragmentStatePagerAdapter {

        /**
         * 从当前月开始，往前可以抹动1000个月，往后可以抹动1000个月
         */
        public final static int PREVIOUS_MONTH_CAN_SCROLL = 1000;
        public final static int CURRENT_MONTH_IN_SCROLL = PREVIOUS_MONTH_CAN_SCROLL + 1;
        public final static int AFTER_MONTH_CAN_SCROLL = 1000;

        public MonthPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public FragmentCalendarMonthBase getItem(int position) {

            FragmentCalendarMonthBase fragmentCalendarMonthBase = FragmentCalendarMonthBase.newInstance(new LocalDate().plusMonths(position - CURRENT_MONTH_IN_SCROLL),
                    daySelected,
                    new FragmentCalendarMonthBase.DayInMonthOnClickListener() {//尽量不用监听器，麻烦且容易遗漏
                        @Override
                        public void dayOnClicked(CalendarDay calendarDay) {
                            if(dayInViewPagerOnClickListener != null){
                                dayInViewPagerOnClickListener.dayOnClicked(calendarDay);
                            }
                        }
                    }
                    );
            return fragmentCalendarMonthBase;
        }

        @Override
        public int getCount() {
            return PREVIOUS_MONTH_CAN_SCROLL + 1 + AFTER_MONTH_CAN_SCROLL;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ""+position;
        }
    }

    public void closeFragment(){
        getActivity().getFragmentManager().beginTransaction().remove(FragmentCalendarViewpager.this).commit();
    }
}
