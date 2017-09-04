package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void transfer(View v){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
}
