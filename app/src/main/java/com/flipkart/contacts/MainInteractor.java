package com.flipkart.contacts;

import com.flipkart.contacts.db.Contact;
import com.flipkart.contacts.db.DBUpdateService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ravi.krishnan on 08/03/17.
 */

public class MainInteractor implements Interactor{
    @Inject
    RepoListService repoListService;
    @Inject
    DBUpdateService dbUpdateService;
    public void fetchContactList(final ContactListUpdateListener contactListUpdateListener){
        repoListService.listContacts().
                flatMap(new Func1<List<Contact>, Observable<?>>() {
                    @Override
                    public Observable<?> call(List<Contact> contactList) {
                        return dbUpdateService.persistContactList(contactList);
                    }
                }).flatMap(new Func1<Object, Observable<List<Contact>>>() {
                    @Override
                    public Observable<List<Contact>> call(Object o) {
                        return dbUpdateService.getContactList();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Contact>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        contactListUpdateListener.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Contact> contactList) {
                        contactListUpdateListener.onListUpdated(contactList);
                    }
                });
    }
}
