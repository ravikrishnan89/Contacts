package com.flipkart.contacts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by ravi.krishnan on 02/02/17.
 */
@Module
public class NetworkModule {
    @Singleton
    @Provides
    RepoListService provideRepoListService(){
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(RepoListService.BASE_URL)
                .build();
        return restAdapter.create(RepoListService.class);
    }
}
