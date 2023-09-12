package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_To_Issuance_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_issuance_info);
    }

    public void goto_add(View v){
        Intent goto_add = new Intent(getApplicationContext(), r_To_Add.class);
        startActivity(goto_add);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void goto_to_ssn2(View v){
        Intent goto_to_ssn2 = new Intent(getApplicationContext(), r_To_Ssn2.class);
        startActivity(goto_to_ssn2);
    }
}