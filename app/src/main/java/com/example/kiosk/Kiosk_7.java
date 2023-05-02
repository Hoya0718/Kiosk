package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07);
    }

    public void goto_kiosk_05(View v){
        Intent goto_kiosk_05 = new Intent(getApplicationContext(),Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void goto_kiosk_08(View v){
        Intent goto_kiosk_08 = new Intent(getApplicationContext(),Kiosk_8.class);
        startActivity(goto_kiosk_08);
    }

    public void goto_kiosk_09(View v){
        Intent goto_kiosk_09 = new Intent(getApplicationContext(),Kiosk_9.class);
        startActivity(goto_kiosk_09);
    }

    public void goto_kiosk_10(View v){
        Intent goto_kiosk_10 = new Intent(getApplicationContext(),Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }
}