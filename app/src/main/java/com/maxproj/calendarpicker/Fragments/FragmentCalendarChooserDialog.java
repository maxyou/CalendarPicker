package com.maxproj.calendarpicker.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.Models.CalendarTimeChooser;
import com.maxproj.calendarpicker.Models.EventCalendarSelectDay;
import com.maxproj.calendarpicker.R;
import com.maxproj.calendarpicker.Utilities.MyConfig;
import com.maxproj.calendarpicker.Utilities.MyLog;

import de.greenrobot.event.EventBus;


public class FragmentCalendarChooserDialog extends FragmentBase {

    View calendar_time_chooser_mask;
    LinearLayout calendar_time_chooser_layout;
    LinearLayout calendar_time_chooser_title_layout;
    TextView calendar_time_chooser_title;
    TextView calendar_time_chooser_selected;
    TextView calendar_time_chooser_today;
    FrameLayout calendar_time_chooser_viewpager_container;
    LinearLayout calendar_time_chooser_panel_layout;
    TextView calendar_time_chooser_panel_cancel;
    TextView calendar_time_chooser_panel_confirm;

    final String FRAGMENT_VIEWPAGER_TAG = "fragment_calendar_time_chooser";

    FragmentCalendarViewpager calendar_time_chooser_viewpager;

    CalendarTimeChooser calendarTimeChooser;
    CalendarDay daySelected;
    CalendarTimeChooser calendarTimeChooserOnComplete = new CalendarTimeChooser(null, null);

    public interface CalendarTimeChooseComplete{
            void onComplete(CalendarTimeChooser calendarTimeChooser);
    }
    public CalendarTimeChooseComplete calendarTimeChooseComplete;


    public static FragmentCalendarChooserDialog newInstance(CalendarTimeChooser calendarTimeChooser, CalendarTimeChooseComplete calendarTimeChooseComplete) {

        FragmentCalendarChooserDialog f = new FragmentCalendarChooserDialog();
        f.calendarTimeChooser = calendarTimeChooser;
        f.calendarTimeChooseComplete = calendarTimeChooseComplete;
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        MyLog.d("","FragmentCalendarChooserDialog: FragmentCalendarChooserDialog.onCreateView");
        View v = inflater.inflate(R.layout.fragment_calendar_time_chooser, null);

        findViews(v);

        initClickListener();

        return v;
    }

    private void initMonth(){

        if(calendarTimeChooser.month == null){
            return;
        }

        if(calendarTimeChooser.month.year != -1) {
            daySelected = new CalendarDay(calendarTimeChooser.month.year, calendarTimeChooser.month.month, calendarTimeChooser.month.day);
        }

        if(daySelected != null) {

            calendar_time_chooser_viewpager.gotoDay(CalendarDay.clone(daySelected));
//            calendar_time_chooser_blocks_calendar_viewpager.setSelectedDay(CalendarDay.clone(daySelected));

            new Handler().postDelayed(new Runnable() {
                /**
                 * 由于viewpager的当前item未必已经构建，所以这里需要延迟发送
                 */
                @Override
                public void run() {
                    EventBus.getDefault().post(new EventCalendarSelectDay(CalendarDay.clone(daySelected)));
                }
            }, 100);
        }else{
            calendar_time_chooser_viewpager.gotoTodayMonth();
        }

        calendar_time_chooser_layout.setVisibility(View.VISIBLE);
//        calendar_time_chooser_layout.setY(getActivity().findViewById(android.R.id.content).getY());
        calendar_time_chooser_layout.setY(getActivity().findViewById(android.R.id.content).getHeight());
//        calendar_time_chooser_layout.setTranslationY(MyConfig.dp2Px(getActivity(), 50));

        calendar_time_chooser_layout.animate().y(getActivity().findViewById(android.R.id.content).getHeight()
                - calendar_time_chooser_layout.getHeight()).setDuration(300);
//        calendar_time_chooser_layout.animate().y(MyConfig.screenHeight - MyConfig.dp2Px(getActivity(), 100)).setDuration(300);
    }



