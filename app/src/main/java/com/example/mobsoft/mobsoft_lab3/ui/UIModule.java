package com.example.mobsoft.mobsoft_lab3.ui;

import android.content.Context;


import com.example.mobsoft.mobsoft_lab3.ui.about.AboutPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.list.ListPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public AddPresenter provideAddPresenter() {
        return new AddPresenter();
    }

    @Provides
    @Singleton
    public MyListPresenter provideMyListPresenter() {
        return new MyListPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter() {
        return new AboutPresenter();
    }

}