package com.example.mobsoft.mobsoft_lab3.test;

/**
 * Created by Android on 2017. 05. 14..
 */

import com.example.mobsoft.mobsoft_lab3.BuildConfig;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddScreen;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListScreen;
import com.example.mobsoft.mobsoft_lab3.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static com.example.mobsoft.mobsoft_lab3.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DeleteAdvertTest {

    private MyListPresenter myListPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        myListPresenter = new MyListPresenter();
    }

    @Test
    public void testDeleteAdvert() {
        MyListScreen myScreen = mock(MyListScreen.class);
        myListPresenter.attachScreen(myScreen);
        myListPresenter.deleteAdvert(-1);

        verify(myScreen, times(1)).advertDeleted();
    }

    @After
    public void tearDown() {
        myListPresenter.detachScreen();
    }
}
