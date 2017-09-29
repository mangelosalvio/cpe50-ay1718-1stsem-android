package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ProductFinalActivity extends AppCompatActivity {

    double ans;
    EditText payment_amount_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_final);

        TextView tv = (TextView) findViewById(R.id.final_tv);

        ans = getIntent().getExtras().getDouble("ans");

        DecimalFormat decimalFormatter = new DecimalFormat("###,###,###,###.00");
        tv.setText(decimalFormatter.format(ans));

        payment_amount_et = (EditText) findViewById(R.id.payment_amount_et);


    }

    public void process(View v) {
        double payment_amount = Double.parseDouble(payment_amount_et.getText().toString());
        
        if ( payment_amount < ans ) {
            Toast.makeText(this, "Unable to process payment", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("change", payment_amount - ans);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        

    }
}
