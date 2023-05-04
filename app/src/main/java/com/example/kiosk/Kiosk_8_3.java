package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_8_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_3);
    }

    public void popup_kiosk_08_4(View view) {
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void popup_kiosk_08_2(View view) {
        Intent popup_kiosk_08_2 = new Intent(getApplicationContext(), Kiosk_8_2.class);
        startActivity(popup_kiosk_08_2);
    }
}