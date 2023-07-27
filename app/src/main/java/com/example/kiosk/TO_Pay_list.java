 package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class TO_Pay_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_pay_list);
    }
     public void goto_pay(View v){
         Intent goto_pay = new Intent(getApplicationContext(), TO_Pay.class);
         startActivity(goto_pay);
     }
}