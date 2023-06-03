package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Hospital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital);

        myapp myApp = (myapp) getApplicationContext();
        if (!myApp.getCheckCheck()){
            myApp.setTime(System.currentTimeMillis());
        }
    }

    public void goto_Kiosk_R_H_Receipt(View v){
        Intent goto_Kiosk_R_H_Receipt = new Intent(getApplicationContext(), Kiosk_R_Hospital_Receipt.class);
        startActivity(goto_Kiosk_R_H_Receipt);

    }

    public void goto_Kiosk_R_H_Acceptance(View v){
        Intent goto_Kiosk_R_H_Acceptance = new Intent(getApplicationContext(), Kiosk_R_Hospital_Acceptance.class);
        startActivity(goto_Kiosk_R_H_Acceptance);

    }
    public void goto_Back(View v){
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Part.class);

        myapp myApp = (myapp) getApplicationContext();
        myApp.setCheckHospitalMission("X");
        myApp.setCheckCheck(false);

        startActivity(goto_Back);

    }
}