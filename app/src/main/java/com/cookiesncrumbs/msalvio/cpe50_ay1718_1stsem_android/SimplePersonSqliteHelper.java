package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by msalvio on 02/10/2017.
 */

public class SimplePersonSqliteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "cpe50.db";
    public static final int DB_VERSION = 2;

    public SimplePersonSqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PERSONS (" +
                "_ID INTEGER PRIMARY KEY," +
                "NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE PERSONS");
        onCreate(db);
    }
}
