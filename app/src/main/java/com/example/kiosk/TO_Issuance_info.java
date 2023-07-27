package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_Issuance_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_issuance_info);
    }

    public void goto_add(View v){
        Intent goto_add = new Intent(getApplicationContext(), TO_ADD.class);
        startActivity(goto_add);
    }
}