    private void closeFragment(){

        calendar_time_chooser_layout.animate().y(MyConfig.screenHeight).setDuration(300).withEndAction(new Runnable() {
            @Override
            public void run() {

                calendar_time_chooser_viewpager.closeFragment();
                getActivity().getFragmentManager().beginTransaction().remove(FragmentCalendarChooserDialog.this).commit();
            }
        });
    }

    private void initClickListener(){

        calendar_time_chooser_mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeFragment();
            }
        });

        calendar_time_chooser_panel_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    closeFragment();
            }
        });

        calendar_time_chooser_panel_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    calendar_time_chooser_layout.animate().x(-MyConfig.screenWidth).setDuration(500);

                    if (daySelected == null) {
//                        MyConfig.MyToast(0, getActivity(), getActivity().getResources().getString(R.string.calendar_chooser_date_prompt));
                        return;
                    }
                calendarTimeChooserOnComplete.month = new CalendarTimeChooser.Month(
                        daySelected.day.getYearOfEra(),
                        daySelected.day.getMonthOfYear(),
                        daySelected.day.getDayOfMonth()
                );

                if(calendarTimeChooseComplete != null){
                    calendarTimeChooseComplete.onComplete(calendarTimeChooserOnComplete);
                }

                closeFragment();

            }
        });

        calendar_time_chooser_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar_time_chooser_viewpager.gotoDay(CalendarDay.clone(daySelected));
            }
        });

        calendar_time_chooser_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar_time_chooser_viewpager.gotoTodayMonth();
            }
        });
    }


    private void findViews(View v) {


        calendar_time_chooser_mask = (View) v.findViewById(R.id.calendar_time_chooser_mask);
        calendar_time_chooser_layout = (LinearLayout) v.findViewById(R.id.calendar_time_chooser_layout);
        calendar_time_chooser_title_layout = (LinearLayout) v.findViewById(R.id.calendar_time_chooser_title_layout);
        calendar_time_chooser_title = (TextView) v.findViewById(R.id.calendar_time_chooser_title);
        calendar_time_chooser_selected = (TextView) v.findViewById(R.id.calendar_time_chooser_selected);
        calendar_time_chooser_today = (TextView) v.findViewById(R.id.calendar_time_chooser_today);
        calendar_time_chooser_panel_layout = (LinearLayout) v.findViewById(R.id.calendar_time_chooser_panel_layout);
        calendar_time_chooser_panel_cancel = (TextView) v.findViewById(R.id.calendar_time_chooser_panel_cancel);
        calendar_time_chooser_panel_confirm = (TextView) v.findViewById(R.id.calendar_time_chooser_panel_confirm);
        calendar_time_chooser_viewpager_container = (FrameLayout) v.findViewById(R.id.calendar_time_chooser_viewpager_container);

        calendar_time_chooser_viewpager = new FragmentCalendarViewpager();
//        calendar_time_chooser_blocks_calendar_viewpager.dayInViewPagerOnClickListener = new FragmentCalendarViewpager.DayInViewPagerOnClickListener() {
//            @Override
//            public void dayOnClicked(CalendarDay calendarDay) {
//                daySelected.copy(calendarDay);
//            }
//        };
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.calendar_time_chooser_viewpager_container, calendar_time_chooser_viewpager, FRAGMENT_VIEWPAGER_TAG);
//        ft.addToBackStack(FRAGMENT_VIEWPAGER_TAG);
        ft.commit();
    }


    @Override
    public void onResume() {
        super.onResume();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initMonth();
            }
        }, 100);

    }


//    public void onEventMainThread(EventHeartOneSecond eventHeartOneSecond) {
//
//    }
//
//    public void onEventMainThread(EventCalendarSelectDay eventCalendarSelectDay) {
//
//        if(eventCalendarSelectDay != null && eventCalendarSelectDay.calendarDay != null){
//
//            daySelected = CalendarDay.clone(eventCalendarSelectDay.calendarDay);
//        }else {
//
//        }
//    }

}
