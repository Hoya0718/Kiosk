package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_30_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30_2);
    }
    public void goto_kiosk_31(View v){
        Intent goto_kiosk_31 = new Intent(this, Kiosk_31.class);
        startActivity(goto_kiosk_31);
    }
}