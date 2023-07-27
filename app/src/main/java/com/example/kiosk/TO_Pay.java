package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_pay);
    }

    public void goto_card_Insert(View v){
        Intent goto_card_Insert = new Intent(getApplicationContext(), TO_Card_Insert.class);
        startActivity(goto_card_Insert);
    }
}