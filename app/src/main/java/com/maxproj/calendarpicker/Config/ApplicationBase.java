package com.maxproj.calendarpicker.Config;

import android.app.Application;
import android.content.Context;

import com.maxproj.calendarpicker.Models.Customize;

public class ApplicationBase extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        //===== init app data ======

        MyConfig.app = getApplicationContext();

        MyConfig.customize = new Customize();

//        MyConfig.wm = (WindowManager) getSystemService(WINDOW_SERVICE);
//        Display display = MyConfig.wm.getDefaultDisplay();
//
//        Point size = new Point();
//        display.getSize(size);
//        MyConfig.screenWidth = size.x;
//        MyConfig.screenHeight = size.y;
//        Log.d("ApplicationBase", "screenWidth " + MyConfig.screenWidth + " screenHeight " + MyConfig.screenHeight);
//
//        MyConfig.scale = getResources().getDisplayMetrics().density;


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

}
