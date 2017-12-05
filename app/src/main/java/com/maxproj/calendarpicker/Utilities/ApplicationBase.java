package com.maxproj.calendarpicker.Utilities;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class ApplicationBase extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        //===== init app data ======

        MyConfig.app = getApplicationContext();


        MyConfig.wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = MyConfig.wm.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        MyConfig.screenWidth = size.x;
        MyConfig.screenHeight = size.y;
        MyLog.d("ApplicationBase", "screenWidth " + MyConfig.screenWidth + " screenHeight " + MyConfig.screenHeight);

        MyConfig.scale = getResources().getDisplayMetrics().density;


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

}
