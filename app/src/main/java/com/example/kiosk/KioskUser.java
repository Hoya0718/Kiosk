package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class KioskUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_user);
    }

    public void goto_kiosk_main(View v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), KioskMain.class);
        startActivity(goto_kiosk_main);
    }

    public void goto_kiosk_join(View v){
        Intent goto_kiosk_join = new Intent(getApplicationContext(), KioskJoin.class);
        startActivity(goto_kiosk_join);
    }
}
