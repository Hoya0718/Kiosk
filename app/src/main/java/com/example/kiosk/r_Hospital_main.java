package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_Hospital_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_main);
    }

    public void goto_kiosk_main(View  v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_kiosk_main);
    }
    public void goto_medical_record(View v){
        Intent goto_medical_record = new Intent(getApplicationContext(), r_Hospital_Medical_Record.class);
        startActivity(goto_medical_record);
    }
    public void goto_prescription(View v){
        Intent goto_prescription = new Intent(getApplicationContext(), r_Hospital_Prescription.class);
        startActivity(goto_prescription);
    }
}