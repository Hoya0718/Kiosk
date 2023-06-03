package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Kiosk_R_Hospital_Receipt_Congratulation extends AppCompatActivity {

    private Button kiosk_r_hospital_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_receipt_congratulatoin);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getTime();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        long minutes = measTime / 60; // 분 계산
        long seconds = measTime % 60; // 초 계산

        String checkMission = myApp.getCheckHospitalMission();
        String missionComplete = "실패";

        if (text == checkMission) {
            missionComplete = "성공";
        }

        kiosk_r_hospital_btn = findViewById(R.id.kiosk_r_hospital_btn);
        if (myApp.getCheckCheck()) {
            kiosk_r_hospital_btn.setText("소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "임무 성공 여부 : " + missionComplete + "\n" +
                    "처음으로 돌아가기");
        } else {
            kiosk_r_hospital_btn.setText("소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "처음으로 돌아가기");
        }
    }

    public void goto_Kiosk_R_H(View v){
        Intent goto_Kiosk_R_H = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), Kiosk_R_Part.class);


        myapp myApp = (myapp) getApplicationContext();
        if(myApp.getCheckCheck()){
            myApp.setCheckHospitalMission("X");
            myApp.setCheckCheck(false);
            startActivity(goto_Kiosk_R_P);
        }
        myApp.setCheckHospitalMission("X");
        myApp.setCheckCheck(false);
        startActivity(goto_Kiosk_R_H);
    }
}