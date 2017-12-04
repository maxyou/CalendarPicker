package com.maxproj.calendarpicker.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;



public class FragmentBase extends Fragment {

    boolean eventbut_registed = false;

    String title;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    public void onResume() {
        super.onResume();
    }
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 被activity中的onKeyDown方法调用，返回false交由Activity处理，返回true表示自己处理。
     * 默认情况下是返回false，如果要自己处理则在FragmentBase子类中重写这个方法。
     */
    public boolean onKeyDownFromActivity(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * 被activity中的onOptionsItemSelected方法调用，返回false交由Activity处理，返回true表示自己处理。
     * 默认情况下是返回false，如果要自己处理则在FragmentBase子类中重写这个方法。
     */
    public boolean onOptionsItemSelectedFromActivity(MenuItem item) {
       return false;
    }


}
