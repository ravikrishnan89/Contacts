package com.flipkart.contacts;

import com.flipkart.contacts.db.Contact;

import java.util.List;

/**
 * Created by ravi.krishnan on 07/03/17.
 */

public interface ContactListUpdateListener {
    public void onListUpdated(List<Contact> contactList);
    public void onError(String error);
}
