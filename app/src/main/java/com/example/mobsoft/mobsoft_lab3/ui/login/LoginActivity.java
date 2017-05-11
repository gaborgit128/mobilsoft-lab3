package com.example.mobsoft.mobsoft_lab3.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 2017. 03. 24..
 */

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.login_username)
    TextView userName;

    @BindView(R.id.login_password)
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    @OnClick(R.id.login_login)
    public void onLoginButtonClicked() {
        if (TextUtils.isEmpty(userName.getText())) {
            showMessage("Empty username!");

            return;
        }

        if (TextUtils.isEmpty(password.getText())) {
            showMessage("Empty password!");

            return;
        }

        loginPresenter.login(userName.getText().toString(), password.getText().toString());
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
