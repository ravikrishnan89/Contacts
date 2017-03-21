package com.flipkart.contacts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ravi.krishnan on 06/03/17.
 */

public class DBHelper extends DaoMaster.OpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }
}
