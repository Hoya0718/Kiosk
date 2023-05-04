package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_7_d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_d);
    }

    public void goto_kiosk_06(View v){
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_07_b(View v){
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_07_s(View v){
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void popup_kiosk_08_1(View view) {

    }

    public void popup_kiosk_08_7(View view) {

    }

    public void goto_kiosk_09(View v){
        Intent goto_kiosk_09 = new Intent(getApplicationContext(),Kiosk_9.class);
        startActivity(goto_kiosk_09);
    }
}