package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk06);
    }
    public void goto_kiosk_07(View v){
        Intent goto_kiosk_07 = new Intent(getApplicationContext(),Kiosk_7.class);
        startActivity(goto_kiosk_07);
    }
}