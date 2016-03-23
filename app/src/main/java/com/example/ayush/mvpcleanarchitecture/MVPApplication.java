package com.example.ayush.mvpcleanarchitecture;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class MVPApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("mvp_db.realm")
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
