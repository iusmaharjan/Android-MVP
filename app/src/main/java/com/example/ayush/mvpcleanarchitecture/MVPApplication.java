package com.example.ayush.mvpcleanarchitecture;

import android.app.Application;

import timber.log.Timber;

public class MVPApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
