package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BarcodeActivity extends AppCompatActivity {

    ArrayList<Product> products_list;
    ArrayList<Product> products;
    ProductAdapter adapter;
    ListView products_lv;

    EditText barcode_et;

    public static final int CHANGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        products = new ArrayList<Product>();
        products.add(new Product("Product#1","12345",2));
        products.add(new Product("Product#2","12346",3));
        products.add(new Product("Product#3","12347",4));
        products.add(new Product("Product#4","12348",5));
        products.add(new Product("Product#5","12349",6));


        products_list = new ArrayList<Product>();
        products_lv  = (ListView) findViewById(R.id.list_view);
        adapter = new ProductAdapter(this, products_list);
        products_lv.setAdapter(adapter);
        barcode_et = (EditText) findViewById(R.id.barcode_et);

    }

    public void add(View v){
        String barcode = barcode_et.getText().toString();
        Product p = this.searchProduct(barcode);
        if ( p != null ) {
            products_list.add(p);
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Barcode not found", Toast.LENGTH_SHORT).show();
        }

        barcode_et.setText("");

    }

    public void finalize(View v){

        double totalAns = 0;

        for ( Product p : this.products_list ) {
            totalAns += p.getPrice();
        }

        Intent intent = new Intent(this, ProductFinalActivity.class);
        intent.putExtra("ans", totalAns);

        startActivityForResult(intent,BarcodeActivity.CHANGE_REQUEST);


    }

    public Product searchProduct(String barcode){
        for ( Product p : this.products ) {
            if ( p.getBarcode().equals(barcode) ) {
                return p;
            }
        }

        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ( resultCode == Activity.RESULT_OK) {
            if ( requestCode == BarcodeActivity.CHANGE_REQUEST ) {

                String change = String.valueOf(data.getExtras().getDouble("change"));

                new AlertDialog.Builder(this)
                        .setTitle("Change")
                        .setMessage(change)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                products_list.clear();
                                adapter.notifyDataSetChanged();
                            }
                        }).create().show();

            }
        }

    }
}
