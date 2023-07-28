package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Kiosk_R_Fastfood_Plus extends AppCompatActivity {

    private int value;
    private int total;

    private TextView total_text;

    private static final long DELAY_MS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_plus);

        total_text = findViewById(R.id.total_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
            total = intent.getIntExtra("plus", 0);

            total_text.setText(String.valueOf(total));
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Kiosk_R_Fastfood_Plus.this, Kiosk_R_Fastfood_Menu_Burger.class);
                intent.putExtra("value", value);
                startActivity(intent);
                finish(); // 현재 액티비티를 종료하여 뒤로가기 버튼을 눌렀을 때 다시 돌아오지 않도록 함
            }
        }, DELAY_MS);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}