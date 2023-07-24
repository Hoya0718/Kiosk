package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hospital_Medical_Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);
    }

    public void goto_Hospital_Main(View v) {
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), Hospital_Main.class);
        startActivity(goto_Hospital_Main);
    }
}