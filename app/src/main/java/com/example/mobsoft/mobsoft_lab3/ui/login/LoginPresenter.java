package com.example.mobsoft.mobsoft_lab3.ui.login;

import com.example.mobsoft.mobsoft_lab3.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.login.events.LoginEvent;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;


/**
 * Created by Patrik on 2017. 03. 19..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    LoginInteractor loginInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    public void login(final String userName, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(userName, password);
            }
        });
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void onEventMainThread(LoginEvent loginEvent) {
        if (loginEvent.isLoginSuccessfull()) {
            screen.login();
        } else {
            screen.showMessage("Login failed");
        }
    }
}