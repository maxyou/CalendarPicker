package com.maxproj.calendarpicker.Views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxproj.calendarpicker.Models.CalendarDay;
import com.maxproj.calendarpicker.R;

import org.joda.time.LocalDate;




public class ViewCalendarDayWithActivity extends LinearLayout {

    CalendarDay mCalendarDay;

    public LinearLayout calendar_day_layout;
    public ImageView calendar_day_have_activity;
    public TextView calendar_day_in_month;


    public ViewCalendarDayWithActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public ViewCalendarDayWithActivity(Context context) {
        super(context);
        inflate(context);
    }

    private void inflate(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.calendar_day_with_activity, this, true);

        calendar_day_layout = (LinearLayout)v.findViewById(R.id.calendar_day_layout);
        calendar_day_have_activity = (ImageView) v.findViewById(R.id.calendar_day_have_activity);
        calendar_day_in_month = (TextView) v.findViewById(R.id.calendar_day_in_month);
    }

    public interface DayOnClickListener {
        void dayOnClicked(CalendarDay day);
    }
    public DayOnClickListener mDayOnClickListener;


    public void setViewCalendarDay(CalendarDay calendarDay, int highLightMonth, CalendarDay highLightDay, DayOnClickListener dayOnClickListener){
        this.mCalendarDay = calendarDay;
        this.mDayOnClickListener = dayOnClickListener;

//        if(calendarDay == null){
//            MyLog.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay == null");
//        }else if(calendarDay.day == null){
//            MyLog.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay.day == null");
//        }else{
//            MyLog.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay.day " + calendarDay.day.toString());
//        }
        calendar_day_in_month.setText(""+calendarDay.day.getDayOfMonth());

        if(calendarDay.have_activity){
            calendar_day_have_activity.setVisibility(VISIBLE);
        }else{
            calendar_day_have_activity.setVisibility(GONE);
        }

        if(calendarDay.day.getMonthOfYear() == highLightMonth){
//            calendar_day_layout.setBackgroundColor(getResources().getColor(R.color.LightGrey));
            calendar_day_in_month.setTextColor(getResources().getColor(R.color.month_day_current));
        }else{
//            calendar_day_layout.setBackgroundColor(Color.TRANSPARENT);
            calendar_day_in_month.setTextColor(getResources().getColor(R.color.month_day_other));
        }

        if(highLightDay != null && calendarDay.day.equals(highLightDay.day)){

            /**
             * 被选择
             */

            calendar_day_layout.setBackground(getResources().getDrawable(R.drawable.calendar_selected_circle));
            calendar_day_in_month.setTextColor(getResources().getColor(R.color.month_day_selected));
            calendar_day_in_month.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.month_day_selected));

        }else if(calendarDay.day.equals(new LocalDate())){

            /**
             * 今天
             */

            calendar_day_layout.setBackground(getResources().getDrawable(R.drawable.calendar_today_circle));
            calendar_day_in_month.setTextColor(getResources().getColor(R.color.month_day_selected));
            calendar_day_in_month.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.month_day_today));

        }else{

            /**
             * 普通日
             */

            calendar_day_layout.setBackgroundColor(Color.TRANSPARENT);
            calendar_day_in_month.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.month_day));

        }

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDayOnClickListener != null){
                    mDayOnClickListener.dayOnClicked(CalendarDay.clone(mCalendarDay));
                }
            }
        });

    }


}
