package com.example.mobsoft.mobsoft_lab3.interactor;

/**
 * Created by Android on 2017. 04. 13..
 */

import com.example.mobsoft.mobsoft_lab3.interactor.add.AddAvertInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.main.MainInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.GetMyAdvertsInteractor;

import dagger.Module;
import dagger.Provides;


@Module
public class InteractorModule {

    @Provides
    public AddAvertInteractor provideAddAdvert() {
        return new AddAvertInteractor();
    }

    @Provides
    public GetMyAdvertsInteractor provideMyAdverts() {
        return new GetMyAdvertsInteractor();
    }

    @Provides
    public MainInteractor provideMain() {
        return new MainInteractor();
    }

    @Provides
    public LoginInteractor provideLogin() {
        return new LoginInteractor();
    }

}



