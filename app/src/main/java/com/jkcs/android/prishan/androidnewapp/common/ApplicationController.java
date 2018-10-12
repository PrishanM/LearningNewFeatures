package com.jkcs.android.prishan.androidnewapp.common;

import android.app.Application;

public class ApplicationController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //AndroidNetworking.initialize(getApplicationContext());
    }
}
