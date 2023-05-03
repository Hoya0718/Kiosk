package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Kiosk_7_b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_b);
    }

    public void goto_kiosk_05(View v){
        Intent goto_kiosk_05 = new Intent(getApplicationContext(),Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void goto_kiosk_07_s(View v){
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void goto_kiosk_07_d(View v){
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }

    public void goto_kiosk_09(View v){
        Intent goto_kiosk_09 = new Intent(getApplicationContext(),Kiosk_9.class);
        startActivity(goto_kiosk_09);
    }
}