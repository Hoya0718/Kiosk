package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk10);
    }

    public void goto_kiosk_05(View v){
        Intent goto_kiosk_05 = new Intent(getApplicationContext(),Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void goto_kiosk_11(View v){
        Intent goto_kiosk_11 = new Intent(getApplicationContext(),Kiosk_11.class);
        startActivity(goto_kiosk_11);
    }
}