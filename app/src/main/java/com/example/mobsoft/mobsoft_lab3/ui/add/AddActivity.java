package com.example.mobsoft.mobsoft_lab3.ui.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 2017. 03. 24..
 */

public class AddActivity extends AppCompatActivity implements AddScreen {

    @Inject
    AddPresenter addPresenter;

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
        addPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        addPresenter.detachScreen();
    }

    @OnClick(R.id.add_advert_add_button)
    public void onAddAdvertClicked() {
        if (TextUtils.isEmpty(title.getText().toString()) || TextUtils.isEmpty(desription.getText().toString())) {

            return;
        }
        if (TextUtils.isEmpty(cost.getText().toString())) {

            return;
        } else {
            int costOfAdd = Integer.parseInt(cost.getText().toString());

            if (costOfAdd == 0) {
                return;
            }
        }

        addPresenter.addAdvert(title.getText().toString(), desription.getText().toString(), Integer.parseInt(cost.getText().toString()));
    }

    @Override
    public void advertAdded() {
        onBackPressed();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

