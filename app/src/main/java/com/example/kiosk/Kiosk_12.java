package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk12);
    }

    public void goto_kiosk_13(View v){
        Intent goto_kiosk_13 = new Intent(getApplicationContext(),Kiosk_13.class);
        startActivity(goto_kiosk_13);
    }
}