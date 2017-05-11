package com.example.mobsoft.mobsoft_lab3.test;

import com.example.mobsoft.mobsoft_lab3.BuildConfig;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.login.LoginScreen;
import com.example.mobsoft.mobsoft_lab3.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import static com.example.mobsoft.mobsoft_lab3.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Android on 2017. 05. 08..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginTest {
    private LoginPresenter loginPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        loginPresenter = new LoginPresenter();
    }

    @Test
    public void testTodo() {
        LoginScreen loginScreen = mock(LoginScreen.class);
        loginPresenter.attachScreen(loginScreen);
        loginPresenter.login("Gabor", "12345");

        verify(loginScreen, times(1)).login();
    }

    @After
    public void tearDown() {
        loginPresenter.detachScreen();
    }
}
