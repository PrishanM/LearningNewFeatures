package com.jkcs.android.prishan.androidnewapp.common;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class ApplicationController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
