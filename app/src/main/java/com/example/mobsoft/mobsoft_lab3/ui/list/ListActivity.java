package com.example.mobsoft.mobsoft_lab3.ui.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainScreen;

import javax.inject.Inject;

/**
 * Created by Android on 2017. 03. 24..
 */

public class ListActivity extends AppCompatActivity implements ListScreen {

    @Inject
    ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
