package com.flipkart.contacts.db;

import java.util.List;

import rx.Observable;

/**
 * Created by ravi.krishnan on 06/03/17.
 */

public interface DBUpdateService {
    Observable<Void> persistContactList(List<Contact> contactList);
    public Observable<List<Contact>> getContactList();
}
