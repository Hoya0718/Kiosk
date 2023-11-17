package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class r_To_Ssn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_ssn);
    }
    public void goto_SSN2(View v){
        Intent goto_SSN2 = new Intent(getApplicationContext(), r_To_Ssn2.class);
        startActivity(goto_SSN2);
    }

    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void n_sup(View v){
        Toast.makeText(getApplicationContext(), "지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}