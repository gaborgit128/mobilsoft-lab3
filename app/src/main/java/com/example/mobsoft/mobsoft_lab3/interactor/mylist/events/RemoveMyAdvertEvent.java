package com.example.mobsoft.mobsoft_lab3.interactor.mylist.events;

import com.example.mobsoft.mobsoft_lab3.interactor.base.BaseEvent;

/**
 * Created by Android on 2017. 04. 13..
 */

public class RemoveMyAdvertEvent extends BaseEvent {

    private boolean isDeletionSuccessfull;

    public boolean isDeletionSuccessfull() {
        return isDeletionSuccessfull;
    }

    public void setDeletionSuccessfull(boolean deletionSuccessfull) {
        isDeletionSuccessfull = deletionSuccessfull;
    }
}
