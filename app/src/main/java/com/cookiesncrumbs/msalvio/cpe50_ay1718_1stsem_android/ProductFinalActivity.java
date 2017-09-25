package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_final);

        TextView tv = (TextView) findViewById(R.id.final_tv);

        double ans = getIntent().getExtras().getDouble("ans");
        tv.setText(String.valueOf(ans));

    }
}
