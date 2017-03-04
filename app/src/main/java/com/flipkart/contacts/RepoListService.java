package com.flipkart.contacts;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by ravi.krishnan on 23/01/17.
 */

public interface RepoListService {
    public static final String BASE_URL = "http://gojek-contacts-app.herokuapp.com/contacts/";
    @GET("contacts.json")
    Observable<List<Contact>> listContacts();
    @GET("contacts/{id}.json")
    Observable<Contact> getContact(@Path("id") Integer id);
}
