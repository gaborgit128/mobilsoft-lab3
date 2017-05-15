package com.example.mobsoft.mobsoft_lab3.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.ui.main.adapter.MainMenuAdapter;
import com.example.mobsoft.mobsoft_lab3.ui.main.adapter.SpaceItemDecorator;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.main_menus_list)
    RecyclerView mainMenus;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        mainMenus.setLayoutManager(new LinearLayoutManager(this));
        mainMenus.setAdapter(new MainMenuAdapter(this));
        mainMenus.addItemDecoration(new SpaceItemDecorator(this));

        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}