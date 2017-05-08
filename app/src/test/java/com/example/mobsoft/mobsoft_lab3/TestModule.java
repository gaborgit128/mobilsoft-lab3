package com.example.mobsoft.mobsoft_lab3;

/**
 * Created by Android on 2017. 05. 03..
 */

import android.content.Context;

import com.example.mobsoft.mobsoft_lab3.ui.UIModule;
import com.example.mobsoft.mobsoft_lab3.ui.about.AboutPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListPresenter;
import com.example.mobsoft.mobsoft_lab3.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;


@Module
public class TestModule {

    private final com.example.mobsoft.mobsoft_lab3.ui.UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }


    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }


    @Provides
    public AddPresenter provideAddPresenter() {
        return UIModule.provideAddPresenter();
    }


    @Provides
    public MyListPresenter provideMyListPresenter() { return UIModule.provideMyListPresenter();
    }

    @Provides
    public AboutPresenter provideAboutPresenter() { return UIModule.provideAboutPresenter();
    }




    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
