package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_SSN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_ssn);
    }

    public void goto_SSN2(View v){
        Intent goto_SSN2 = new Intent(getApplicationContext(), TO_SSN2.class);
        startActivity(goto_SSN2);
    }
}