package com.maxproj.calendarpicker.Utilities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.maxproj.calendarpicker.Fragments.FragmentCalendarChooserDialog;
import com.maxproj.calendarpicker.Models.CalendarMonth;
import com.maxproj.calendarpicker.Models.CalendarTimeChooser;
import com.maxproj.calendarpicker.Models.CalendarWeek;
import com.maxproj.calendarpicker.R;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by youhy on 17/12/4.
 */

public class MyConfig {

    public static Context app;

    public static WindowManager wm;
    public static float scale;
    public static int screenWidth;
    public static int screenHeight;

    public static Date string_yyyy_MM_dd_HH_mm2Date(String time) {
        Date date;

        SimpleDateFormat df = new SimpleDateFormat(MyConfig.app.getString(R.string.time_yyyy_MM_dd_HH_mm));
        //df.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        try {
            date = df.parse(time);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

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


    public static boolean isSoftKeyboardShow(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            /**
             * 注意这里要使用getHeight()
             */

//            MyLog.d("ActivityBase","onGlobalLayout = landscape:"+activity.getWindow().getDecorView().findViewById(android.R.id.content).getHeight()+" "+MyConfig.screenWidth);
            return activity.getWindow().getDecorView().findViewById(android.R.id.content).getHeight() < ((MyConfig.screenWidth * 3) / 4);
        } else {
//            MyLog.d("ActivityBase","onGlobalLayout = partrit:"+activity.getWindow().getDecorView().findViewById(android.R.id.content).getHeight()+" "+MyConfig.screenHeight);
            return activity.getWindow().getDecorView().findViewById(android.R.id.content).getHeight() < ((MyConfig.screenHeight * 3) / 4);
        }
        //show返回true
    }

    public static void hide_keyboard_must_call_from_activity(Activity activity) {

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }

        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

//    public static void hide_keyboard_must_call_from_activity_callback(Activity activity, final CallBack_IfSuccess callBack_ifSuccess) {
//
//        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = activity.getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(activity);
//        }
//
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0, new ResultReceiver(null) {
//            @Override
//            protected void onReceiveResult(int resultCode, Bundle resultData) {
//
//                if (callBack_ifSuccess != null) {
//                    if (resultCode == InputMethodManager.RESULT_HIDDEN) {
//                        callBack_ifSuccess.ifSuccess();
//                    }
//                }
//            }
//        });
//    }

    /**
     * 弹出软键盘
     * 注意：1，showSoftInput方法中参数是一个View对象，但这个View对象必须获取焦点才能有效，所以必须获取带焦点的View对象。直接传递EditText也是可以的，其他的没有测试过。
     * 2，如果是页面刚刚加载可能存在控件还没有获取焦点的情况，所以sleep100ms；
     *
     * @param activity
     */
    public static void show_keyboard_must_call_from_activity(final Activity activity) {
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                View view = activity.getCurrentFocus();
                //If no view currently has focus, create a new one, just so we can grab a window token from it
                if (view == null) {
                    view = new View(activity);
                }
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                inputMethodManager.showSoftInput(view, 0);
            }
        }.start();

    }
    public static void openCalendarTimeChooser(final Activity activity,
                                               final CalendarTimeChooser.Month month,
                                               final CalendarTimeChooser.Time time,
                                               final FragmentCalendarChooserDialog.CalendarTimeChooseComplete calendarTimeChooseComplete
    ) {
        if (MyConfig.isSoftKeyboardShow(activity)) {
            MyConfig.hide_keyboard_must_call_from_activity(activity);

            /**
             * 以后有空改成软键盘收回的回调
             */
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    popCalendarChooserAfterCloseSoftKeyboard(month, time, calendarTimeChooseComplete, activity);
                }
            }, 300);//估计键盘收回时间是300毫秒
        } else {
            popCalendarChooserAfterCloseSoftKeyboard(month, time, calendarTimeChooseComplete, activity);
        }
    }

    private static void popCalendarChooserAfterCloseSoftKeyboard(CalendarTimeChooser.Month month, CalendarTimeChooser.Time time, FragmentCalendarChooserDialog.CalendarTimeChooseComplete calendarTimeChooseComplete, Activity activity) {
        CalendarTimeChooser calendarTimeChooser = new CalendarTimeChooser(month, time);

        FragmentCalendarChooserDialog fragmentCalendarChooserDialog = FragmentCalendarChooserDialog.newInstance(
                calendarTimeChooser,
                calendarTimeChooseComplete);
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, fragmentCalendarChooserDialog);
        ft.addToBackStack("activity_advance_setting");
        ft.commit();
    }
}
