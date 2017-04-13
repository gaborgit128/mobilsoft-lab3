package com.example.mobsoft.mobsoft_lab3.interactor.mylist;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.list.events.GetAdvertsEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.RemoveMyAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Android on 2017. 04. 13..
 */

public class GetMyAdvertsInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public GetMyAdvertsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getMyAdverts() {
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

    public void updateMyAdvert(List<Advert> adverts) {
        try {
            repository.updateAdverts(adverts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeMyAdvert(Advert advert) {
        RemoveMyAdvertEvent event = new RemoveMyAdvertEvent();
        event.setAdvert(advert);
        try {
            repository.removeAdvert(advert);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
