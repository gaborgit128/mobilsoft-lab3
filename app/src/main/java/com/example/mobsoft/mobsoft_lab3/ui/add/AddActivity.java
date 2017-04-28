package com.example.mobsoft.mobsoft_lab3.ui.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017. 03. 24..
 */

public class AddActivity extends AppCompatActivity implements AddScreen {

    @Inject
    AddPresenter loginPresenter;

    @BindView(R.id.add_advert_add_button)
    Button addAdvert;

    @BindView(R.id.add_advert_description)
    TextView desription;

    @BindView(R.id.add_advert_cost)
    TextView cost;

    @BindView(R.id.add_advert_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);


        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

