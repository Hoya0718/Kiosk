package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_Card_Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_card_insert);
    }

    public void goto_to_Main(View v){
        Intent goto_to_Main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_Main);
    }
}