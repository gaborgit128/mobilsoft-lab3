package com.example.mobsoft.mobsoft_lab3.ui.main;

import com.example.mobsoft.mobsoft_lab3.interactor.main.MainInteractor;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;


/**
 * Created by Patrik on 2017. 03. 19..
 */

public class MainPresenter extends Presenter<MainScreen> {


    @Inject
    MainInteractor mainInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void onEvent(String s) {
    }
}