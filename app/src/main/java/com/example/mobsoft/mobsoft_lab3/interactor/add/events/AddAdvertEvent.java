package com.example.mobsoft.mobsoft_lab3.interactor.add.events;

import com.example.mobsoft.mobsoft_lab3.model.Advert;

/**
 * Created by Android on 2017. 04. 13..
 */

public class AddAdvertEvent {

    private int id;

    private Advert advert;

    private Throwable throwable;

    public AddAdvertEvent(){}


    public AddAdvertEvent(int id, Advert advert, Throwable throwable){
        this.id = id;
        this.advert = advert;
        this.throwable = throwable;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
