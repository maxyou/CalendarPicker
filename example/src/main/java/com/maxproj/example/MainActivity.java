package com.maxproj.example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maxproj.calendarpicker.Builder;
import com.maxproj.calendarpicker.Config.MyConfig;
import com.maxproj.calendarpicker.Models.YearMonthDay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_open = (Button) findViewById(R.id.button_open);
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
                    @Override
                    public void onComplete(YearMonthDay yearMonthDay) {
                        MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                    }
                })
                        .restoreDefault();
                builder.show();
            }
        });

        Button button_preset = (Button) findViewById(R.id.button_preset);
        button_preset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
                    @Override
                    public void onComplete(YearMonthDay yearMonthDay) {
                        MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                    }
                })
                        .setPromptText("请选择日期")
                        .setPromptSize(18)
                        .setPromptColor(Color.RED)
                        .setPromptBgColor(Color.YELLOW)

                        .setSelectedText("已选")
                        .setSelectedSize(16)
                        .setSelectedColor(0xFF330DCE)
                        .setSelectedBgColor(0xFF1E90FF)

                        .setTodayText("今天")
                        .setTodaySize(12)
                        .setTodayColor(Color.RED)
                        .setTodayBgColor(Color.GREEN)

                        .setMonthTitle(new Builder.FormatMonthTitle() {
                            @Override
                            public String setMonthTitle(int year, int month) {
                                return ""+year+"年"+month+"月";
                            }
                        })
                        .setMonthTitleSize(16)
                        .setMonthTitleColor(0xFFB22222)
                        .setMonthTitleBgColor(0xFF93D353)

                        .setWeekIndex(new String[]{"一", "二", "三", "四", "五", "六", "日"})
                        .setWeekIndexSize(16)
                        .setWeekIndexColor(0xFFFF00FF)
                        .setWeekIndexBgColor(0xFFADD8E6)

                        .setCancelText("取消")
                        .setCancelSize(12)
                        .setCancelColor(Color.LTGRAY)
                        .setCancelBgColor(0xFFA079BE)

                        .setConfirmText("确定")
                        .setConfirmSize(16)
                        .setConfirmColor(Color.RED)
                        .setConfirmBgColor(Color.GREEN)

                        .setPreset(new YearMonthDay(2017, 11, 4))
                        .setDaySize(16)
                        .setDayColor(Color.BLUE)
                        .setDayOtherMonthColor(0xFF87CEFA)
                        .setMonthBaseBgColor(0xFFE0FFFF)

                        .setJump2Preset(true)
//                        .restoreDefault()
                        ;

                builder.show();

            }
        });
    }
}
