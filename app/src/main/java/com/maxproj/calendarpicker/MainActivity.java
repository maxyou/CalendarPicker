package com.maxproj.calendarpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maxproj.calendarpicker.Models.YearMonthDay;
import com.maxproj.calendarpicker.Utilities.MyConfig;

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
                MyConfig.openCalendarPicker(MainActivity.this, new YearMonthDay(2016,7,4), null);
            }
        });

    }
}
