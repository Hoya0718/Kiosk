package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Hospital_Receipt_Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_receipt_complete);
    }

    public void goto_Kiosk_Main(View v){
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_Main);
        finish();
    }

    public void goto_Back(View v){
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Receipt.class);
        startActivity(goto_Back);
        finish();
    }
    public void goto_Kiosk_R_H_R(View v){
        Intent goto_Kiosk_R_H_R = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_R_H_R);
        finish();
    }
}