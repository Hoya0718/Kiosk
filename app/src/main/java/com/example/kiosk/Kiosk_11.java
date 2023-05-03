package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk11);
    }

    public void goto_kiosk_10(View v){
        Intent goto_kiosk_10 = new Intent(getApplicationContext(),Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }

    public void goto_kiosk_12(View v){
        Intent goto_kiosk_12 = new Intent(getApplicationContext(),Kiosk_12.class);
        startActivity(goto_kiosk_12);
    }
}