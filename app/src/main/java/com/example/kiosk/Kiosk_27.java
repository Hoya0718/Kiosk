package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_27 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk27);
    }
    public void goto_kiosk_28(View v) {
        Intent goto_kiosk_28 = new Intent(getApplicationContext(), Kiosk_28.class);
        startActivity(goto_kiosk_28);
    }
}