package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by msalvio on 04/10/2017.
 */

public class MenuItemSqliteOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "restu.db";
    public static final int DB_VERSION = 1;

    public MenuItemSqliteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MENU_ITEMS (" +
                "_ID INTEGER PRIMARY KEY," +
                "NAME TEXT," +
                "PRICE REAL)");

        db.execSQL("CREATE TABLE ORDERS (" +
                "_ID INTEGER PRIMARY KEY," +
                "NAME TEXT," +
                "PRICE REAL)");

        ContentValues values = new ContentValues();
        values.put("NAME","ITEM 1");
        values.put("PRICE",24);
        db.insert("MENU_ITEMS",null, values);

        values.put("NAME","ITEM 2");
        values.put("PRICE",35);
        db.insert("MENU_ITEMS",null, values);

        values.put("NAME","ITEM 3");
        values.put("PRICE",51);
        db.insert("MENU_ITEMS",null, values);

        values.put("NAME","ITEM 4");
        values.put("PRICE", 6);
        db.insert("MENU_ITEMS",null, values);

        values.put("NAME","ITEM 5");
        values.put("PRICE", 72);
        db.insert("MENU_ITEMS",null, values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MENU_ITEMS");
        db.execSQL("DROP TABLE IF EXISTS ORDERS");
    }
}
