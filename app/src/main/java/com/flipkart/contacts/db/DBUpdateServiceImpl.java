package com.flipkart.contacts.db;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by ravi.krishnan on 06/03/17.
 */

public class DBUpdateServiceImpl implements DBUpdateService{
    @Inject
    DaoSession daoSession;

    @Override
    public Observable<Void> persistContactList(final List<Contact> contactList) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                daoSession.getContactDao().insertInTx(contactList);
            }
        });
    }


    public Observable<List<Contact>> getContactList(){
        return Observable.fromCallable(new Callable<List<Contact>>() {
            @Override
            public List<Contact> call() throws Exception {
                return daoSession.getContactDao().queryBuilder().
                        list();
            }
        });
    }
}
