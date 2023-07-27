package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_SSN2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_ssn2);
    }

    public void goto_II(View v){
        Intent goto_II = new Intent(getApplicationContext(), TO_Issuance_info.class);
        startActivity(goto_II);
    }
}