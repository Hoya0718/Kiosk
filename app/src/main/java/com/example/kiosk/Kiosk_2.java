package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk02);

    }
    public void goto_main(View v){
        Intent goto_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_main);
    }
    public void goto_kiosk_03(View v){
        Intent goto_kiosk_03 = new Intent(getApplicationContext(), Kiosk_3.class);
        startActivity(goto_kiosk_03);
    }
}