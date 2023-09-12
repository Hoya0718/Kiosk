package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_Hospital_Pay_Remove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_pay_remove);
    }
    public void goto_printing(View v){
        Intent goto_printing = new Intent(getApplicationContext(), r_Hospital_Printing.class);
        startActivity(goto_printing);
    }
}