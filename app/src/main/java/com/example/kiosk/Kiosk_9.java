package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk09);
    }

    public void goto_kiosk_05(View v){
        Intent goto_kiosk_05 = new Intent(getApplicationContext(),Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void goto_kiosk_07_b(View v){
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_10(View v) {
        Intent goto_kiosk_10 = new Intent(getApplicationContext(), Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }
}