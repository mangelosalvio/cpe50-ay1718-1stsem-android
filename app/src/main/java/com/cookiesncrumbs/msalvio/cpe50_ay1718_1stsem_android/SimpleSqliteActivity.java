package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SimpleSqliteActivity extends AppCompatActivity {

    ListView listView;
    EditText nameEditText;
    ArrayAdapter<SimplePerson> adapter;
    ArrayList<SimplePerson> persons;
    PersonsDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_sqlite);

        listView = (ListView) findViewById(R.id.person_list_view);
        nameEditText = (EditText) findViewById(R.id.name_et);

        dataSource = new PersonsDataSource(this);

        persons = new ArrayList<SimplePerson>();
        persons.addAll(dataSource.getPersons());

        adapter = new ArrayAdapter<SimplePerson>(this,android.R.layout.simple_list_item_1, persons);
        listView.setAdapter(adapter);

    }

    public void add(View v){
        String name = nameEditText.getText().toString();
        dataSource.addPerson(new SimplePerson(name));
        persons.clear();
        persons.addAll(dataSource.getPersons());
        adapter.notifyDataSetChanged();
        nameEditText.setText("");
    }
}
