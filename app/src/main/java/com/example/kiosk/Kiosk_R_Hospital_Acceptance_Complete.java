package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Kiosk_R_Hospital_Acceptance_Complete extends AppCompatActivity {

    private CheckBox check_Money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_acceptance_complete);

        check_Money = (findViewById(R.id.check_Money));

    }

    public void goto_Kiosk_R_H_P(View v){
        if(check_Money.isChecked()) {
            Intent goto_Kiosk_R_H_P = new Intent(this, Kiosk_R_Hospital_Pay.class);
            startActivity(goto_Kiosk_R_H_P);
        }
        else
        if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
            Toast.makeText(getApplicationContext(), "수납여부를 확인해주세요", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Check CheckBox", Toast.LENGTH_LONG).show();
        }
    }
    public void goto_Kiosk_H_Main(View v){
        Intent goto_Kiosk_H_Main = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_H_Main);
        finish();
    }
    public void goto_Back(View v) {
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Acceptance.class);
        startActivity(goto_Back);
        finish();
    }
}