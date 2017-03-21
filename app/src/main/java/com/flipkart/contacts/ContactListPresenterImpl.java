package com.flipkart.contacts;

import com.flipkart.contacts.db.Contact;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ravi.krishnan on 07/03/17.
 */

public class ContactListPresenterImpl implements ContactListPresenter {

    ContactListView contactListView;
    @Inject
    Interactor interactor;


    ContactListPresenterImpl(ContactListView contactListView){
        this.contactListView = contactListView;
    }
    @Override
    public void fetchList() {
        interactor.fetchContactList(this);
    }

    @Override
    public void onListUpdated(List<Contact> contactList) {
        contactListView.onListFetched(contactList);
    }

    @Override
    public void onError(String error) {
        contactListView.onError(error);
    }
}
