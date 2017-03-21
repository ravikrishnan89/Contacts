package com.flipkart.contacts;

/**
 * Created by ravi.krishnan on 08/03/17.
 */

public interface Interactor {
    public void fetchContactList(final ContactListUpdateListener contactListUpdateListener);
}
