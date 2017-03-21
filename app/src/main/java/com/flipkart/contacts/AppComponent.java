package com.flipkart.contacts;

import dagger.Component;

/**
 * Created by ravi.krishnan on 02/02/17.
 */
@Component(modules = {NetworkModule.class,MainModule.class,DBModule.class})
public interface AppComponent {
}
