package com.example.mobsoft.mobsoft_lab3.test;

/**
 * Created by Android on 2017. 05. 03..
 */

import com.example.mobsoft.mobsoft_lab3.BuildConfig;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddPresenter;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddScreen;
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
public class AddAdvertTest {

    private AddPresenter addPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        addPresenter = new AddPresenter();
    }

    @Test
    public void testAddAdvert() {
        AddScreen mainScreen = mock(AddScreen.class);
        addPresenter.attachScreen(mainScreen);
        addPresenter.addAdvert("Autó", "Jó állapotú", 10000);

        verify(mainScreen, times(1)).advertAdded();
    }

    @After
    public void tearDown() {
        addPresenter.detachScreen();
    }
}
