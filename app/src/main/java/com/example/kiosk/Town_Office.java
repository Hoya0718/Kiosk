package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Town_Office extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_office);
    }

    public void goto_SSN(View v){
        Intent goto_SSN = new Intent(getApplicationContext(), TO_SSN.class);
        startActivity(goto_SSN);
    }
}