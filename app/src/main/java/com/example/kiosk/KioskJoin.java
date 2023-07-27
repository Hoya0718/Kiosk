package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class KioskJoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_join);
    }

    public void goto_kiosk_user(View v){
        Intent goto_kiosk_user = new Intent(getApplicationContext(), KioskUser.class);
        startActivity(goto_kiosk_user);
    }
}
