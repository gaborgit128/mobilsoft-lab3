package com.example.mobsoft.mobsoft_lab3.interactor.mylist.events;

/**
 * Created by Android on 2017. 05. 11..
 */

import com.example.mobsoft.mobsoft_lab3.interactor.base.BaseEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;

import java.util.List;

public class GetAdvertsEvent extends BaseEvent {

    private List<Advert> adverts;

    public GetAdvertsEvent() {
    }


    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }
}
