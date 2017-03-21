package com.flipkart.contacts;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 08/03/17.
 */
@Module
public class ContactListModule {
    ContactListView contactListView;
    public ContactListModule(ContactListView contactListView) {
        this.contactListView = contactListView;
    }


    @Provides
    public ContactListPresenter providesContactListPresenter(){
        return new ContactListPresenterImpl(contactListView);
    }

}

