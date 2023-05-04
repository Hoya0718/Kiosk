package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_29_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29_2);
    }
    public void goto_kiosk_30(View v){
        Intent goto_kiosk_30 = new Intent(this, Kiosk_30.class);
        startActivity(goto_kiosk_30);
    }
}