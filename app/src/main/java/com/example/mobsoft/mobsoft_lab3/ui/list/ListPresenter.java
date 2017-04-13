package com.example.mobsoft.mobsoft_lab3.ui.list;

import com.example.mobsoft.mobsoft_lab3.interactor.list.GetAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;

/**
 * Created by Android on 2017. 03. 24..
 */

public class ListPresenter extends Presenter<ListScreen> {

    @Inject
    GetAdvertsInteractor getAdvertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public ListPresenter() {
    }

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }
}
