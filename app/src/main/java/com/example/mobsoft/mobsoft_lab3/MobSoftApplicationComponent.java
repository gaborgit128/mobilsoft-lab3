package com.example.mobsoft.mobsoft_lab3;

import com.example.mobsoft.mobsoft_lab3.interactor.InteractorModule;
import com.example.mobsoft.mobsoft_lab3.interactor.add.AddAvertInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.list.GetAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.GetMyAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.repository.RepositoryModule;
import com.example.mobsoft.mobsoft_lab3.ui.UIModule;
import com.example.mobsoft.mobsoft_lab3.ui.about.AboutActivity;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddActivity;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainActivity;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListActivity;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(AddActivity addActivity);

    void inject(MyListActivity myListActivity);

    void inject(AboutActivity aboutActivity);

    void inject(AddAvertInteractor addAvertInteractor);

    void inject(GetAdvertsInteractor getAdvertsInteractor);

    void inject(GetMyAdvertsInteractor getMyAdvertsInteractor);

    void inject(MainPresenter mainPresenter);

    void inject(MyListPresenter myListPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(AddPresenter addPresenter);
}
