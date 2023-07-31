package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Kiosk_R_Fastfood_End_3 extends AppCompatActivity {

    private static final long DELAY_MS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_end_3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Kiosk_R_Fastfood_End_3.this, Kiosk_R_Fastfood_End_2.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MS);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}