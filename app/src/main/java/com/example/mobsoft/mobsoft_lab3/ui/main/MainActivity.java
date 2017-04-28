package com.example.mobsoft.mobsoft_lab3.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.ui.main.adapter.MainMenuAdapter;
import com.example.mobsoft.mobsoft_lab3.ui.main.adapter.SpaceItemDecorator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.main_menus_list)
    RecyclerView mainMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        mainMenus.setLayoutManager(new LinearLayoutManager(this));
        mainMenus.setAdapter(new MainMenuAdapter(this));
        mainMenus.addItemDecoration(new SpaceItemDecorator(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
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