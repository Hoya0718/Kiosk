package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_R_Bus_Congratulations extends AppCompatActivity {
    private Button concon;
    private TextView con_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_congratulations);

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");
        String departuretime = intent.getStringExtra("departuretime");
        String seat = intent.getStringExtra("seat");

        String text = destination + " - " + departuretime + " - " + seat;

        String checkMission = myApp.getCheckHospitalMission();
        String missionComplete = "실패";

        if (text.equals(checkMission)) {
            missionComplete = "성공";
        }

        con_text = findViewById(R.id.con_text);
        if (myApp.getPracticeFastfoodCheck()) {
            long pTime = myApp.getR_B_Time();
            long diffTime;
            if (pTime > measTime) {
                diffTime = pTime - measTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요");
            } else {
                diffTime = measTime - pTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요");
            }
            if (measTime < myApp.getR_B_Time()){
                myApp.setR_B_Time(measTime);
            }
        } else if (myApp.getR_B_Time() != 0) {
            long rTime = myApp.getR_B_Time();
            long diffTime;
            if (rTime > measTime) {
                diffTime = rTime - measTime;
                con_text.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요");
            } else {
                diffTime = measTime - rTime;
                con_text.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요");
            }
            if (measTime < myApp.getR_B_Time()){
                myApp.setR_B_Time(measTime);
            }
        } else {
            con_text.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초");
            myApp.setR_B_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = con_text.getText().toString();
            String appendedText = currentText + "\n임무 성공 여부 : " + missionComplete;
            con_text.setText(appendedText);
        }

        concon = findViewById(R.id.concon);
        concon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Congratulations.this, Kiosk_R_Part.class);
                startActivity(intent);
            }

        });
    }
    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}

