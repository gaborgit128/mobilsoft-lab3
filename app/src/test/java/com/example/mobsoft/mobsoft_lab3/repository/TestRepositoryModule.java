package com.example.mobsoft.mobsoft_lab3.repository;

/**
 * Created by Android on 2017. 05. 03..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
