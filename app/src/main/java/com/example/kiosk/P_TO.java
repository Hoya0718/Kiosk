package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class P_TO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pto);
    }
    public void goto_Main(View v){
        Intent goto_Main = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_Main);
    }

    public void goto_SSN(View v){
        Intent goto_SSN = new Intent(getApplicationContext(), r_To_Ssn.class);
        startActivity(goto_SSN);
    }
    public void n_sup(View v){
        Toast.makeText(getApplicationContext(), "지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}