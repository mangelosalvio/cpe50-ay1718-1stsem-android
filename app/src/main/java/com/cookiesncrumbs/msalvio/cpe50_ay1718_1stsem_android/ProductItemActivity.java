package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ProductItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
    }
    
    public void sendResult(View v){

        EditText product_et, barcode_et, price_et;

        product_et = (EditText) findViewById(R.id.product_et);
        barcode_et = (EditText) findViewById(R.id.barcode_et);
        price_et = (EditText) findViewById(R.id.price_et);

        String product = product_et.getText().toString();
        String barcode = barcode_et.getText().toString();
        String price = price_et.getText().toString();


        Intent intent = new Intent();
        intent.putExtra("product", product);
        intent.putExtra("barcode", barcode);
        intent.putExtra("price", price);

        setResult(Activity.RESULT_OK,intent);
        finish();
        
    }
}
