package com.example.mobsoft.mobsoft_lab3.ui.add;

import com.example.mobsoft.mobsoft_lab3.interactor.add.AddAvertInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.list.GetAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;

/**
 * Created by Android on 2017. 03. 24..
 */

public class AddPresenter extends Presenter<AddScreen> {

    @Inject
    AddAvertInteractor addAvertInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public AddPresenter() {
    }

    @Override
    public void attachScreen(AddScreen screen) {
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
