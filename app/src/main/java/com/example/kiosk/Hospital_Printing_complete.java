package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Hospital_Printing_complete extends AppCompatActivity {

    private static final long DELAY_MILLIS = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_printing_complete);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Hospital_Main.class);
                startActivity(intent);
                finish(); // 현재 화면을 종료합니다. (선택사항)
            }
        }, DELAY_MILLIS);
    }
}