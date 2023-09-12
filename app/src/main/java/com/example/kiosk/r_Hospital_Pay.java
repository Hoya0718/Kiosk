package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_Hospital_Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_pay);
    }
    public void goto_pay_remove(View v){
        Intent goto_pay_remove = new Intent(getApplicationContext(), r_Hospital_Pay_Remove.class);
        startActivity(goto_pay_remove);
    }
}