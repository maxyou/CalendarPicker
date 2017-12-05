package com.maxproj.calendarpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.maxproj.calendarpicker.Models.CalendarTimeChooser;
import com.maxproj.calendarpicker.Utilities.MyConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyConfig.openCalendarTimeChooser(MainActivity.this, new CalendarTimeChooser.Month(2017,12,4), null,null);
            }
        });

    }
}
