package com.example.mobsoft.mobsoft_lab3.interactor.add;

/**
 * Created by Android on 2017. 04. 13..
 */
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.add.events.AddAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.repository.Repository;


public class AddAvertInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public AddAvertInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void addAdverts(Advert advert) {

        AddAdvertEvent event = new AddAdvertEvent();
        event.setAdvert(advert);
        try {
            repository.saveAdvert(advert);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    }
