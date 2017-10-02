package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SqliteActivity extends AppCompatActivity {

    ProductsDataSource productsDataSource;

    EditText nameEditText, priceEditText, barcodeEditText;
    ListView listView;
    ProductAdapter adapter;

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        productsDataSource = new ProductsDataSource(this);

        nameEditText = (EditText) findViewById(R.id.name_et);
        barcodeEditText = (EditText) findViewById(R.id.barcode_et);
        priceEditText = (EditText) findViewById(R.id.price_et);
        listView = (ListView) findViewById(R.id.product_lv);

        products = new ArrayList<Product>();
        products.addAll(productsDataSource.getProducts());
        adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(SqliteActivity.this)
                        .setTitle("Remove")
                        .setMessage("Would you like to delete?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Product p = products.get(position);
                                productsDataSource.deleteProduct(p);
                                refreshUI();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create()
                        .show();



                return false;
            }
        });


    }

    public void add(View v) {
        String name = nameEditText.getText().toString();
        String barcode = barcodeEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());

        Product product = new Product(name, barcode, price);

        productsDataSource.addProduct(product);
        refreshUI();

        nameEditText.setText("");
        priceEditText.setText("");
        barcodeEditText.setText("");
    }

    public void refreshUI(){
        products.clear();
        products.addAll(productsDataSource.getProducts());
        adapter.notifyDataSetChanged();
    }
}
