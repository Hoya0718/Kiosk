package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_R_Congratulations extends AppCompatActivity {

    private Button concon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_congratulations);

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getTime();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        long minutes = measTime / 60; // 분 계산
        long seconds = measTime % 60; // 초 계산

        concon = findViewById(R.id.concon);
        if (myApp.getCheckCheck()) {
            concon.setText("수납 소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "임무 성공 여부 : " + "실패" + "\n" +
                    "처음으로 돌아가기");
        } else {
            concon.setText("수납 소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "처음으로 돌아가기");
        }
    }
    public void goto_Kiosk_R_P(View v){
        Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_Kiosk_R_P);
    }
}