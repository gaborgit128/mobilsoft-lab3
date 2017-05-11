package com.example.mobsoft.mobsoft_lab3.interactor.login;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.login.events.LoginEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.login.model.LoginResult;
import com.example.mobsoft.mobsoft_lab3.model.Credential;
import com.example.mobsoft.mobsoft_lab3.network.advert.UserApi;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Android on 2017. 04. 13..
 */

public class LoginInteractor {

    @Inject
    protected UserApi userApi;

    public LoginInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String userName, String password) {
        Credential credential = new Credential(userName, password);

        Call<LoginResult> artistsQueryCall = userApi.userLogin(credential);
        LoginEvent event = new LoginEvent();
        try {
            Response<LoginResult> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setLoginSuccessfull(response.body().isLoginSuccessfull());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
