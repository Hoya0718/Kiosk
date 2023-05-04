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

    public void goto_kiosk_06(View v){
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_10(View v) {
        Intent goto_kiosk_10 = new Intent(getApplicationContext(), Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }
}