package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    TextView product_tv, barcode_tv, price_tv;

    public static final int PRODUCT_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        product_tv = (TextView) findViewById(R.id.product_tv);
        barcode_tv = (TextView) findViewById(R.id.barcode_tv);
        price_tv = (TextView) findViewById(R.id.price_tv);

    }

    public void getItem(View v){
        //Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ProductItemActivity.class);
        startActivityForResult(intent,RelativeLayoutActivity.PRODUCT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ( resultCode == Activity.RESULT_OK) {
            if ( requestCode == RelativeLayoutActivity.PRODUCT_REQUEST_CODE ) {

                String product = data.getExtras().getString("product");
                String barcode = data.getExtras().getString("barcode");
                String price = data.getExtras().getString("price");

                product_tv.setText(product);
                barcode_tv.setText(barcode);
                price_tv.setText(price);
            }
        }

    }
}
