package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Hospital_Pay_Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_pay_complete);
    }
    public void goto_Kiosk_R_H_C (View v){
        Intent goto_Kiosk_R_H_C = new Intent(getApplicationContext(), Kiosk_R_Congratulations.class);
        startActivity(goto_Kiosk_R_H_C);
        finish();
    }
}