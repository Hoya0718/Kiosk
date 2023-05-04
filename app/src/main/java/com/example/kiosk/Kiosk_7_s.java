package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_7_s extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_s);
    }

    public void goto_kiosk_06(View v){
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_07_b(View v){
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_07_d(View v){
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }
}