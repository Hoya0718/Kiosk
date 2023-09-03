package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class get_WaitingNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_waiting_num);


    }
    public void goto_main(View view){
        Intent goto_main = new Intent(getApplicationContext(), Hospital_Main.class);
        startActivity(goto_main);
    }
}