package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void show(View v){
        EditText et = (EditText) findViewById(R.id.field_et);
        TextView tv = (TextView) findViewById(R.id.label_tv);

        String message  = et.getText().toString();

        tv.setText(message);
    }
}
