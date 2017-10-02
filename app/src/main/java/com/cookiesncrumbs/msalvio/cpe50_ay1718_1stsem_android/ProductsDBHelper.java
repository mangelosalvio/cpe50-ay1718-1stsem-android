package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by msalvio on 02/10/2017.
 */

public class ProductsDBHelper extends SQLiteOpenHelper {

    public static final String DB = "cpe50sy1718.db";
    private static final int DB_VERSION = 1;

    public ProductsDBHelper(Context context){
        super(context, DB, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTS (" +
                "_ID INTEGER PRIMARY KEY," +
                "NAME TEXT," +
                "PRICE REAL," +
                "BARCODE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");
        onCreate(db);
    }
}
