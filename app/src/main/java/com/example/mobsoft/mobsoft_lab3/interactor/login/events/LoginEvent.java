package com.example.mobsoft.mobsoft_lab3.interactor.login.events;

import com.example.mobsoft.mobsoft_lab3.interactor.base.BaseEvent;

/**
 * Created by Android on 2017. 05. 11..
 */

public class LoginEvent extends BaseEvent {

    private boolean isLoginSuccessfull;

    public boolean isLoginSuccessfull() {
        return isLoginSuccessfull;
    }

    public void setLoginSuccessfull(boolean loginSuccessfull) {
        isLoginSuccessfull = loginSuccessfull;
    }
}
