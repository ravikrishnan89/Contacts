package com.flipkart.contacts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 08/03/17.
 */

@Module
public class MainModule {
    @Singleton
    @Provides
    public Interactor providesInteractor(){
        return new MainInteractor();
    }
}
