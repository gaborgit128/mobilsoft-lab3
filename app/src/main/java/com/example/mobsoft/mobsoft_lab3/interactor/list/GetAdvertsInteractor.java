package com.example.mobsoft.mobsoft_lab3.interactor.list;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.add.events.AddAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.list.events.GetAdvertsEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Android on 2017. 04. 13..
 */

public class GetAdvertsInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public GetAdvertsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getAdverts() {
        GetAdvertsEvent event = new GetAdvertsEvent();
        try {
            List<Advert> adverts = repository.getAdverts();
            event.setAdverts(adverts);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
