package com.example.mobsoft.mobsoft_lab3.repository;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
/**
 * Created by mobsoft on 2017. 04. 03..
 */


@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}
