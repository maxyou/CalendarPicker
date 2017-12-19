package com.maxproj.calendarpicker.Views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxproj.calendarpicker.Config.MyConfig;
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
//            Log.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay == null");
//        }else if(calendarDay.day == null){
//            Log.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay.day == null");
//        }else{
//            Log.d("","EventCalendarSelectDay: ViewCalendarDayWithActivity calendarDay.day " + calendarDay.day.toString());
//        }
        calendar_day_in_month.setText(""+calendarDay.day.getDayOfMonth());

        if(calendarDay.have_activity){
            calendar_day_have_activity.setVisibility(VISIBLE);
        }else{
            calendar_day_have_activity.setVisibility(GONE);
        }



        if(highLightDay != null && calendarDay.day.equals(highLightDay.day)){

            /**
             * 被选择
             */

            MyConfig.setTextViewSize(calendar_day_in_month, MyConfig.custom.daySelectedSize);

            MyConfig.setTextViewColor(calendar_day_in_month, MyConfig.custom.selectedColor);

            calendar_day_layout.setBackground(getResources().getDrawable(R.drawable.calendar_selected_circle));
            MyConfig.setDrawableColor(calendar_day_layout.getBackground(), MyConfig.custom.selectedBgColor);

        }else if(calendarDay.day.equals(new LocalDate())){

            /**
             * 今天
             */

            MyConfig.setTextViewSize(calendar_day_in_month, MyConfig.custom.dayTodaySize);

            MyConfig.setTextViewColor(calendar_day_in_month, MyConfig.custom.todayColor);

            calendar_day_layout.setBackground(getResources().getDrawable(R.drawable.calendar_today_circle));
            MyConfig.setDrawableColor(calendar_day_layout.getBackground(), MyConfig.custom.todayBgColor);

        }else{

            /**
             * 普通日
             */

            MyConfig.setTextViewSize(calendar_day_in_month, MyConfig.custom.daySize);

            calendar_day_layout.setBackgroundColor(Color.TRANSPARENT);

            MyConfig.setTextViewSize(calendar_day_in_month, MyConfig.custom.daySize);

            if(calendarDay.day.getMonthOfYear() == highLightMonth){//当月
                MyConfig.setTextViewColor(calendar_day_in_month, MyConfig.custom.dayColor);
            }else{//前后月
                MyConfig.setTextViewColor(calendar_day_in_month, MyConfig.custom.dayOtherMonthColor);
            }
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
