package com.example.mobsoft.mobsoft_lab3;

/**
 * Created by Android on 2017. 05. 03..
 */


import com.example.mobsoft.mobsoft_lab3.interactor.InteractorModule;
import com.example.mobsoft.mobsoft_lab3.mock.MockNetworkModule;
import com.example.mobsoft.mobsoft_lab3.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
