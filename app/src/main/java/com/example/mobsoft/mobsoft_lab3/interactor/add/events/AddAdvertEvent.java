package com.example.mobsoft.mobsoft_lab3.interactor.add.events;

import com.example.mobsoft.mobsoft_lab3.interactor.base.BaseEvent;

/**
 * Created by Android on 2017. 04. 13..
 */

public class AddAdvertEvent extends BaseEvent {

    private boolean isAdvertAddedSuccessfully;

    public boolean isAdvertAddedSuccessfully() {
        return isAdvertAddedSuccessfully;
    }

    public void setAdvertAddedSuccessfully(boolean advertAddedSuccessfully) {
        isAdvertAddedSuccessfully = advertAddedSuccessfully;
    }
}
