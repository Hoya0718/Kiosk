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

import java.util.Locale;

public class Kiosk_R_Bus_Congratulations extends AppCompatActivity {
    private Button b_backbegin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_congratulations);

        myapp myApp = (myapp) getApplicationContext();

        long beforeTime;
        long afterTime;
        long measTime;
        long minutes;
        long seconds;

        if (myApp.getPracticeBusCheck()) {
            beforeTime = myApp.getP_Time();
            afterTime = System.currentTimeMillis();
            measTime = (afterTime - beforeTime) / 1000;

            minutes = measTime / 60; // 분 계산
            seconds = measTime % 60; // 초 계산
        } else {
            beforeTime = myApp.getR_Time();
            afterTime = System.currentTimeMillis();
            measTime = (afterTime - beforeTime) / 1000;

            minutes = measTime / 60; // 분 계산
            seconds = measTime % 60; // 초 계산
        }

        b_backbegin_btn = findViewById(R.id.b_backbegin_btn);
        if (myApp.getPracticeBusCheck()) {

        } else if (myApp.getMissionCheck()) {
            b_backbegin_btn.setText("예매 소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "임무 성공 여부 : " + "실패" + "\n" +
                    "처음으로 돌아가기");
        } else {
            b_backbegin_btn.setText("예매 소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "처음으로 돌아가기");
        }

        b_backbegin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Congratulations.this, Kiosk_R_Part.class);
                startActivity(intent);
            }

        });

    }
}

