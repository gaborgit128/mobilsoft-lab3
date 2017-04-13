package com.example.mobsoft.mobsoft_lab3.interactor.mylist.events;

import com.example.mobsoft.mobsoft_lab3.model.Advert;

import java.util.List;

/**
 * Created by Android on 2017. 04. 13..
 */

public class GetMyAdvertsEvent {

    private int id;

    private List<Advert> adverts;

    private Throwable throwable;

    public GetMyAdvertsEvent(){}


    public GetMyAdvertsEvent(int id, List<Advert> adverts, Throwable throwable){
        this.id = id;
        this.adverts = adverts;
        this.throwable = throwable;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
