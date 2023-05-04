package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_8_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_6);
    }

    public void popup_kiosk_08_7(View view) {
        Intent popup_kiosk_08_7 = new Intent(getApplicationContext(), Kiosk_8_7.class);
        startActivity(popup_kiosk_08_7);
    }

    public void goto_kiosk_06(View view) {
        Intent popup_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(popup_kiosk_06);
    }
}