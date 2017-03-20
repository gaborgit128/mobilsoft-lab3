package com.example.mobsoft.mobsoft_lab3;

import android.app.Application;

import com.example.mobsoft.mobsoft_lab3.ui.UIModule;


public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
