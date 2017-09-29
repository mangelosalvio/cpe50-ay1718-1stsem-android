package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BarcodeActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    ArrayList<Product> products_list;
    ArrayList<Product> products;
    ProductAdapter adapter;
    ListView products_lv;

    EditText barcode_et;

    AlertDialog eDialog;
    double totalAns;
    public static final int CHANGE_REQUEST = 1;
    double final_total_ans;

    View dialog_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        products = new ArrayList<Product>();
        products.add(new Product("Product#1","12345",400));
        products.add(new Product("Product#2","12346",344));
        products.add(new Product("Product#3","12347",900));
        products.add(new Product("Product#4","12348",1023));
        products.add(new Product("Product#5","12349",50250));


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

        totalAns = 0;

        for ( Product p : this.products_list ) {
            totalAns += p.getPrice();
        }

        final_total_ans = totalAns;


        /*Intent intent = new Intent(this, ProductFinalActivity.class);
        intent.putExtra("ans", totalAns);
        startActivityForResult(intent,BarcodeActivity.CHANGE_REQUEST);*/

        //LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = this.getLayoutInflater();
        dialog_view = inflater.inflate(R.layout.change_layout, null, false);

        final DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        TextView total_paymet_amount_tv = (TextView) dialog_view.findViewById(R.id.total_amount_tv);
        total_paymet_amount_tv.setText(decimalFormat.format(totalAns));

        eDialog = new AlertDialog.Builder(this)
                .setView(dialog_view)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText payment_amount_et = (EditText) dialog_view.findViewById(R.id.payment_amount_et);
                        double payment_amount;
                        try {
                            payment_amount = Double.parseDouble(payment_amount_et.getText().toString());
                        } catch (Exception e) {
                            payment_amount = 0;
                        }

                        final AlertDialog changeDialog = new AlertDialog.Builder(BarcodeActivity.this)
                                .setMessage(decimalFormat.format(payment_amount - final_total_ans))
                                .setTitle("Change")
                                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        products_list.clear();
                                        adapter.notifyDataSetChanged();
                                    }
                                }).create();

                        if ( final_total_ans <= payment_amount ) {

                            changeDialog.show();

                        } else {
                            new AlertDialog.Builder(BarcodeActivity.this)
                                    .setMessage("Invalid Payment")
                                    .setTitle("Error")
                                    .setPositiveButton("Done", BarcodeActivity.this).create().show();
                        }

                    }
                }).create();

        eDialog.show();


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

    @Override
    public void onClick(DialogInterface dialog, int which) {
        EditText payment_amount = (EditText) dialog_view.findViewById(R.id.payment_amount_et);
        payment_amount.setText("");
        eDialog.show();
    }
}
