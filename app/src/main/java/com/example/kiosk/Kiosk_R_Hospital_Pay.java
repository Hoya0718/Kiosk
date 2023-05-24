package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Hospital_Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_pay);
    }
    public void goto_Kiosk_R_H_P_C(View v){
        Intent goto_Kiosk_R_H_P_C = new Intent(getApplicationContext(), Kiosk_R_Hospital_Pay_Complete.class);
        startActivity(goto_Kiosk_R_H_P_C);
    }
    public void goto_Back(View v) {
        Intent goto_Kiosk_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Acceptance_Complete.class);
        startActivity(goto_Kiosk_Back);
    }
}