package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk03);
    }

    public void goto_kiosk_02(View v){
        Intent goto_kiosk_02 = new Intent(getApplicationContext(), Kiosk_2.class);
        startActivity(goto_kiosk_02);
    }

    public void goto_kiosk_04(View v) {
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }
}