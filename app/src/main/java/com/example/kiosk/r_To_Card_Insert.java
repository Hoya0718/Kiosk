package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_To_Card_Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_card_insert);
    }
    public void goto_to_Main(View v){
        Intent goto_to_Main = new Intent(getApplicationContext(), r_To_misson.class);
        goto_to_Main.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_to_Main);
    }
}