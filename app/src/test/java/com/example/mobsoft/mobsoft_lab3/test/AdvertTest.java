package com.example.mobsoft.mobsoft_lab3.test;

/**
 * Created by Android on 2017. 05. 03..
 */

import com.example.mobsoft.mobsoft_lab3.BuildConfig;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddScreen;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListScreen;
import com.example.mobsoft.mobsoft_lab3.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.mobsoft.mobsoft_lab3.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AdvertTest {

    private MyListPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MyListPresenter();
    }

    @Test
    public void testShowAllAdverts() {
        MyListScreen mainScreen = mock(MyListScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.showAllAdverts();

        ArgumentCaptor<List> todosCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen, times(1)).displayAdverts(todosCaptor.capture());

        List<List> capturedTodos = todosCaptor.getAllValues();

        assertEquals(2, capturedTodos.get(0).size());
    }

    @Test
    public void testShowMyAdverts() {
        MyListScreen mainScreen = mock(MyListScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getMyAdverts();

        ArgumentCaptor<List> todosCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen, times(1)).displayAdverts(todosCaptor.capture());

        List<List> capturedTodos = todosCaptor.getAllValues();

        assertEquals(0, capturedTodos.get(0).size());
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
