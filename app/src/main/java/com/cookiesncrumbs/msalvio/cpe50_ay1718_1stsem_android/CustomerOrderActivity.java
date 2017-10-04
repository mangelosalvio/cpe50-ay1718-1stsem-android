package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CustomerOrderActivity extends AppCompatActivity {

    ListView ordersListView;
    MenuArrayAdapter menuArrayAdapter;
    ArrayList<MenuItem> orders;
    MenuDataSource menuDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);

        menuDataSource = new MenuDataSource(this);
        orders = new ArrayList<MenuItem>();
        orders.addAll(menuDataSource.getOrders());


        menuArrayAdapter = new MenuArrayAdapter(this,orders);
        ordersListView = (ListView) findViewById(R.id.orders_list_view);
        ordersListView.setAdapter(menuArrayAdapter);

    }

    public void displayTotal(View v) {

        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");

        new AlertDialog.Builder(this)
                .setTitle("Total Amount")
                .setMessage(decimalFormat.format(getTotal()))
                .setPositiveButton("OK",null)
                .setNegativeButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        menuDataSource.deleteOrders();
                        orders.clear();
                        orders.addAll(menuDataSource.getOrders());
                        menuArrayAdapter.notifyDataSetChanged();
                    }
                }).create().show();


    }

    public double getTotal(){
        double total = 0;
        for ( MenuItem menuItem : orders ) {
            total += menuItem.getPrice();
        }

        return total;
    }
}
