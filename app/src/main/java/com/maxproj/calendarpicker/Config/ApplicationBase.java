package com.maxproj.calendarpicker.Config;

import android.app.Application;
import android.content.Context;

import com.maxproj.calendarpicker.Models.Custom;

public class ApplicationBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        //===== init app data ======

        MyConfig.app = getApplicationContext();

        MyConfig.custom = new Custom();

    }

}
