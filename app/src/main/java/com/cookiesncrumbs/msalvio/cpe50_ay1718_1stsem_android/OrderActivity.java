package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ListView menuListView;
    MenuArrayAdapter menuArrayAdapter;
    ArrayList<MenuItem> menuItems;
    MenuDataSource menuDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        menuItems = new ArrayList<MenuItem>();
        menuDataSource = new MenuDataSource(this);
        menuItems.addAll(menuDataSource.getMenuItems());
        menuListView = (ListView) findViewById(R.id.menu_list_view);
        menuArrayAdapter = new MenuArrayAdapter(this, menuItems);
        menuListView.setAdapter(menuArrayAdapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final MenuItem menuItem = menuItems.get(position);

                new AlertDialog.Builder(OrderActivity.this)
                        .setTitle("Add")
                        .setMessage("Add " + menuItem.getName() + " ? ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                menuDataSource.addOrder(menuItem);
                                new AlertDialog.Builder(OrderActivity.this)
                                        .setTitle("Item Added")
                                        .setMessage(menuItem.getName() + " added with 1 quantity")
                                        .setPositiveButton("Done",null)
                                        .create().show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create().show();
            }
        });
    }

    public void displayOrders(View v){
        Intent intent = new Intent(this,CustomerOrderActivity.class);
        startActivity(intent);
    }
}
