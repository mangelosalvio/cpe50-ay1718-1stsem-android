package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SampleListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter adapter;
    ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list);

        listView = (ListView) findViewById(R.id.list_view);

        list = new ArrayList<Person>();
        list.add(new Person("John Doe", "Bacolod City","444-44444"));
        list.add(new Person("Bill Rice", "Silay City","444-44445"));
        list.add(new Person("Johnny Roaster", "San Carlos City","444-44446"));
        list.add(new Person("Billy Joe", "La Carlota City","444-44447"));

        adapter = new PersonAdapter(this,list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*String name = list.get(position);
                Toast.makeText(SampleListActivity.this, name, Toast.LENGTH_SHORT).show();*/
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(SampleListActivity.this)
                        .setTitle("Delete?")
                        .setMessage("Would you like to Delete Selected?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("Cancel",null)
                        .create().show();
                return true;
            }
        });

    }

}














