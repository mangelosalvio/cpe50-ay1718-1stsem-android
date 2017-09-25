package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Intent;
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
        startActivity(intent);


    }

    public Product searchProduct(String barcode){
        for ( Product p : this.products ) {
            if ( p.getBarcode().equals(barcode) ) {
                return p;
            }
        }

        return null;
    }
}
