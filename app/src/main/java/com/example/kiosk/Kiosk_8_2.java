package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_8_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_2);
    }

    public void popup_kiosk_08_3(View view) {
        Intent popup_kiosk_08_3 = new Intent(getApplicationContext(), Kiosk_8_3.class);
        startActivity(popup_kiosk_08_3);
    }

    public void popup_kiosk_08_1(View view) {
        Intent popup_kiosk_08_1 = new Intent(getApplicationContext(), Kiosk_8_1.class);
        startActivity(popup_kiosk_08_1);
    }
}