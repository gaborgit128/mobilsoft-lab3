package com.example.mobsoft.mobsoft_lab3;

import android.app.Application;

import javax.inject.Inject;
import com.example.mobsoft.mobsoft_lab3.repository.Repository;
import com.example.mobsoft.mobsoft_lab3.ui.UIModule;


public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
