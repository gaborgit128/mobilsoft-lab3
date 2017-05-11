package com.example.mobsoft.mobsoft_lab3.interactor.base;

/**
 * Created by Android on 2017. 05. 11..
 */

public class BaseEvent {

    protected int code;
    protected Throwable throwable;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

