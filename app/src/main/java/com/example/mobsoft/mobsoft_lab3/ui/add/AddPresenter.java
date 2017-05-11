package com.example.mobsoft.mobsoft_lab3.ui.add;

import com.example.mobsoft.mobsoft_lab3.interactor.add.AddAvertInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.add.events.AddAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
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

    public void onEventMainThread(AddAdvertEvent addAdvertEvent) {
        if (addAdvertEvent.isAdvertAddedSuccessfully()) {
            screen.advertAdded();
        } else {
            screen.showMessage("Advert adding failed");
        }
    }

    public void addAdvert(final String title, final String description, final int cost) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Advert advert = new Advert(title, cost, description);
                addAvertInteractor.addAdverts(advert);
            }
        });
    }
}
