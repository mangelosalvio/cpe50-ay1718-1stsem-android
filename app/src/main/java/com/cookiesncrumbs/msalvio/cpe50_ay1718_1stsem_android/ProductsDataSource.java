package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by msalvio on 02/10/2017.
 */

public class ProductsDataSource {

    SQLiteDatabase db;
    Context context;
    ProductsDBHelper productsDBHelper;

    public String[] columns = { "_ID", "NAME", "PRICE", "BARCODE" };

    public ProductsDataSource(Context context) {
        productsDBHelper = new ProductsDBHelper(context);
        db = productsDBHelper.getWritableDatabase();
    }

    public void addProduct(Product product) {

        ContentValues values = new ContentValues();
        values.put("NAME", product.getName());
        values.put("PRICE", product.getPrice());
        values.put("BARCODE", product.getBarcode());

        db.insert("PRODUCTS", null, values);
    }

    public void displayProducts () {
        Cursor cursor = db.query("PRODUCTS", columns, null, null, null, null, null);
        while ( cursor.moveToNext() ) {
            Product product = cursorToProduct(cursor);
            Log.d("product", product.toString());
        }
    }
    public ArrayList<Product> getProducts () {
        ArrayList<Product> products = new ArrayList<Product>();
        Cursor cursor = db.query("PRODUCTS", columns, null, null, null, null, null);
        while ( cursor.moveToNext() ) {
            Product product = cursorToProduct(cursor);
            products.add(product);
        }

        return products;
    }


    public Product cursorToProduct(Cursor cursor){

        int _id = cursor.getInt(cursor.getColumnIndex("_ID"));
        String name = cursor.getString(cursor.getColumnIndex("NAME"));
        String barcode = cursor.getString(cursor.getColumnIndex("BARCODE"));
        double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));

        return new Product(_id, name, barcode, price);
    }

    public void deleteProduct(Product product) {
        db.delete("PRODUCTS","_id = ?", new String[]{ String.valueOf(product.get_id()) });
    }

}
