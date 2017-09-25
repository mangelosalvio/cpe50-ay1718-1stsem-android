package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void transfer(View v){
        if ( v.getId() == R.id.first_app_button ) {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        } else if ( v.getId() == R.id.list_app_button ) {
            Intent intent = new Intent(this, SampleListActivity.class);
            startActivity(intent);
        } else if ( v.getId() == R.id.list_act1_button) {
            Intent intent = new Intent(this, SimpleListActivity.class);
            startActivity(intent);
        } else if ( v.getId() == R.id.quiz_2_button) {
            Intent intent = new Intent(this, BarcodeActivity.class);
            startActivity(intent);
        } else if ( v.getId() == R.id.relative_layout_button) {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            startActivity(intent);
        }

    }
}
