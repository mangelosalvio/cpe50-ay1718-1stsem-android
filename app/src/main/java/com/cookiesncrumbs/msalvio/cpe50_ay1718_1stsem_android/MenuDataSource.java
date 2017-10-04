package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by msalvio on 04/10/2017.
 */

public class MenuDataSource  {
    Context context;
    MenuItemSqliteOpenHelper helper;
    SQLiteDatabase db;

    public MenuDataSource(Context context){
        this.context = context;
        helper = new MenuItemSqliteOpenHelper(context);
        db = helper.getWritableDatabase();

    }

    public void addOrder(MenuItem menuItem) {
        ContentValues values = new ContentValues();
        values.put("NAME", menuItem.getName());
        values.put("PRICE", menuItem.getPrice());

        db.insert("ORDERS", null, values);
    }

    public ArrayList<MenuItem> getMenuItems () {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        Cursor cursor = db.query("MENU_ITEMS",null,null,null,null,null,null);

        while ( cursor.moveToNext() ) {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            int _id = cursor.getInt(cursor.getColumnIndex("_ID"));
            double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));

            MenuItem menuItem = new MenuItem(_id, name, price);
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    public ArrayList<MenuItem> getOrders () {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        Cursor cursor = db.query("ORDERS",null,null,null,null,null,null);

        while ( cursor.moveToNext() ) {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            int _id = cursor.getInt(cursor.getColumnIndex("_ID"));
            double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));

            MenuItem menuItem = new MenuItem(_id, name, price);
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    public void deleteOrders(){
        db.delete("ORDERS",null,null);
    }
}
