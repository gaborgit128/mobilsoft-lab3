package com.example.mobsoft.mobsoft_lab3.test;

/**
 * Created by Android on 2017. 05. 03..
 */

import com.example.mobsoft.mobsoft_lab3.BuildConfig;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainScreen;
import com.example.mobsoft.mobsoft_lab3.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import static com.example.mobsoft.mobsoft_lab3.TestHelper.setTestInjector;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AdvertTest {

    private MainPresenter mianPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mianPresenter = new MainPresenter();
    }

    @Test
    public void testTodo() {
        MainScreen mainScreen = mock(MainScreen.class);
        mianPresenter.attachScreen(mainScreen);
        //mianPresenter.getFavourites();

        ArgumentCaptor<String> todosCaptor = ArgumentCaptor.forClass(String.class);
        verify(mainScreen, times(2)).showMessage(todosCaptor.capture());

        List<String> capturedTodos = todosCaptor.getAllValues();
        assertEquals("todo one", capturedTodos.get(0));
        assertEquals("todo two", capturedTodos.get(1));
    }

    @After
    public void tearDown() {
        mianPresenter.detachScreen();
    }
}
