package com.maxproj.calendarpicker.Fragments;

import android.app.Fragment;
import android.os.Bundle;


import de.greenrobot.event.EventBus;


public class FragmentBase extends Fragment {

    boolean eventbus_registed = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /**
         * eventbus消息的处理可能引用view控件，所以eventbus的注册要在view控件初始化之后，所以挪动到这里
         * view控件的初始化在onCreateView中
         */
        if(!eventbus_registed) {
            EventBus.getDefault().register(this);
            eventbus_registed = true;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        /**
         * 要在view控件被解构之前断开eventbus
         */
        if(eventbus_registed) {
            EventBus.getDefault().unregister(this);
            eventbus_registed = false;
        }

    }


}
