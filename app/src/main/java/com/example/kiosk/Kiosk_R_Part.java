package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Part extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_part);
    }

    public void goto_Kiosk_R_F_M (View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_Bus (View v){
        Intent goto_Kiosk_R_Bus = new Intent(getApplicationContext(),Kiosk_R_Bus_Main.class);
        startActivity(goto_Kiosk_R_Bus);
    }
    public void goto_Kiosk_R_Hospital (View v){
        Intent goto_Kiosk_R_Hospital = new Intent(getApplicationContext(),Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_R_Hospital);
    }

    public void goto_Kiosk_Main (View v){
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
    }

}