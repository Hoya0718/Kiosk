package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk04);
    }

    public void goto_kiosk_03(View v){
        Intent goto_kiosk_03 = new Intent(getApplicationContext(), Kiosk_3.class);
        startActivity(goto_kiosk_03);
    }

    public void goto_kiosk_05(View v) {
        Intent goto_kiosk_05 = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }
}