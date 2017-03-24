package com.example.mobsoft.mobsoft_lab3;

import com.example.mobsoft.mobsoft_lab3.ui.UIModule;
import com.example.mobsoft.mobsoft_lab3.ui.about.AboutActivity;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddActivity;
import com.example.mobsoft.mobsoft_lab3.ui.list.ListActivity;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainActivity;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(AddActivity addActivity);

    void inject(MyListActivity myListActivity);

    void inject(ListActivity listActivity);

    void inject(AboutActivity aboutActivity);
}
