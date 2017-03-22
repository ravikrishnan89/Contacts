package com.flipkart.contacts;

import dagger.Subcomponent;

/**
 * Created by ravi.krishnan on 09/03/17.
 */
@Subcomponent(modules = {ContactListModule.class})
public interface ContactListComponent {

    void inject(ContactListActivity contactListActivity);
}
