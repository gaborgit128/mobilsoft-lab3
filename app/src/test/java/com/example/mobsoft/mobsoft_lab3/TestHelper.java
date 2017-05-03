package com.example.mobsoft.mobsoft_lab3;

/**
 * Created by Android on 2017. 05. 03..
 */


import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
      //  MobSoftApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        //application.setInjector(injector);
    }
}
