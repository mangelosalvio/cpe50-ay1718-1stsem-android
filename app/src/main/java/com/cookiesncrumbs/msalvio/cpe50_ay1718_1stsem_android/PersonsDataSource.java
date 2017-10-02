package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by msalvio on 02/10/2017.
 */

public class PersonsDataSource {

    Context context;
    SimplePersonSqliteHelper simplePersonSqliteHelper;
    SQLiteDatabase db;

    public PersonsDataSource (Context context) {
        this.context = context;
        simplePersonSqliteHelper = new SimplePersonSqliteHelper(context);
        db = simplePersonSqliteHelper.getWritableDatabase();
    }

    public void addPerson(SimplePerson person){
        ContentValues values = new ContentValues();
        values.put("NAME", person.getName());
        db.insert("PERSONS", null, values);
    }

    public ArrayList<SimplePerson> getPersons(){
        ArrayList<SimplePerson> persons = new ArrayList<SimplePerson>();
        Cursor cursor = db.query("PERSONS",null,null,null,null,null,null,null);
        while ( cursor.moveToNext() ) {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            int id = cursor.getInt(cursor.getColumnIndex("_ID"));
            persons.add(new SimplePerson(id, name));
        }

        return persons;
    }


}
