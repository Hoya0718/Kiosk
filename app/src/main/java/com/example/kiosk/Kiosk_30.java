package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_30 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30);
    }
    public void goto_kiosk_30_2(View v) {
        Intent goto_kiosk_30_2 = new Intent(getApplicationContext(), Kiosk_30_2.class);
        startActivity(goto_kiosk_30_2);
    }
}