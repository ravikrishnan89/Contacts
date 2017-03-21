package com.flipkart.contacts;

import android.content.Context;

import com.flipkart.contacts.db.DBHelper;
import com.flipkart.contacts.db.DBUpdateService;
import com.flipkart.contacts.db.DBUpdateServiceImpl;
import com.flipkart.contacts.db.DaoMaster;
import com.flipkart.contacts.db.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 06/03/17.
 */

@Module
public class DBModule {

    Context context;

    DBModule(Context context){
        this.context = context;
    }
    @Singleton
    @Provides
    DBUpdateService providesDBService(){
        return new DBUpdateServiceImpl();
    }

    @Singleton
    @Provides
    DaoSession providesDaoSession(){
        return new DaoMaster(new DBHelper(context,"contacts",null).
                getWritableDatabase()).newSession();
    }
}
