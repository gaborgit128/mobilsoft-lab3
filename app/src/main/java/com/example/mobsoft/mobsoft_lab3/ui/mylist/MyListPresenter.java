package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import com.example.mobsoft.mobsoft_lab3.interactor.main.MainInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.GetMyAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;

/**
 * Created by Android on 2017. 03. 24..
 */

public class MyListPresenter extends Presenter<MyListScreen> {

    @Inject
    GetMyAdvertsInteractor getMyAdvertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MyListPresenter() {
    }

    @Override
    public void attachScreen(MyListScreen screen) {

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
