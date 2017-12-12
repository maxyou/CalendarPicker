package com.maxproj.calendarpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.YearMonthDay;
import com.maxproj.calendarpicker.Config.MyConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button_open = (Button) findViewById(R.id.button_open);
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyConfig.openCalendarPicker(MainActivity.this, null, null);
            }
        });

        Button button_preset = (Button) findViewById(R.id.button_preset);
        button_preset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyConfig.openCalendarPicker(MainActivity.this, new YearMonthDay(2016,7,4), null);
                Builder builder = new Builder(MainActivity.this, new FragmentCalendarPicker.CalendarPickerOnConfirm() {
                    @Override
                    public void onComplete(YearMonthDay yearMonthDay) {
                        MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                    }
                })
                        .setPreset(new YearMonthDay(2016, 7, 4))
                        .setMonthTitle(new Builder.FormatMonthTitle() {
                            @Override
                            public String setMonthTitle(int year, int month) {
                                return ""+year+"年"+month+"月";
                            }
                        })
                        .setSelectedText("已选")
                        .setTodayText("今天");

                builder.show();

            }
        });

    }
}
